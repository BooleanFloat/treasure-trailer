package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Item;

public class DropJunk extends Task<ClientContext> {
    public DropJunk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Lumbridge.HamBarracks.area.contains(ctx.players.local())
                && (Resources.isStunned
                || Resources.isDropping
                || ctx.inventory.select().count() == 28
                || Resources.hasClue && ctx.inventory.select().id(Resources.HAM_JUNK_IDS).count() > 1);
    }

    @Override
    public void execute() {
        Resources.status = "Dropping junk";

        ctx.game.tab(Game.Tab.INVENTORY);

        Item item = ctx.inventory.select().id(Resources.HAM_JUNK_IDS).peek();

        if(ctx.inventory.select().count() == 28) {
            Resources.isDropping = true;
        }

        if(item.id() != -1) {
            item.interact("Drop");
            Condition.sleep(400);
        }
        else {
            Resources.isDropping = false;
        }
    }
}
