package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Widget;

import java.util.concurrent.Callable;

public class OpenClue extends Task<ClientContext> {
    public OpenClue(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !Resources.hasSeenClue
                && !Resources.isDropping
                && !ctx.inventory.select().id(Resources.CLUE_IDS).isEmpty();
    }

    @Override
    public void execute() {
        Resources.status = "Reading clue";

        ctx.game.tab(Game.Tab.INVENTORY);

        Widget widget = ctx.widgets.select().id(Resources.CLUE_WIDGET_IDS).select(new Filter<Widget>() {
            @Override
            public boolean accept(Widget widget) {
                return widget.component(0).visible();
            }
        }).first().poll();

        if(widget.id() == 0 || !widget.component(0).visible()) {
            ctx.inventory.poll().click();
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return widget.component(0).visible();
                }
            }, 250, 4);
        }
        else {
            Component closeButton = null;
            for(Component component : widget.components()) {
                if(component.textureId() == 539) {
                    closeButton = component;
                    break;
                }
            }

            Resources.hasSeenClue = true;
            Condition.sleep(2000);

            if(closeButton != null) {
                closeButton.click();
            }
        }
    }
}
