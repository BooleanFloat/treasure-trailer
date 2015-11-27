package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import java.util.ArrayList;

public class DropJunk extends Task<ClientContext> {
    public DropJunk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().animation() == -1
                && (Resources.isStunned || Resources.isDropping || ctx.inventory.select().count() == 28);
    }

    @Override
    public void execute() {
        Resources.status = "Dropping junk";

        Item item = ctx.inventory.select().id(Resources.HAM_JUNK).peek();

        if(ctx.inventory.select().count() == 28) {
            Resources.isDropping = true;
        }

        if(item.id() != -1) {
            item.interact("Drop");
            System.out.println(item.name());
            Condition.sleep(400);
        }
        else {
            Resources.isDropping = false;
        }
    }
}
