package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.powerbot.Con;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class TalkClue extends Clue {
    public int npc;

    public TalkClue(int id, Location location, int npc) {
        super(id, location);
        this.npc = npc;
    }

    @Override
    public boolean canSolve(ClientContext ctx) {
        return true;
    }

    @Override
    public boolean solve(ClientContext ctx) {
        if(!location.area.contains(ctx.players.local())) {
            return false;
        }

        if(!ctx.npcs.select().id(npc).isEmpty()) {
            ctx.npcs.poll().interact("Talk-to");
            Condition.sleep(600);
            ctx.widgets.component(231, 2).click();
            Condition.sleep(600);
        }

        return false;
    }
}
