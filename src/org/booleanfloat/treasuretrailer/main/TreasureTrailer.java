package org.booleanfloat.treasuretrailer.main;

import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.traveler.regions.misthalin.Varrock;
import org.booleanfloat.treasuretrailer.tasks.*;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Equipment;

import java.awt.*;
import java.util.*;

@Script.Manifest(name="Treasure Trailer", description="Pickpockets HAM members for easy clues and solves them.")
public class TreasureTrailer extends PollingScript<ClientContext> implements PaintListener, MessageListener {
    private java.util.List<Task> tasks = new ArrayList<Task>();

    @Override
    public void start() {
        Traveler.init(ctx);
        Resources.initClues(ctx);

        Resources.status = "starting";

        tasks.addAll(Arrays.asList(
                new RestoreHealth(ctx),
                new Stunned(ctx),
                new DropJunk(ctx),
                new OpenCasket(ctx),
                new OpenClue(ctx),
                new SolveClue(ctx),
                new RecordReward(ctx),
                new TraverseHamHideout(ctx),
                new Pickpocket(ctx)
                //                new TraverseBank(ctx),
        ));
    }

    @Override
    public void poll() {
        Resources.status = "-";
        for (Task task : tasks) {
            if (task.activate()) {
                task.execute();
                break;
            }
        }
    }

    @Override
    public void repaint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(355, 350, 137, 105);
        g.setColor(Color.black);
        g.drawString(Resources.status, 360, 364);
        g.drawString("isStunned: " + Resources.isStunned, 360, 380);
        g.drawString("isDropping: " + Resources.isDropping, 360, 396);
        g.drawString("hasClue: " + Resources.hasClue, 360, 412);
        g.drawString("hasSeenClue: " + Resources.hasSeenClue, 360, 428);

        for(Task task : tasks){
            task.paint(g);
        }
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
