package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.util.SimpleBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;

/**
 * Fake ores that have a 50% chance of exploding when mined
 * 
 * @author Alexander Hill
 */
public class TrappedOre {
    public static final SimpleBlock TRAPPED_DIAMOND_ORE = new SimpleBlock("trapped_diamond_ore", Material.STONE, 4.0f, ItemGroup.BUILDING_BLOCKS);

    /**
     * Registers all the trapped ore blocks
     * 
     * @author Alexander Hill
     */
    public static void register() {
        TRAPPED_DIAMOND_ORE.register();
        // ...
    }
}
