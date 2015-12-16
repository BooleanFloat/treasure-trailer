package org.booleanfloat.treasuretrailer.tasks;

import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.treasuretrailer.main.Resources;
import org.booleanfloat.treasuretrailer.util.GeItem;
import org.booleanfloat.treasuretrailer.util.RewardItem;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Widget;

import java.awt.*;
import java.util.*;

public class RecordReward extends Task<ClientContext> {
    private Collection<RewardItem> bestRewards;
    private HashMap<Integer, RewardItem> rewards;
    private int totalValue;

    public RecordReward(ClientContext ctx) {
        super(ctx);

        rewards = new HashMap<Integer, RewardItem>();
        bestRewards = new ArrayList<RewardItem>();
        totalValue = 0;
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
            int itemId = itemIds[i];

            if(itemId == -1) {
                break;
            }

            if(Arrays.asList(Resources.NOTED_REWARD_IDS).contains(itemId)) {
                itemId -= 1;
            }

            if(rewards.containsKey(itemId)) {
                rewards.get(itemId).addAmount(itemStacks[i]);
            }
            else {
                rewards.put(itemId, new RewardItem(ctx, itemId, itemStacks[i]));
            }
        }

        updateRewards();
        Condition.sleep(2000);
        clueRewardWidget.component(3).click();
        Condition.sleep(500);

        Traveler.getPathToNearestBank(ctx.players.local().tile());

        Resources.hasClue = false;
//        Resources.hasLoot = true;
        print();
    }

    @Override
    public void paint(Graphics g) {
        int index = 0;

        g.drawString("Value: " + totalValue, 360, 444);

        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Verdana", Font.PLAIN, 10));
        g.fillRect(206, 350, 144, 105);

        for (RewardItem reward : bestRewards) {
            if(reward.getName().length() == 0) {
                continue;
            }

            int x = index % 4 * 36 + 208;
            int y = (int) Math.floor(index / 4) * 35 + 352;

            g.drawImage(reward.getIcon(), x, y, 32, 32, null);

            g.setColor(Color.BLACK);
            g.drawString("" + reward.getAmount(), x + 1, y + 9);
            g.setColor(Color.YELLOW);
            g.drawString("" + reward.getAmount(), x, y + 8);

            index++;
        }
    }

    public void print() {
        System.out.println("Rewards:");
        for (RewardItem reward : rewards.values()) {
            System.out.println("\t" + reward.toString());
        }
        System.out.println("\n");
    }

    private void updateRewards() {
        ArrayList<RewardItem> items = new ArrayList<RewardItem>(rewards.values());

        Comparator<RewardItem> comparator = new Comparator<RewardItem>() {
            public int compare(RewardItem c1, RewardItem c2) {
                return c2.getValue() - c1.getValue();
            }
        };

        Collections.sort(items, comparator);
        bestRewards = items;

        totalValue = 0;
        for(RewardItem item : items) {
            totalValue += item.getValue();
        }
    }
}
