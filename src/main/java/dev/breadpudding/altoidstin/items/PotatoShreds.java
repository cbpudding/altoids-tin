package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.AltoidsTin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * The first and only real ingredient needed to make hash browns
 * 
 * @author Alexander Hill
 */
public class PotatoShreds {
    /**
     * The item itself
     * 
     * @author Alexander Hill
     */
    public static final Item POTATO_SHREDS = new Item(new Item.Settings().group(ItemGroup.FOOD));

    /**
     * Registers the potato shreds to that they appear in-game
     * 
     * @author Alexander Hill
     */
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(AltoidsTin.MOD_ID, "potato_shreds"), POTATO_SHREDS);
    }
}
