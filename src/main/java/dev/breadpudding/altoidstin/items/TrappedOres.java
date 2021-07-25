package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.items.TrappedOre.OreType;

/**
 * @author Alexander Hill
 */
public class TrappedOres {
    public static final TrappedOre TRAPPED_COAL_ORE = new TrappedOre("trapped_coal_ore", 3.0f, 3.0f, 0, OreType.STONE, 0, 127, 37, 20);
    public static final TrappedOre TRAPPED_COPPER_ORE = new TrappedOre("trapped_copper_ore", 3.0f, 3.0f, 1, OreType.STONE, 0, 96, 16, 6);
    public static final TrappedOre TRAPPED_DEEPSLATE_COAL_ORE = new TrappedOre("trapped_deepslate_coal_ore", 4.5f, 3.0f, 0, OreType.DEEPSLATE, 0, 127, 37, 20);
    public static final TrappedOre TRAPPED_DEEPSLATE_COPPER_ORE = new TrappedOre("trapped_deepslate_copper_ore", 4.5f, 3.0f, 1, OreType.DEEPSLATE, 0, 16, 16, 6);
    public static final TrappedOre TRAPPED_DEEPSLATE_DIAMOND_ORE = new TrappedOre("trapped_deepslate_diamond_ore", 4.5f, 3.0f, 2, OreType.DEEPSLATE, 1, 16, 10, 1);
    public static final TrappedOre TRAPPED_DEEPSLATE_EMERALD_ORE = new TrappedOre("trapped_deepslate_emerald_ore", 4.5f, 3.0f, 2, OreType.DEEPSLATE, 4, 31, 1, 8);
    public static final TrappedOre TRAPPED_DEEPSLATE_GOLD_ORE = new TrappedOre("trapped_deepslate_gold_ore", 4.5f, 3.0f, 2, OreType.DEEPSLATE, 0, 32, 13, 2);
    public static final TrappedOre TRAPPED_DEEPSLATE_IRON_ORE = new TrappedOre("trapped_deepslate_iron_ore", 4.5f, 3.0f, 1, OreType.DEEPSLATE, 0, 63, 13, 20);
    public static final TrappedOre TRAPPED_DEEPSLATE_LAPIS_ORE = new TrappedOre("trapped_deepslate_lapis_ore", 4.5f, 3.0f, 1, OreType.DEEPSLATE, 0, 30, 10, 1);
    public static final TrappedOre TRAPPED_DEEPSLATE_REDSTONE_ORE = new TrappedOre("trapped_deepslate_redstone_ore", 4.5f, 3.0f, 2, OreType.DEEPSLATE, 1, 16, 10, 8);
    public static final TrappedOre TRAPPED_DIAMOND_ORE = new TrappedOre("trapped_diamond_ore", 3.0f, 3.0f, 2, OreType.STONE, 1, 16, 10, 1);
    public static final TrappedOre TRAPPED_EMERALD_ORE = new TrappedOre("trapped_emerald_ore", 3.0f, 3.0f, 2, OreType.STONE, 4, 31, 1, 8);
    public static final TrappedOre TRAPPED_GOLD_ORE = new TrappedOre("trapped_gold_ore", 3.0f, 3.0f, 2, OreType.STONE, 0, 32, 13, 2);
    public static final TrappedOre TRAPPED_IRON_ORE = new TrappedOre("trapped_iron_ore", 3.0f, 3.0f, 1, OreType.STONE, 0, 63, 13, 20);
    public static final TrappedOre TRAPPED_LAPIS_ORE = new TrappedOre("trapped_lapis_ore", 3.0f, 3.0f, 1, OreType.STONE, 0, 30, 10, 1);
    public static final TrappedOre TRAPPED_NETHER_GOLD_ORE = new TrappedOre("trapped_nether_gold_ore", 3.0f, 3.0f, 0, OreType.NETHER, 10, 117, 16, 10);
    public static final TrappedOre TRAPPED_NETHER_QUARTZ_ORE = new TrappedOre("trapped_nether_quartz_ore", 3.0f, 3.0f, 0, OreType.NETHER, 10, 117, 24, 16);
    public static final TrappedOre TRAPPED_REDSTONE_ORE = new TrappedOre("trapped_redstone_ore", 3.0f, 3.0f, 2, OreType.STONE, 1, 16, 10, 8);

    /**
     * Registers all the trapped ores with the game
     * 
     * @author Alexander Hill
     */
    public static void register() {
        // Items appear in the order they are registered
        // I'll be mimicing how they appear in the creative inventory as well
        TRAPPED_COAL_ORE.register();
        TRAPPED_DEEPSLATE_COAL_ORE.register();
        TRAPPED_IRON_ORE.register();
        TRAPPED_DEEPSLATE_IRON_ORE.register();
        TRAPPED_COPPER_ORE.register();
        TRAPPED_DEEPSLATE_COPPER_ORE.register();
        TRAPPED_GOLD_ORE.register();
        TRAPPED_DEEPSLATE_GOLD_ORE.register();
        TRAPPED_REDSTONE_ORE.register();
        TRAPPED_DEEPSLATE_REDSTONE_ORE.register();
        TRAPPED_EMERALD_ORE.register();
        TRAPPED_DEEPSLATE_EMERALD_ORE.register();
        TRAPPED_LAPIS_ORE.register();
        TRAPPED_DEEPSLATE_LAPIS_ORE.register();
        TRAPPED_DIAMOND_ORE.register();
        TRAPPED_DEEPSLATE_DIAMOND_ORE.register();
        TRAPPED_NETHER_GOLD_ORE.register();
        TRAPPED_NETHER_QUARTZ_ORE.register();
    }
}
