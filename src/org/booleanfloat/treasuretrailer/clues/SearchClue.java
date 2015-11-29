package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class SearchClue extends Clue {
    public enum type {
        BOXES, DRAWERS
    }

    private int[] objectIds;
    private Tile objectTile;

    public SearchClue(int id, Location location, int objectId) {
        super(id, location);
        this.objectIds = new int[]{ objectId };
    }

    public SearchClue(int id, Location location, int objectId1, int objectId2) {
        super(id, location);
        this.objectIds = new int[] { objectId1, objectId2 };
    }

    public SearchClue(int id, Location location, int objectId, Tile objectTile) {
        this(id, location, objectId);
        this.objectTile = objectTile;
    }

    public SearchClue(int id, Location location, int objectId1, int objectId2, Tile objectTile) {
        this(id, location, objectId1, objectId2);
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
            System.out.println(ctx.objects.select().id(objectIds).nearest().poll());
            return ctx.objects.select().id(objectIds).nearest().poll().click();
        }
        else {
            return ctx.objects.select().id(objectIds).at(objectTile).poll().click();
        }
    }
}
