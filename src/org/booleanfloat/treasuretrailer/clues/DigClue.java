package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.concurrent.Callable;

public class DigClue extends Clue {

    private Tile tile;

    public DigClue(int id, Location location, Tile tile) {
        this(id, location, tile, null);
    }

    public DigClue(int id, Location location, Tile tile, Callable<Boolean> requirement) {
        super(id, location, requirement);
        this.tile = tile;
    }

    @Override
    public boolean canSolve(ClientContext ctx) {
        return !ctx.inventory.select().id(Resources.SPADE_ID).isEmpty();
    }

    @Override
    public boolean solve(ClientContext ctx) {
        if(!location.area.contains(ctx.players.local())) {
            return false;
        }

        if(!tile.equals(ctx.players.local().tile())) {
            return tile.matrix(ctx).click();
        }
        else {
            ctx.inventory.select().id(Resources.SPADE_ID).poll().click();
        }

        return false;
    }
}
