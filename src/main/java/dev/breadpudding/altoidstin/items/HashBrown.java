package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.AltoidsTin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * A class written for the sole purpose of adding hash browns to Minecraft
 * 
 * @author Alexander Hill
 */
public class HashBrown {
    /**
     * The hash brown itself
     * 
     * @author Alexander Hill
     */
    public static final Item HASH_BROWN = new Item(new Item.Settings().group(ItemGroup.FOOD));

    /**
     * Registers our glorious hash brown with the Fabric modloader
     * 
     * @author Alexander Hill
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(AltoidsTin.MOD_ID, "hash_brown"), HASH_BROWN);
    }
}
