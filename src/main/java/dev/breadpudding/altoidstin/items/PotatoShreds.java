package dev.breadpudding.altoidstin.items;

import dev.breadpudding.altoidstin.AltoidsTin;
import net.minecraft.item.FoodComponent;
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
    private static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder().alwaysEdible().hunger(1).build();
    private static final Identifier IDENTIFIER = new Identifier(AltoidsTin.MOD_ID, "potato_shreds");
    private static final Item.Settings ITEM_SETTINGS = new Item.Settings().group(ItemGroup.FOOD).food(FOOD_COMPONENT);

    public static final Item POTATO_SHREDS = new Item(ITEM_SETTINGS);

    /**
     * Registers the potato shreds to that they appear in-game
     * 
     * @author Alexander Hill
     */
    public static void register() {
        Registry.register(Registry.ITEM, IDENTIFIER, POTATO_SHREDS);
    }
}
