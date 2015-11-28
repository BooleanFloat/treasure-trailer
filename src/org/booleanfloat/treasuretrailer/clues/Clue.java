package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.rt4.ClientContext;

public abstract class Clue {
    protected int id;
    protected Location location;

    public Clue(int id, Location location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public abstract boolean canSolve(ClientContext ctx);
    public abstract boolean solve(ClientContext ctx);
}
