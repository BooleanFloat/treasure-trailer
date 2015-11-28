package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.regions.misthalin.LumbridgeCastle;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.rt4.ClientContext;

import java.util.HashMap;

public class Bank extends Task<ClientContext> {
    private HashMap<Integer, Integer> baseInventory;

    public Bank(ClientContext ctx) {
        super(ctx);

        baseInventory = new HashMap<>();
        baseInventory.put(995, 5000);
        baseInventory.put(563, 25);
        baseInventory.put(556, 100);
        baseInventory.put(555, 100);
        baseInventory.put(557, 100);
        baseInventory.put(554, 100);
        baseInventory.put(1891, 5);
        baseInventory.put(952, 1);
    }

    @Override
    public boolean activate() {
        return Resources.hasLoot
                && LumbridgeCastle.Bank.area.contains(ctx.players.local());
    }

    @Override
    public void execute() {
        Resources.status = "Banking";

        Resources.hasLoot = false;
    }
}
