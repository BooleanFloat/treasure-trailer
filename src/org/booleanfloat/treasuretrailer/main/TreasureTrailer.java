package org.booleanfloat.treasuretrailer.main;

import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.treasuretrailer.tasks.*;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.*;

@Script.Manifest(name="Treasure Trailer", description="Pickpockets HAM members for easy clues and solves them.")
public class TreasureTrailer extends PollingScript<ClientContext> implements PaintListener, MessageListener {
    private java.util.List<Task> tasks = new ArrayList<>();

    @Override
    public void start() {
        Traveler.init(ctx);

        Resources.status = "starting";

        tasks.addAll(Arrays.asList(
                new DropJunk(ctx),
                new Pickpocket(ctx),
                new Stunned(ctx),
            new TraverseHamHideout(ctx)
        ));
    }

    @Override
    public void poll() {
        for (Task task : tasks) {
            if (task.activate()) {
                task.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(Resources.status, 390, 360);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        for (Task task : tasks) {
            if(task instanceof MessageListener) {
                ((MessageListener) task).messaged(messageEvent);
            }
        }
    }
}
