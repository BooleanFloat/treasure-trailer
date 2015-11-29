package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;

public class OpenCasket extends Task<ClientContext> {
    public OpenCasket(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.inventory.select().id(Resources.CASKET_IDS).isEmpty();
    }

    @Override
    public void execute() {
        ctx.game.tab(Game.Tab.INVENTORY);
        ctx.inventory.poll().click();
    }
}
