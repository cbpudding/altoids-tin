package dev.breadpudding.altoidstin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HashBrown {
    public static final Item HASH_BROWN = new Item(new Item.Settings().group(ItemGroup.FOOD));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(AltoidsTin.MOD_ID, "hash_brown"), HASH_BROWN);
    }
}
