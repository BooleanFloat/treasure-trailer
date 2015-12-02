package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.treasuretrailer.main.Resources;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Widget;

import java.util.HashMap;
import java.util.Map;

public class RecordReward extends Task<ClientContext> {
    private HashMap<String, Integer> rewards;

    public RecordReward(ClientContext ctx) {
        super(ctx);

        rewards = new HashMap<>();
    }

    @Override
    public boolean activate() {
        return ctx.widgets.widget(Resources.CLUE_REWARD_WIDGET_ID).component(0).visible()
                && ctx.widgets.widget(Resources.CLUE_REWARD_WIDGET_ID).component(0).valid();
    }

    @Override
    public void execute() {
        Widget clueRewardWidget = ctx.widgets.widget(Resources.CLUE_REWARD_WIDGET_ID);

        int[] itemIds = clueRewardWidget.component(1).itemIds();
        int[] itemStacks = clueRewardWidget.component(1).itemStackSizes();

        for(int i = 0; i < itemIds.length; i++) {
            if(itemIds[i] == -1) {
                break;
            }

            Item item = new Item(ctx, clueRewardWidget.component(1), itemIds[i], itemStacks[i]);

            Integer amount = rewards.get(item.name());

            if(amount == null) {
                rewards.put(item.name(), itemStacks[i]);
            }
            else {
                rewards.put(item.name(), amount + itemStacks[i]);
            }
        }

        Condition.sleep(2000);
        clueRewardWidget.component(3).click();

        print();
        Resources.hasClue = false;
//        Resources.hasLoot = true;
    }

    public void print() {
        System.out.println("Rewards:");
        for (Map.Entry<String, Integer> reward : rewards.entrySet()) {
            System.out.println("\t" + reward.getKey() + ": " + reward.getValue());
        }
        System.out.println("\n");
    }
}
