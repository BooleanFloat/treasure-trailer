package org.booleanfloat.treasuretrailer.main;

import org.booleanfloat.traveler.regions.asgarnia.*;
import org.booleanfloat.traveler.regions.kandarin.*;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.regions.misthalin.*;
import org.booleanfloat.treasuretrailer.clues.*;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class Resources {
    public static String status = "";

    public static boolean isStunned = false;
    public static boolean isDropping = false;
    public static boolean hasClue = false;
    public static boolean hasLoot = false;
    public static boolean hasSeenClue = true;

    public static double eatThreshold = 0.5;
    public static double teleportThreshold = 200;

    public static final int AMBASSADOR_SPANFIPPLE_ID = 0;
    public static final int ARHEIN_ID = 1032;
    public static final int BLUE_MOON_INN_BARTENDER_ID = 1312;
    public static final int CAPTION_TOBIAS_ID = 3644;
    public static final int CASSIE_ID = 1046;
    public static final int ELLIS_ID = 3231;
    public static final int DORIC_ID = 3893;
    public static final int DORIS_ID = 4808;
    public static final int GAIUS_ID = 1173;
    public static final int HAIRDRESSER_ID = 1305;
    public static final int JATIX_ID = 1174;
    public static final int JEED_ID = 3351;
    public static final int LOUISA_ID = 4215;
    public static final int LUCY_ID = 5795;
    public static final int NED_ID = 4280;
    public static final int RUSTY_ID = 3281;
    public static final int RUSTY_ANCHOR_BARTENDER_ID = 1313;
    public static final int SARAH_ID = 501;
    public static final int SIR_KAY_ID = 3521;
    public static final int SQUIRE_ID = 4737;
    public static final int URI_ID = 1774;

    public static final int SPADE_ID = 952;

    public static final int[] FOOD_IDS = { 1891, 1893, 1895 };

    public static final int[] HAM_MEMBERS_IDS = { 2541 };

    public static final int[] HAM_JUNK_IDS = {
            199, 201, 203, 321, 314, 440, 453, 590, 686, 688, 697, 882, 886,
            946, 1203, 1205, 1129, 1207, 1265, 1267, 1269, 1349, 1351, 1353,
            1511, 1625, 1627, 1733, 1734, 1739, 2138, 4298, 4300, 4302, 4304,
            4306, 4308, 4310
    };

    public static final int[] CASKET_IDS = {
            2714, 2717, 2720, 3511, 3517, 3519, 7237, 12171, 12180, 10181,
            10183, 10185, 10187, 10189, 10191, 10193, 10195, 10197, 10201,
            10203, 10205, 10207, 10209, 10211, 10213, 10215, 10217, 10219,
            10221, 10223, 10225, 10229, 10231, 10233, 12163, 12165,
    };

    public static final int CLUE_REWARD_WIDGET_ID = 364;
    public static final int EMOTES_WIDGET_ID = 216;
    public static final int[] CLUE_WIDGET_IDS = {
            87, 203, 337, 346, 347, 351, 354, 356
    };

    public static final int AIR_RUNE_ID = 556;
    public static final int WATER_RUNE_ID = 555;
    public static final int EARTH_RUNE_ID = 557;
    public static final int FIRE_RUNE_ID = 554;
    public static final int LAW_RUNE_ID = 563;

    public static final int BLACK_AXE = 1361;
    public static final int BLACK_CAPE = 1019;
    public static final int BLACK_PLATEBODY = 1125;
    public static final int BLUE_ROBE_TOP = 640;
    public static final int BLUE_WIZARD_HAT = 579;
    public static final int BRONZE_AXE = 1351;
    public static final int BRONZE_CHAINBODY = 1103;
    public static final int BRONZE_DAGGER = 1205;
    public static final int BRONZE_FULL_HELM = 1155;
    public static final int BRONZE_PLATELEGS = 1075;
    public static final int BRONZE_SPEAR = 1237;
    public static final int BRONZE_TWO_HANDED_SWORD = 1307;
    public static final int COIF = 1169;
    public static final int CREAM_ROBE_TOP = 642;
    public static final int DESERT_SHIRT = 1833;
    public static final int EMERALD_AMULET = 1696;
    public static final int EMERALD_RING = 1639;
    public static final int GOLD_NECKLACE = 1654;
    public static final int GOLD_RING = 1635;
    public static final int GREEN_BOOTS = 628;
    public static final int GREEN_HAT = 658;
    public static final int GREEN_ROBE_BOTTOMS = 648;
    public static final int GREEN_ROBE_TOP = 638;
    public static final int HAM_BOOTS = 4310;
    public static final int HAM_CLOAK = 4304;
    public static final int HAM_GLOVES = 4308;
    public static final int HAM_HOOD = 4302;
    public static final int HAM_LOGO = 4306;
    public static final int HAM_ROBE = 4300;
    public static final int HAM_SHIRT = 4298;
    public static final int HARDLEATHER_BODY = 1131;
    public static final int IRON_CHAINBODY = 1101;
    public static final int IRON_FULL_HELM = 1153;
    public static final int IRON_PLATEBODY = 1115;
    public static final int IRON_PLATELEGS = 1067;
    public static final int IRON_PLATESKIRT = 1081;
    public static final int IRON_KITESHIELD = 1191;
    public static final int IRON_MEDIUM_HELM = 1137;
    public static final int IRON_WARHAMMER = 1335;
    public static final int LEATHER_BOOTS = 1061;
    public static final int LEATHER_CHAPS = 1095;
    public static final int LEATHER_GLOVES = 1059;
    public static final int LONGBOW = 839;
    public static final int MIRTHIL_PICKAXE = 1273;
    public static final int OAK_LONGBOW = 845;
    public static final int RUBY_RING = 1641;
    public static final int SAPPHIRE_AMULET = 1694;
    public static final int SAPPHIRE_NECKLACE = 1656;
    public static final int SAPPHIRE_RING = 1637;
    public static final int STAFF = 1379;
    public static final int STEEL_AXE = 1353;
    public static final int STEEL_FULL_HELM = 1157;
    public static final int STEEL_LONGSWORD = 1295;
    public static final int STEEL_MACE = 1424;
    public static final int STEEL_MEDIUM_HELM = 1269;
    public static final int STEEL_PICKAXE = 1141;
    public static final int STEEL_PLATEBODY = 1119;
    public static final int STEEL_PLATESKIRT = 1083;
    public static final int STUDDED_BODY = 1133;
    public static final int STUDDED_CHAPS = 1097;
    public static final int TIARA = 5525;
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

    public static boolean hasLevel(ClientContext ctx, int skill, int level) {
        return ctx.skills.realLevel(skill) >= level;
    }

    public static Callable<Boolean> checkLevels(ClientContext ctx, int attack, int defence, int range, int magic) {
        return new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.skills.realLevel(Constants.SKILLS_ATTACK) >= attack
                        && ctx.skills.realLevel(Constants.SKILLS_DEFENSE) >= defence
                        && ctx.skills.realLevel(Constants.SKILLS_RANGE) >= range
                        && ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= magic;
            }
        };
    }

    public static HashMap<Integer, Clue> CLUES = new HashMap<>();
    public static int[] CLUE_IDS;
    public static void initClues(ClientContext ctx) {
        // 112/114 Clues
        CLUES.put(10180, new EmoteClue(10180, Lumbridge.SwampShack, Emote.DANCE, new int[] { BRONZE_DAGGER, IRON_FULL_HELM, GOLD_RING }));
        CLUES.put(10182, new EmoteClue(10182, WizardsTower.Causeway, Emote.CLAP, new int[] { IRON_MEDIUM_HELM, EMERALD_RING, WHITE_APRON }));
        CLUES.put(10184, new EmoteClue(10184, Draynor.Market, Emote.YAWN, new int[]{ STUDDED_CHAPS, IRON_KITESHIELD, STEEL_LONGSWORD }, checkLevels(ctx, 5, 0, 20, 0)));
        CLUES.put(10186, new EmoteClue(10186, Varrock.LimeStoneMine, Emote.PANIC, new int[] { BRONZE_PLATELEGS, STEEL_PICKAXE, STEEL_MEDIUM_HELM }, checkLevels(ctx, 5, 5, 0, 0)));
        CLUES.put(10188, new EmoteClue(10188, EastArdougne.LegendsGuildEntrance, Emote.BOW, new int[] { IRON_PLATELEGS, EMERALD_AMULET, OAK_LONGBOW }, checkLevels(ctx, 0, 0, 5, 0)));
        CLUES.put(10190, new EmoteClue(10190, PortSarim.MudskipperPoint, Emote.WAVE, new int [] { BLACK_CAPE, LEATHER_CHAPS, STEEL_MACE }));
        CLUES.put(10192, new EmoteClue(10192, PortSarim.EntranaBoat, Emote.CHEER, new int[] { COIF, STEEL_PLATESKIRT, SAPPHIRE_NECKLACE }, checkLevels(ctx, 0, 5, 20, 0)));
        CLUES.put(10194, new EmoteClue(10194, AlKharid.Mine, Emote.HEADBANG, new int[] { DESERT_SHIRT, LEATHER_GLOVES, LEATHER_BOOTS}));
        CLUES.put(10196, new EmoteClue(10196, Draynor.ManorFountain, Emote.SPIN, new int[] { IRON_PLATEBODY, STUDDED_CHAPS, BRONZE_FULL_HELM }, checkLevels(ctx, 0, 0, 20, 0)));
        CLUES.put(10200, new EmoteClue(10200, Draynor.CrossRoads, Emote.DANCE, new int[] { IRON_CHAINBODY, SAPPHIRE_RING, LONGBOW }));
        CLUES.put(10202, new EmoteClue(10202, Rimmington.Mine, Emote.SHRUG, new int[] { GOLD_NECKLACE, GOLD_RING, BRONZE_SPEAR }));
        CLUES.put(10204, new EmoteClue(10204, VarrockCastle.Library, Emote.YAWN, new int[] { GREEN_ROBE_TOP, HAM_ROBE, IRON_WARHAMMER }));
        CLUES.put(10206, new EmoteClue(10206, EastArdougne.NorthMillTop, Emote.CLAP, new int[] { BLUE_ROBE_TOP, HAM_ROBE, TIARA }));
        CLUES.put(10208, new EmoteClue(10208, Falador.PartyRoom, Emote.DANCE, new int[] { STEEL_FULL_HELM, STEEL_PLATEBODY, IRON_PLATESKIRT }, checkLevels(ctx, 0, 5, 0, 0)));
        CLUES.put(10210, new EmoteClue(10210, Taverly.DruidsCircle, Emote.CHEER, new int[] { BLUE_WIZARD_HAT, BRONZE_TWO_HANDED_SWORD, HAM_BOOTS }));
        CLUES.put(10212, new EmoteClue(10212, Burthorpe.GamesRoom, Emote.CHEER, true));
        CLUES.put(10214, new EmoteClue(10214, Catherby.Beehives, Emote.JUMP, new int[] { GREEN_ROBE_BOTTOMS, DESERT_SHIRT, STEEL_AXE }, checkLevels(ctx, 5, 0, 0, 0)));
        CLUES.put(10216, new EmoteClue(10216, EastArdougne.ZooMonkeyCage, Emote.RASPBERRY, new int[] { STUDDED_BODY, BRONZE_PLATELEGS, STAFF }, checkLevels(ctx, 0, 20, 20, 0)));
        CLUES.put(10218, new EmoteClue(10218, Rimmington.NorthCrossRoads, Emote.SPIN, new int[] { GREEN_HAT, CREAM_ROBE_TOP, LEATHER_CHAPS }));
        CLUES.put(10220, new EmoteClue(10220, EastArdougne.FishingGuildEntrance, Emote.JIG, new int[] { EMERALD_RING, SAPPHIRE_AMULET, BRONZE_CHAINBODY }));
        CLUES.put(10222, new EmoteClue(10222, SeersVillage.KeepLeFayeEntrance, Emote.RASPBERRY, new int[] { COIF, IRON_PLATEBODY, LEATHER_GLOVES }, checkLevels(ctx, 0, 0, 20, 0)));
        CLUES.put(10224, new EmoteClue(10224, PortKhazard.FishingTrawler, Emote.PANIC, true));
        CLUES.put(10228, new EmoteClue(10228, Varrock.ExamCenter, Emote.CLAP, new int[] { WHITE_APRON, GREEN_BOOTS, LEATHER_GLOVES }));
        CLUES.put(10230, new EmoteClue(10230, Varrock.LumberYard, Emote.WAVE, new int[] { HARDLEATHER_BODY, LEATHER_CHAPS, BRONZE_AXE }, checkLevels(ctx, 0, 10, 0, 0)));
        CLUES.put(10232, new EmoteClue(10232, AlKharid.DuelArenaTicketOffice, Emote.BOW, new int[] { IRON_CHAINBODY, LEATHER_CHAPS, COIF }, checkLevels(ctx, 0, 0, 20, 0)));
        CLUES.put(12162, new EmoteClue(12162, VarrockCastle.Courtyard, Emote.SPIN, new int[] { BLACK_AXE, COIF, RUBY_RING }, checkLevels(ctx, 10, 0, 20, 0)));
        CLUES.put(12164, new EmoteClue(12164, Falador.GemStore, Emote.WAVE, new int[] { MIRTHIL_PICKAXE, BLACK_PLATEBODY, IRON_KITESHIELD }, checkLevels(ctx, 20, 10, 0, 0)));

        CLUES.put(2713, new DigClue(2713, Varrock.RiverDigSpot, new Tile(3167, 3360 ,0)));
        CLUES.put(2716, new DigClue(2716, Varrock.SouthMineDigSpot, new Tile(3289, 3374, 0)));
        CLUES.put(2719, new DigClue(2719, Falador.NorthFencedStones, new Tile(3043, 3398, 0)));
        CLUES.put(3510, new DigClue(3510, TreeGnomeStronghold.MushroomDigSpot, new Tile(2460, 3505, 0)));
        CLUES.put(3516, new DigClue(3516, SeersVillage.GalahadsHouseEntrance, new Tile(2611, 3481, 0)));
        CLUES.put(3518, new DigClue(3518, WizardsTower.DigSpot, new Tile(3110, 3152, 0)));
        CLUES.put(7236, new DigClue(7236, Falador.NorthSquare, new Tile(2970, 3414, 0)));
        CLUES.put(12170, new DigClue(12170, Falador.NorthFencedStones, new Tile(3040, 3399, 0)));
        CLUES.put(12179, new DigClue(12179, AlKharid.MineDigSpot, new Tile(3300, 3291, 0)));

        CLUES.put(2677, new SearchClue(2677, LumbridgeCastle.DukesRoom, new int[] { 375, 378 }));
        CLUES.put(2678, new SearchClue(2678, LumbridgeCastle.SouthTowerUpstairs, new int[] { 357 }));
        CLUES.put(2679, new SearchClue(2679, Lumbridge.GoblinHouse, new int[] { 359 }));
        CLUES.put(2680, new SearchClue(2680, AlKharid.PalaceChests, new int[] { 375, 378 }, new Tile(3301, 3169, 1)));
        CLUES.put(2682, new SearchClue(2682, AlKharid.NorthHouse, new int[] { 358 }));
        CLUES.put(2685, new SearchClue(2685, Varrock.SouthGateHouse, new int[] { 2586 }));
        CLUES.put(2687, new SearchClue(2687, Varrock.EastBankUpstairs, new int[] { 4499, 4500 }));
        CLUES.put(2688, new SearchClue(2688, Varrock.HorviksArmoury, new int[] { 2570 }));
        CLUES.put(2689, new SearchClue(2689, Varrock.GertrudesBedroom, new int[] { 4499, 4500 }));
        CLUES.put(2690, new SearchClue(2690, BarbarianVillage.HelmetStore, new int[] { 11600 }, new Tile(3073, 3430, 0)));
        CLUES.put(2691, new SearchClue(2691, Falador.ShieldStoreUpstairs, new int[] { 348, 349 }));
        CLUES.put(2692, new SearchClue(2692, Falador.GeneralStore, new int[] { 24088 }));
        CLUES.put(2694, new SearchClue(2694, Falador.ChainMailStore, new int[] { 348, 349 }, new Tile(2969, 3311, 0)));
        CLUES.put(2695, new SearchClue(2695, PortSarim.FishingStore, new int[] { 9534 }));
        CLUES.put(2700, new SearchClue(2700, Catherby.ArcheryStore, new int[] { 350, 351 }));
        CLUES.put(2703, new SearchClue(2703, SeersVillage.CastleSouthWestTower, new int[] { 25592, 25593 }));
        CLUES.put(2705, new SearchClue(2705, EastArdougne.MarketArmourStoreOutside, new int [] { 361 }));
        CLUES.put(2706, new SearchClue(2706, EastArdougne.GeneralStore, new int[] { 357 }));
        CLUES.put(2707, new SearchClue(2707, EastArdougne.NorthShed, new int[] { 355 }));
        CLUES.put(2708, new SearchClue(2708, Varrock.ClothesStoreUpstairs, new int[] { 4499, 4500 }));
        CLUES.put(2709, new SearchClue(2709, VarrockCastle.Cart, new int[] { 2571 }));
        CLUES.put(2710, new SearchClue(2710, EastArdougne.PubUpstairs, new int[] { 348, 349 }));
        CLUES.put(2711, new SearchClue(2711, EastArdougne.ChurchTower, new int[] { 357 }));
        CLUES.put(2712, new SearchClue(2712, Falador.EastBankHouse, new int[] { 24088 }, new Tile(3029, 3355, 0)));
        CLUES.put(3490, new SearchClue(3490, Burthorpe.NorthEastHouse, new int[] { 348, 349 }));
        CLUES.put(3491, new SearchClue(3491, Yanille.NorthHouse, new int[] { 357 }, new Tile(2598, 3105, 0)));
        CLUES.put(3492, new SearchClue(3492, Yanille.HunterStore, new int[] { 350, 351 }));
        CLUES.put(3493, new SearchClue(3493, DwarvenMine.CrossbowStore, new int[] { 375, 378 }));
        CLUES.put(3494, new SearchClue(3494, Rimmington.EastHouseUpstairs, new int[] { 352, 353 }));
        CLUES.put(3495, new SearchClue(3495, PortSarim.FoodStoreUpstairs, new int[] { 375, 378 }, new Tile(3016, 3205, 1)));
        CLUES.put(3498, new SearchClue(3498, Falador.EastHouseUpstairs, new int[] { 350, 351 }));
        CLUES.put(3499, new SearchClue(3499, Taverly.TwoHandedSwordStore, new int[] { 360 }, new Tile(2886, 3449, 0)));
        CLUES.put(3500, new SearchClue(3500, Taverly.SouthHouse, new int[] { 350, 351 }));
        CLUES.put(3501, new SearchClue(3501, AlKharid.Tent, new int[] { 361 }));
        CLUES.put(3502, new SearchClue(3502, Draynor.ManorAttic, new int[] { 11485 }, new Tile(3106, 3369, 2)));
        CLUES.put(3503, new SearchClue(3503, Burthorpe.Tent, new int[] { 3686 }));
        CLUES.put(3504, new SearchClue(3504, PortKhazard.Cart, new int[] { 366 }));
        CLUES.put(3505, new SearchClue(3505, EastArdougne.MarketNorthHouseUpstairs, new int[] { 352, 353 }));
        CLUES.put(3506, new SearchClue(3506, SeersVillage.HemensterNorthHouse, new int[] { 357 }, new Tile(2636, 3453, 0)));
        CLUES.put(3507, new SearchClue(3507, Catherby.NorthWestHouseUpstairs, new int[] { 350, 351 }, new Tile(2809, 3451, 1)));
        CLUES.put(3508, new SearchClue(3508, SeersVillage.SpinningHouse, new int[] { 25766, 25767 }));
        CLUES.put(3509, new SearchClue(3509, SeersVillage.SouthHouse, new int[] { 25775 }));
        CLUES.put(3515, new SearchClue(3515, VarrockCastle.Kitchen, new int[] { 2608 } ));
        CLUES.put(12172, new SearchClue(12172, BarbarianVillage.SpinningHut, new int[] { 375, 378 }));
        CLUES.put(12174, new SearchClue(12174, Edgeville.CoffinHouse, new int[] { 398, 399 }, new Tile(3091, 3477, 0)));
        CLUES.put(12175, new SearchClue(12175, Varrock.DigSiteBush, new int[] { 2357 }, new Tile(3345, 3378, 0)));
        CLUES.put(12176, new SearchClue(12176, Varrock.WestBankBasementClueSpot, new int[] { 2571 }, new Tile(3187, 9825, 0)));
        CLUES.put(12177, new SearchClue(12177, Edgeville.MonasteryClueBookcase, new int[] { 380 }));
        CLUES.put(12178, new SearchClue(12178, DwarvenMine.OreStore, new int[] { 357 }, new Tile(3035, 9849, 0)));
        CLUES.put(12167, new SearchClue(12167, WizardsTower.Library, new int[] { 12539 }, new Tile(3113, 3159, 0)));
        CLUES.put(12168, new SearchClue(12168, Draynor.WitchAgiesHouse, new int [] { 5622, 5623 }));
        CLUES.put(12185, new SearchClue(12185, Burthorpe.Pub, new int[] { 354 }, new Tile(2913, 3536, 0)));
        CLUES.put(12188, new SearchClue(12188, PortSarim.NorthHouse, new int[] { 348, 349 }, new Tile(3024, 3259, 0)));
        CLUES.put(12189, new SearchClue(12189, Rimmington.Mine, new int[] { 9625 }));
        CLUES.put(12191, new SearchClue(12191, Taverly.Outhouse, new int[] { 357 }));
        CLUES.put(12192, new SearchClue(12192, PortSarim.ShantyPassCell, new int [] { 9568 }));

        CLUES.put(2684, new TalkClue(2684, AlKharid.Tanner, ELLIS_ID));
        CLUES.put(2686, new TalkClue(2686, Varrock.BlueMoonInn, BLUE_MOON_INN_BARTENDER_ID));
        CLUES.put(2693, new TalkClue(2693, Falador.CastleCourtyard, SQUIRE_ID));
        CLUES.put(2696, new TalkClue(2696, PortSarim.RustyAnchor, RUSTY_ANCHOR_BARTENDER_ID));
        CLUES.put(2697, new TalkClue(2697, Draynor.NedsHouse, NED_ID));
        CLUES.put(2698, new TalkClue(2694, Falador.DoricsHouse, DORIC_ID));
        CLUES.put(2699, new TalkClue(2699, Taverly.TwoHandedSwordStore, GAIUS_ID));
        CLUES.put(2701, new TalkClue(2701, Catherby.GeneralStore, ARHEIN_ID));
        CLUES.put(2702, new TalkClue(2702, SeersVillage.CastleCourtyard, SIR_KAY_ID));
        CLUES.put(3496, new TalkClue(3496, PortSarim.MusaPointBoat, CAPTION_TOBIAS_ID));
        CLUES.put(3513, new TalkClue(3513, SeersVillage.SinclairMansionKitchen, LOUISA_ID));
        CLUES.put(3514, new TalkClue(3514, AlKharid.DuelArenaSpectators, JEED_ID));
        CLUES.put(12169, new TalkClue(12169, Falador.PartyRoomUpstairs, LUCY_ID));
        CLUES.put(12173, new TalkClue(12173, Edgeville.EvilDavesHouse, DORIS_ID));
        CLUES.put(12181, new TalkClue(12181, Falador.ShieldStore, CASSIE_ID));
        CLUES.put(12182, new TalkClue(12182, Falador.CastleThroneRoom, AMBASSADOR_SPANFIPPLE_ID));
        CLUES.put(12183, new TalkClue(12183, Falador.Barber, HAIRDRESSER_ID));
        CLUES.put(12184, new TalkClue(12184, Taverly.HerbloreStore, JATIX_ID));
        CLUES.put(12186, new TalkClue(12186, Falador.Farm, SARAH_ID));
        CLUES.put(12187, new TalkClue(12187, Falador.Rusty, RUSTY_ID));

        CLUE_IDS = new int[CLUES.size()];
        Object[] keys = CLUES.keySet().toArray();
        for(int i = 0; i < keys.length; i++) {
            CLUE_IDS[i] = (int) keys[i];
        }
    }
}
