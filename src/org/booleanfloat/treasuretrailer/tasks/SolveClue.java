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
        if(currentClue == null || currentClue.getId() != clue.getId()) {
            currentClue = clue;
            Resources.hasSeenClue = false;
            return;
        }

        if(!clue.canSolve(ctx)) {
            System.out.println("drop clue");
        }

        if(!clue.getLocation().area.contains(ctx.players.local())) {
            if(path == null) {
                path = Traveler.getPath(ctx.players.local().tile(), clue.getLocation());
            }

            if(path.traverse(ctx)) {
                Condition.wait(Traveler.getConditionWaiter(ctx, path), 1000, 8);
                return;
            }
        }
        else {
            clue.solve(ctx);
            Condition.sleep(1000);
        }
    }
}
