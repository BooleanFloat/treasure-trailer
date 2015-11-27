package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.Path;
import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.kandarin.Catherby;
import org.booleanfloat.treasuretrailer.clues.Clue;
import org.booleanfloat.treasuretrailer.clues.DigClue;
import org.booleanfloat.treasuretrailer.clues.TalkClue;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.HashMap;

public class SolveClue extends Task<ClientContext> {
    private Path path;
    private HashMap<Integer, Clue> clues;

    public SolveClue(ClientContext ctx) {
        super(ctx);

        clues = new HashMap<Integer, Clue>();

        clues.put(2701, new TalkClue(2701, Catherby.GeneralStore, Resources.ARHEIN_ID));
        clues.put(2719, new DigClue(2719, Falador.NorthFencedStones, new Tile(3043, 3398, 0)));
    }

    @Override
    public boolean activate() {
        return !ctx.inventory.select().id(Resources.CLUE_IDS).isEmpty();
    }

    @Override
    public void execute() {
        Resources.hasClue = true;
        Resources.status = "Solving clue";

        Clue clue = clues.get(ctx.inventory.poll().id());

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
