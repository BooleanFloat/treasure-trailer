package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Widget;

import java.util.concurrent.Callable;

public class OpenClue extends Task<ClientContext> {
    public OpenClue(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !Resources.hasSeenClue
                && !ctx.inventory.select().id(Resources.CLUE_IDS).isEmpty();
    }

    @Override
    public void execute() {
        Resources.status = "Reading clue";
        Component clueClose = ctx.widgets.widget(Resources.CLUE_WIDGET_ID).component(1);

        if(!clueClose.visible()) {
            ctx.inventory.poll().click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return clueClose.visible();
                }
            }, 250, 4);
        }
        else {
            Resources.hasSeenClue = true;
            Condition.sleep(2000);
            clueClose.click();
        }
    }
}
