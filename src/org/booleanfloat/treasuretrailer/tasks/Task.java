package org.booleanfloat.treasuretrailer.tasks;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

import java.awt.*;

public abstract class Task<C extends ClientContext> extends ClientAccessor<C> {
    public Task(C ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();

    public void paint(Graphics g) {

    }
}