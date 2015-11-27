package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.Path;
import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class TraverseHamHideout extends Task<ClientContext> {
    private Path path;

    public TraverseHamHideout(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        boolean canActivate = !Resources.hasClue
                && !Lumbridge.HamBarracks.area.contains(ctx.players.local())
                && !Lumbridge.HamBarracks.area.contains(ctx.movement.destination());

        if(!canActivate) {
            path = null;
        }

        return canActivate;
    }

    @Override
    public void execute() {
        Resources.status = "Going to Ham hideout";

        if(path == null) {
            path = Traveler.getPath(ctx.players.local().tile(), Lumbridge.HamBarracks);
        }

        if(path.traverse(ctx)) {
            Condition.wait(Traveler.getConditionWaiter(ctx, path), 1000, 8);
        }
    }
}
