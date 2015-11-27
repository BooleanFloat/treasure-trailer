package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

import java.util.concurrent.Callable;

public class Pickpocket extends Task<ClientContext> {
    public Pickpocket(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !Resources.isStunned
                && !Resources.isDropping
                && !Resources.hasClue
                && ctx.inventory.select().count() != 28
                && Lumbridge.HamBarracks.area.contains(ctx.players.local());
    }

    @Override
    public void execute() {
        Resources.status = "Pickpocketing";

        Npc HamMember = ctx.npcs.select().id(Resources.HAM_MEMBERS_IDS).nearest().poll();

        if(HamMember.interact("Pickpocket")) {
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.players.local().animation() == -1;
                }
            }, 500, 6);
        }
    }
}
