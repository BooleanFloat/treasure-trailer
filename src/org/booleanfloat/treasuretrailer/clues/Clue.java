package org.booleanfloat.treasuretrailer.clues;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.rt4.ClientContext;

import java.util.concurrent.Callable;

public abstract class Clue {
    protected int id;
    protected Location location;
    protected Callable<Boolean> requirement;

    public Clue(int id, Location location) {
        this(id, location, null);
    }

    public Clue(int id, Location location, Callable<Boolean> requirement) {
        this.id = id;
        this.location = location;
        this.requirement = requirement;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public boolean hasRequirements() {
        if(requirement != null) {
            try {
                return requirement.call();
            }
            catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public abstract boolean canSolve(ClientContext ctx);
    public abstract boolean solve(ClientContext ctx);
}
