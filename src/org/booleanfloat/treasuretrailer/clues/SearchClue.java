package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.concurrent.Callable;

public class SearchClue extends Clue {
    private int[] objectIds;
    private Tile objectTile;

    public SearchClue(int id, Location location, int[] objectIds) {
        super(id, location);
        this.objectIds = objectIds;
    }

    public SearchClue(int id, Location location, int[] objectIds, Callable<Boolean> requirement) {
        super(id, location, requirement);
        this.objectIds = objectIds;
    }

    public SearchClue(int id, Location location, int[] objectIds, Tile objectTile) {
        super(id, location);
        this.objectIds = objectIds;
        this.objectTile = objectTile;
    }

    public SearchClue(int id, Location location, int[] objectIds, Tile objectTile, Callable<Boolean> requirement) {
        super(id, location, requirement);
        this.objectIds = objectIds;
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

//        System.out.println(ctx.objects.select().id(objectIds).nearest().poll());
        if(objectTile == null) {
            return ctx.objects.select().id(objectIds).nearest().poll().click();
        }
        else {
            return ctx.objects.select().id(objectIds).at(objectTile).poll().click();
        }
    }
}
