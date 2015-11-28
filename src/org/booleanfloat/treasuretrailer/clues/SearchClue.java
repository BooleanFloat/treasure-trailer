package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class SearchClue extends Clue {
    public enum type {
        BOXES, DRAWERS
    }

    private int objectId;
    private Tile objectTile;

    public SearchClue(int id, Location location, int objectId) {
        super(id, location);
        this.objectId = objectId;
    }

    public SearchClue(int id, Location location, int objectId, Tile objectTile) {
        this(id, location, objectId);
        this.objectTile = objectTile;
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

        if(objectTile == null) {
            return ctx.objects.select().id(objectId).nearest().poll().interact("Search");
        }
        else {
            return ctx.objects.select().id(objectId).at(objectTile).poll().interact("Search");
        }
    }
}
