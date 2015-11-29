package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Game;

public class RestoreHealth extends Task<ClientContext> {
    private int maxHealth = ctx.skills.realLevel(Constants.SKILLS_HITPOINTS);

    public RestoreHealth(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        int currentHealth = Integer.parseInt(ctx.widgets.component(160, 5).text());
        return currentHealth < maxHealth * Resources.eatThreshold;
    }

    @Override
    public void execute() {
        Resources.status = "Eating food";

        ctx.game.tab(Game.Tab.INVENTORY);

        if(ctx.inventory.select().id(Resources.FOOD_IDS).poll().click()) {
            Condition.sleep(600);
        }
    }
}
