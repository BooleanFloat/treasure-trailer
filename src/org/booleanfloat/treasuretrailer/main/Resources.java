package org.booleanfloat.treasuretrailer.main;

import org.booleanfloat.traveler.regions.asgarnia.Burthorpe;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.asgarnia.Rimmington;
import org.booleanfloat.traveler.regions.asgarnia.Taverly;
import org.booleanfloat.traveler.regions.kandarin.Catherby;
import org.booleanfloat.traveler.regions.kandarin.SeersVillage;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.regions.misthalin.Draynor;
import org.booleanfloat.traveler.regions.misthalin.Varrock;
import org.booleanfloat.traveler.regions.misthalin.VarrockCastle;
import org.booleanfloat.traveler.regions.misthalin.WizardsTower;
import org.booleanfloat.treasuretrailer.clues.*;
import org.powerbot.script.Tile;

import java.util.HashMap;

public class Resources {
    public static String status = "";

    public static boolean isStunned = false;
    public static boolean isDropping = false;
    public static boolean hasClue = false;
    public static boolean hasLoot = false;
    public static boolean hasSeenClue = true;

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
            1625, 1627, 1733, 1734, 1739, 2138, 4298, 4300, 4302, 4304, 4308,
            4310
    };

    public static final int[] CASKET_IDS = {
            2717, 2720, 3519, 7237, 10183, 10201, 10211, 10213, 10219, 12180
    };

    public static final int CLUE_REWARD_WIDGET_ID = 364;
    public static final int CLUE_WIDGET_ID = 203;
    public static final int EMOTES_WIDGET_ID = 216;

    public static final int BLUE_WIZARD_HAT = 579;
    public static final int BRONZE_TWO_HANDED_SWORD = 1307;
    public static final int CREAM_ROBE_TOP = 642;
    public static final int EMERALD_RING = 1639;
    public static final int GREEN_HAT = 658;
    public static final int HAM_BOOTS = 4310;
    public static final int IRON_CHAINBODY = 1101;
    public static final int IRON_MEDIUM_HELM = 1137;
    public static final int LEATHER_CHAPS = 1095;
    public static final int LONGBOW = 839;
    public static final int SAPPHIRE_RING = 1637;
    public static final int WHITE_APRON = 1005;

    public enum Emote {
        YES, NO, BOW, ANGRY,
        THINK, WAVE, SHRUG, CHEER,
        BECKON, LAUGH, JUMP, YAWN,
        DANCE, JIG, SPIN, HEADBANG,
        CRY, BLOWKISS, PANIC, RASPBERRY,
        CLAP, SALUTE
    }

    public static HashMap<Emote, Integer> EMOTES = new HashMap<>();
    static {
        int index = 0;
        for(Emote emote : Emote.values()) {
            EMOTES.put(emote, index);
            index++;
        }
    }

    public static HashMap<Integer, Clue> CLUES = new HashMap<>();
    public static int[] CLUE_IDS;
    public static void initClues() {
        CLUES.put(10212, new EmoteClue(10212, Burthorpe.GamesRoom, Emote.CHEER, true));
        CLUES.put(10200, new EmoteClue(10300, Draynor.CrossRoads, Emote.DANCE, new int[] { IRON_CHAINBODY, SAPPHIRE_RING, LONGBOW }));
        CLUES.put(10210, new EmoteClue(10210, Taverly.DruidsCircle, Emote.CHEER, new int[] { BLUE_WIZARD_HAT, BRONZE_TWO_HANDED_SWORD, HAM_BOOTS }));
        CLUES.put(10218, new EmoteClue(10218, Rimmington.NorthCrossRoads, Emote.SPIN, new int[]{ GREEN_HAT, CREAM_ROBE_TOP, LEATHER_CHAPS }));
        CLUES.put(10182, new EmoteClue(10182, WizardsTower.Causeway, Emote.CLAP, new int[]{ IRON_MEDIUM_HELM, EMERALD_RING, WHITE_APRON }));

        CLUES.put(2716, new DigClue(2716, Varrock.SouthMineDigSpot, new Tile(3289, 3374, 0)));
        CLUES.put(2719, new DigClue(2719, Falador.NorthFencedStones, new Tile(3043, 3398, 0)));
        CLUES.put(3518, new DigClue(3518, WizardsTower.DigSpot, new Tile(3110, 3152, 0)));
        CLUES.put(7236, new DigClue(7236, Falador.NorthSquare, new Tile(2970, 3414, 0)));
        CLUES.put(12179, new DigClue(12179, AlKharid.MineDigSpot, new Tile(3300, 3291, 0)));

        CLUES.put(2682, new SearchClue(2682, AlKharid.NorthHouse, 358));
        CLUES.put(2694, new SearchClue(2694, Falador.ChainMailStore, 348, new Tile(2969, 3311, 0)));
        CLUES.put(3498, new SearchClue(3498, Falador.EastHouseUpstairs, 350, 351));
        CLUES.put(3507, new SearchClue(3507, Catherby.NorthWestHouseUpstairs, 350, 351, new Tile(2809, 3451, 1)));
        CLUES.put(3509, new SearchClue(3509, SeersVillage.SouthHouse, 25775));
        CLUES.put(3515, new SearchClue(3515, VarrockCastle.Kitchen, 2608));
        CLUES.put(12176, new SearchClue(12176, Varrock.WestBankBasementClueSpot, 2571, new Tile(3187, 9825, 0)));
        CLUES.put(12185, new SearchClue(12185, Burthorpe.Pub, 354, new Tile(2913, 3536, 0)));

        CLUES.put(2684, new TalkClue(2684, AlKharid.Tanner, Resources.ELLIS_ID));
        CLUES.put(2701, new TalkClue(2701, Catherby.GeneralStore, Resources.ARHEIN_ID));

        CLUE_IDS = new int[CLUES.size()];
        Object[] keys = CLUES.keySet().toArray();
        for(int i = 0; i < keys.length; i++) {
            CLUE_IDS[i] = (int) keys[i];
        }
    }
}
