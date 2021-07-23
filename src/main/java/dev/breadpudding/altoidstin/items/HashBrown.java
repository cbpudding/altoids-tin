package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.AltoidsTin;
import net.minecraft.item.FoodComponent;
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
    private static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder().alwaysEdible().hunger(4).snack().build();
    private static final Identifier IDENTIFIER = new Identifier(AltoidsTin.MOD_ID, "hash_brown");
    private static final Item.Settings ITEM_SETTINGS = new Item.Settings().group(ItemGroup.FOOD).food(FOOD_COMPONENT);

    public static final Item HASH_BROWN = new Item(ITEM_SETTINGS);

    /**
     * Registers our glorious hash brown with the Fabric modloader
     * 
     * @author Alexander Hill
     */
    public static void register() {
        Registry.register(Registry.ITEM, IDENTIFIER, HASH_BROWN);
    }
}
