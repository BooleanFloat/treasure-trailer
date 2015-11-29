package org.booleanfloat.treasuretrailer.main;

import org.booleanfloat.traveler.regions.asgarnia.Burthorpe;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.asgarnia.Rimmington;
import org.booleanfloat.traveler.regions.asgarnia.Taverly;
import org.booleanfloat.traveler.regions.kandarin.Catherby;
import org.booleanfloat.traveler.regions.kandarin.EastArdougne;
import org.booleanfloat.traveler.regions.kandarin.SeersVillage;
import org.booleanfloat.traveler.regions.kandarin.Yanille;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.regions.misthalin.*;
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
    public static double teleportThreshold = 200;

    public static final int ARHEIN_ID = 1032;
    public static final int ELLIS_ID = 3231;
    public static final int SIR_KAY_ID = 3521;
    public static final int URI_ID = 1774;

    public static final int SPADE_ID = 952;

    public static final int[] FOOD_IDS = { 1891, 1893, 1895 };

    public static final int[] HAM_MEMBERS_IDS = { 2541 };

    public static final int[] HAM_JUNK_IDS = {
            199, 201, 321, 314, 440, 453, 590, 686, 688, 697, 882, 886, 946,
            1203, 1205, 1129, 1207, 1265, 1267, 1269, 1349, 1351, 1353, 1511,
            1625, 1627, 1733, 1734, 1739, 2138, 4298, 4300, 4302, 4304, 4306,
            4308, 4310
    };

    public static final int[] CASKET_IDS = {
            2714, 2717, 2720, 3517, 3519, 7237, 10181, 10183, 10187, 10201,
            10203, 10211, 10213, 10219, 12180
    };

    public static final int CLUE_REWARD_WIDGET_ID = 364;
    public static final int CLUE_TEXT_WIDGET_ID = 203;
    public static final int CLUE_MAP_WIDGET_ID = 337;
    public static final int EMOTES_WIDGET_ID = 216;
    public static final int[] CLUE_WIDGET_IDS = {
            203, 337, 346, 347, 351, 354, 356
    };

    public static final int AIR_RUNE_ID = 556;
    public static final int WATER_RUNE_ID = 555;
    public static final int EARTH_RUNE_ID = 557;
    public static final int FIRE_RUNE_ID = 554;
    public static final int LAW_RUNE_ID = 563;

    public static final int BLUE_WIZARD_HAT = 579;
    public static final int BRONZE_DAGGER = 1205;
    public static final int BRONZE_PLATELEGS = 1075;
    public static final int BRONZE_SPEAR = 1237;
    public static final int BRONZE_TWO_HANDED_SWORD = 1307;
    public static final int CREAM_ROBE_TOP = 642;
    public static final int EMERALD_RING = 1639;
    public static final int GOLD_NECKLACE = 1654;
    public static final int GOLD_RING = 1635;
    public static final int GREEN_HAT = 658;
    public static final int HAM_BOOTS = 4310;
    public static final int IRON_CHAINBODY = 1101;
    public static final int IRON_FULL_HELM = 1153;
    public static final int IRON_MEDIUM_HELM = 1137;
    public static final int LEATHER_CHAPS = 1095;
    public static final int LONGBOW = 839;
    public static final int SAPPHIRE_RING = 1637;
    public static final int STEEL_MEDIUM_HELM = 1269;
    public static final int STEEL_PICKAXE = 1141;
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
        CLUES.put(10180, new EmoteClue(10180, Lumbridge.SwampShack, Emote.DANCE, new int[] { BRONZE_DAGGER, IRON_FULL_HELM, GOLD_RING }));
        CLUES.put(10186, new EmoteClue(10186, Varrock.LimeStoneMine, Emote.PANIC, new int[] { BRONZE_PLATELEGS, STEEL_PICKAXE, STEEL_MEDIUM_HELM }));
        CLUES.put(10200, new EmoteClue(10200, Draynor.CrossRoads, Emote.DANCE, new int[] { IRON_CHAINBODY, SAPPHIRE_RING, LONGBOW }));
        CLUES.put(10210, new EmoteClue(10210, Taverly.DruidsCircle, Emote.CHEER, new int[] { BLUE_WIZARD_HAT, BRONZE_TWO_HANDED_SWORD, HAM_BOOTS }));
        CLUES.put(10202, new EmoteClue(10202, Rimmington.Mine, Emote.SHRUG, new int[] { GOLD_NECKLACE, GOLD_RING, BRONZE_SPEAR }));
        CLUES.put(10218, new EmoteClue(10218, Rimmington.NorthCrossRoads, Emote.SPIN, new int[]{ GREEN_HAT, CREAM_ROBE_TOP, LEATHER_CHAPS }));
        CLUES.put(10182, new EmoteClue(10182, WizardsTower.Causeway, Emote.CLAP, new int[]{ IRON_MEDIUM_HELM, EMERALD_RING, WHITE_APRON }));

        CLUES.put(2713, new DigClue(2713, Varrock.RiverDigSpot, new Tile(3167, 3360 ,0)));
        CLUES.put(2716, new DigClue(2716, Varrock.SouthMineDigSpot, new Tile(3289, 3374, 0)));
        CLUES.put(2719, new DigClue(2719, Falador.NorthFencedStones, new Tile(3043, 3398, 0)));
        CLUES.put(3516, new DigClue(3516, SeersVillage.GalahadsHouseEntrance, new Tile(2611, 3481, 0)));
        CLUES.put(3518, new DigClue(3518, WizardsTower.DigSpot, new Tile(3110, 3152, 0)));
        CLUES.put(7236, new DigClue(7236, Falador.NorthSquare, new Tile(2970, 3414, 0)));
        CLUES.put(12179, new DigClue(12179, AlKharid.MineDigSpot, new Tile(3300, 3291, 0)));

        CLUES.put(2677, new SearchClue(2677, LumbridgeCastle.DukesRoom, 375, 378));
        CLUES.put(2682, new SearchClue(2682, AlKharid.NorthHouse, 358));
        CLUES.put(2690, new SearchClue(2690, BarbarianVillage.HelmetStore, 11600, new Tile(3073, 3430, 0)));
        CLUES.put(2694, new SearchClue(2694, Falador.ChainMailStore, 348, new Tile(2969, 3311, 0)));
        CLUES.put(3492, new SearchClue(3492, Yanille.HunterStore, 350, 351));
        CLUES.put(3498, new SearchClue(3498, Falador.EastHouseUpstairs, 350, 351));
        CLUES.put(3499, new SearchClue(3499, Taverly.TwoHandedSwordStore, 360, new Tile(2886, 3449, 0)));
        CLUES.put(3500, new SearchClue(3500, Taverly.SouthHouse, 350, 351));
        CLUES.put(3503, new SearchClue(3503, Burthorpe.Tent, 3686));
        CLUES.put(3505, new SearchClue(3505, EastArdougne.MarketNorthHouseUpstairs, 352, 353));
        CLUES.put(3507, new SearchClue(3507, Catherby.NorthWestHouseUpstairs, 350, 351, new Tile(2809, 3451, 1)));
        CLUES.put(3508, new SearchClue(3508, SeersVillage.SpinningHouse, 25766, 25767));
        CLUES.put(3509, new SearchClue(3509, SeersVillage.SouthHouse, 25775));
        CLUES.put(3515, new SearchClue(3515, VarrockCastle.Kitchen, 2608));
        CLUES.put(12175, new SearchClue(12175, Varrock.DigSiteBush, 2357, new Tile(3345, 3378, 0)));
        CLUES.put(12176, new SearchClue(12176, Varrock.WestBankBasementClueSpot, 2571, new Tile(3187, 9825, 0)));
        CLUES.put(12185, new SearchClue(12185, Burthorpe.Pub, 354, new Tile(2913, 3536, 0)));

        CLUES.put(2684, new TalkClue(2684, AlKharid.Tanner, ELLIS_ID));
        CLUES.put(2701, new TalkClue(2701, Catherby.GeneralStore, ARHEIN_ID));
        CLUES.put(2702, new TalkClue(2702, SeersVillage.CastleCourtyard, SIR_KAY_ID));

        CLUE_IDS = new int[CLUES.size()];
        Object[] keys = CLUES.keySet().toArray();
        for(int i = 0; i < keys.length; i++) {
            CLUE_IDS[i] = (int) keys[i];
        }
    }
}
