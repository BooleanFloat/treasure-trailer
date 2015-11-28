package org.booleanfloat.treasuretrailer.main;

import java.util.HashMap;

public class Resources {
    public static String status = "";

    public static boolean isStunned = false;
    public static boolean isDropping = false;
    public static boolean hasClue = false;
    public static boolean hasLoot = false;

    public static double eatThreshold = 0.5;

    public static final int ARHEIN_ID = 1032;
    public static final int ELLIS_ID = 3231;
    public static final int URI_ID = 1774;

    public static final int SPADE_ID = 952;

    public static final int[] FOOD_IDS = { 1891, 1893, 1895 };

    public static final int[] HAM_MEMBERS_IDS = { 2541 };

    public static final int[] HAM_JUNK_IDS = {
            199, 201, 321, 314, 440, 453, 590, 686, 688, 697, 882, 886, 946,
            1203, 1205, 1129, 1207, 1265, 1267, 1269, 1349, 1351, 1353, 1511,
            1625, 1627, 1733, 1734, 1739, 2138, 4298, 4300, 4308, 4310
    };

    public static final int[] CASKET_IDS = {
            2717, 2720, 3519, 7237, 10213
    };

    public static final int[] CLUE_IDS = {
            2682, 2684, 2701, 2719, 10210
    };

    public static final int CLUE_REWARD_WIDGET_ID = 364;
    public static final int EMOTES_WIDGET_ID = 216;

    public static final int CREAM_ROBE_TOP = 642;
    public static final int GREEN_HAT = 658;
    public static final int LEATHER_CHAPS = 1095;

    public enum Emote {
        YES, NO, BOW, ANGRY,
        THINK, WAVE, SHRUG, CHEER,
        BECKON, LAUGH, JUMP, YAWN,
        DANCE, JIG, SPIN, HEADBANG,
        CRY, BLOWKISS, PANIC, RASPBERRY,
        CLAP, SALUTE
    }

    public static HashMap<Emote, Integer> emotes = new HashMap<>();
    static {
        int index = 0;
        for(Emote emote : Emote.values()) {
            emotes.put(emote, index);
            index++;
        }
    }
}
