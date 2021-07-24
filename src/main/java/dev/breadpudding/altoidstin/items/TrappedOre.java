package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.util.SimpleBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/**
 * Fake ores that have a 50% chance of exploding when mined
 * 
 * @author Alexander Hill
 */
public class TrappedOre {
    public static final SimpleBlock TRAPPED_COAL_ORE = new SimpleBlock("trapped_coal_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_COPPER_ORE = new SimpleBlock("trapped_copper_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_COAL_ORE = new SimpleBlock("trapped_deepslate_coal_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_COPPER_ORE = new SimpleBlock("trapped_deepslate_copper_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_DIAMOND_ORE = new SimpleBlock("trapped_deepslate_diamond_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_EMERALD_ORE = new SimpleBlock("trapped_deepslate_emerald_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_GOLD_ORE = new SimpleBlock("trapped_deepslate_gold_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_IRON_ORE = new SimpleBlock("trapped_deepslate_iron_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_LAPIS_ORE = new SimpleBlock("trapped_deepslate_lapis_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DEEPSLATE_REDSTONE_ORE = new SimpleBlock("trapped_deepslate_redstone_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_DIAMOND_ORE = new SimpleBlock("trapped_diamond_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_EMERALD_ORE = new SimpleBlock("trapped_emerald_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_GOLD_ORE = new SimpleBlock("trapped_gold_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_IRON_ORE = new SimpleBlock("trapped_iron_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_LAPIS_ORE = new SimpleBlock("trapped_lapis_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_NETHER_GOLD_ORE = new SimpleBlock("trapped_nether_gold_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_NETHER_QUARTZ_ORE = new SimpleBlock("trapped_nether_quartz_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);
    public static final SimpleBlock TRAPPED_REDSTONE_ORE = new SimpleBlock("trapped_redstone_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);

    /**
     * Registers all the trapped ore blocks
     * 
     * @author Alexander Hill
     */
    public static void register() {
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
