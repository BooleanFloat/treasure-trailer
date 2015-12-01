package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Game;

import java.util.concurrent.Callable;

public class EmoteClue extends Clue {
    private int[] itemIds;
    private Resources.Emote emote;
    private boolean equipNothing;

    public EmoteClue(int id, Location location, Resources.Emote emote, int[] itemIds) {
        this(id, location, emote, itemIds, null);
    }

    public EmoteClue(int id, Location location, Resources.Emote emote, int[] itemIds, Callable<Boolean> requirement) {
        super(id, location, requirement);

        this.itemIds = itemIds;
        this.emote = emote;
        this.equipNothing = false;
    }

    public EmoteClue(int id, Location location, Resources.Emote emote, boolean equipNothing) {
        this(id, location, emote, equipNothing, null);
    }

    public EmoteClue(int id, Location location, Resources.Emote emote, boolean equipNothing, Callable<Boolean> requirement) {
        super(id, location, requirement);

        this.itemIds = new int[0];
        this.emote = emote;
        this.equipNothing = equipNothing;
    }

    @Override
    public boolean canSolve(ClientContext ctx) {
        if(equipNothing) {
            return true;
        }

        return true;
    }

    @Override
    public boolean solve(ClientContext ctx) {
        if(!location.area.contains(ctx.players.local())) {
            return false;
        }

        if(equipNothing) {
            while(ctx.equipment.count() > 0) {
                ctx.equipment.poll().click();
                Condition.sleep(750);
            }
        }
        else {
            if(ctx.equipment.select().id(itemIds).count() < itemIds.length) {
                ctx.game.tab(Game.Tab.INVENTORY);

                while(ctx.inventory.select().id(itemIds).count() > 0) {
                    ctx.inventory.poll().click();
                    Condition.sleep(750);
                }
            }
        }

        ctx.game.tab(Game.Tab.EMOTES);
        Condition.sleep(750);
        Component emoteComponent = ctx.widgets.widget(Resources.EMOTES_WIDGET_ID).component(1).component(Resources.EMOTES.get(emote));

        if(emoteComponent.visible()) {
            emoteComponent.click();
            Condition.sleep(750);
            ctx.npcs.select().id(Resources.URI_ID).nearest().poll().interact("Talk-to");
            Condition.sleep(750);
            ctx.widgets.component(231, 2).click();
            Condition.sleep(750);
            ctx.widgets.component(217, 2).click();
            Condition.sleep(750);
            ctx.widgets.component(193, 2).click();
            Condition.sleep(750);
            ctx.game.tab(Game.Tab.INVENTORY);

            return true;
        }

        return false;
    }
}
