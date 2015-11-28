package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.Path;
import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.traveler.regions.asgarnia.Burthorpe;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.asgarnia.Taverly;
import org.booleanfloat.traveler.regions.kandarin.Catherby;
import org.booleanfloat.traveler.regions.kandarin.SeersVillage;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.regions.misthalin.Varrock;
import org.booleanfloat.traveler.regions.misthalin.VarrockCastle;
import org.booleanfloat.traveler.regions.misthalin.WizardsTower;
import org.booleanfloat.treasuretrailer.clues.*;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.HashMap;

public class SolveClue extends Task<ClientContext> {
    private Path path;
    private HashMap<Integer, Clue> clues;
    private int[] clueIds;

    public SolveClue(ClientContext ctx) {
        super(ctx);

        clues = new HashMap<>();

        clues.put(10212, new EmoteClue(10212, Burthorpe.GamesRoom, Resources.Emote.CHEER, true));
        clues.put(10218, new EmoteClue(10218, null, Resources.Emote.SPIN, new int[]{ Resources.GREEN_HAT, Resources.CREAM_ROBE_TOP, Resources.LEATHER_CHAPS }));
        clues.put(2716, new DigClue(2716, Varrock.SouthMineDigSpot, new Tile(3289, 3374, 0)));
        clues.put(2719, new DigClue(2719, Falador.NorthFencedStones, new Tile(3043, 3398, 0)));
        clues.put(3518, new DigClue(3518, WizardsTower.DigSpot, new Tile(3110, 3152, 0)));
        clues.put(7236, new DigClue(7236, Falador.NorthSquare, new Tile(2970, 3414, 0)));
        clues.put(2682, new SearchClue(2682, AlKharid.NorthHouse, 358));
        clues.put(2694, new SearchClue(2694, Falador.ChainMailStore, 348, new Tile(2969, 3311, 0)));
        clues.put(3509, new SearchClue(3509, SeersVillage.SouthHouse, 25775));
        clues.put(3515, new SearchClue(3515, VarrockCastle.Kitchen, 2608));
        clues.put(12185, new SearchClue(12185, Burthorpe.Pub, 354, new Tile(2913, 3536, 0)));
        clues.put(2684, new TalkClue(2684, AlKharid.Tanner, Resources.ELLIS_ID));
        clues.put(2701, new TalkClue(2701, Catherby.GeneralStore, Resources.ARHEIN_ID));

        clueIds = new int[clues.size()];
        Object[] keys = clues.keySet().toArray();
        for(int i = 0; i < keys.length; i++) {
            clueIds[i] = (int) keys[i];
        }
    }

    @Override
    public boolean activate() {
        return !ctx.inventory.select().id(clueIds).isEmpty();
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
