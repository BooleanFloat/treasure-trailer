package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;
import org.powerbot.script.rt4.ClientContext;

public class Stunned extends Task<ClientContext> implements MessageListener {
    private long stunnedTime;

    public Stunned(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Resources.isStunned;
    }

    @Override
    public void execute() {
        Resources.status = "Stunned";

        if(System.currentTimeMillis() - stunnedTime > 5 * 1000) {
            Resources.isStunned = false;
            stunnedTime = 0;
        }
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        if(messageEvent.text().contains("You've been stunned")) {
            Resources.isStunned = true;
            stunnedTime = System.currentTimeMillis();
        }
    }
}
