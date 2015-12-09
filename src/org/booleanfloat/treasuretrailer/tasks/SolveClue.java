package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.Path;
import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.treasuretrailer.clues.*;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class SolveClue extends Task<ClientContext> {
    private Path path;
    private Clue currentClue;

    public SolveClue(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Resources.hasSeenClue
                && !ctx.inventory.select().id(Resources.CLUE_IDS).isEmpty();
    }

    @Override
    public void execute() {
        Resources.hasClue = true;
        Resources.status = "Solving clue";

        Clue clue = Resources.CLUES.get(ctx.inventory.select().id(Resources.CLUE_IDS).poll().id());
        if(clue == null) {
            Resources.hasClue = false;
            Resources.hasSeenClue = false;
            currentClue = null;
            return;
        }
        if(currentClue == null || currentClue.getId() != clue.getId()) {
            path = null;
            currentClue = clue;
            Resources.hasSeenClue = false;
            return;
        }

        if(!Resources.hasSeenClue) {
            path = null;
            return;
        }

        if(!clue.canSolve(ctx) || !clue.hasRequirements()) {
            System.out.println("drop clue");
            ctx.inventory.select().id(Resources.CLUE_IDS).poll().interact("Drop");
            Resources.hasClue = false;
            Resources.hasSeenClue = false;
            currentClue = null;
            Condition.sleep(500);
            return;
        }

        if(!clue.getLocation().area.contains(ctx.players.local())) {
            if(path == null) {
                path = Traveler.getPath(ctx.players.local().tile(), clue.getLocation());
            }

            if(path.traverse(ctx)) {
                Condition.wait(Traveler.getConditionWaiter(ctx, path), 500, 8);
                return;
            }
        }
        else {
            clue.solve(ctx);
            Condition.sleep(1000);
        }
    }
}
