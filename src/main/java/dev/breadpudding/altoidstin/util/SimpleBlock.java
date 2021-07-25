package dev.breadpudding.altoidstin.util;

import dev.breadpudding.altoidstin.AltoidsTin;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Since my tiny brain can't handle five different classes for a single block, I've created a class that handles all the madness for me.
 * 
 * @author Alexander Hill
 */
public class SimpleBlock {
    protected Block block;
    protected BlockItem blockItem;
    protected FabricBlockSettings blockSettings;
    protected Identifier id;
    protected Item.Settings itemSettings;

    /**
     * Constructs a block using a bunch of classes under the hood
     * 
     * @author Alexander Hill
     * @param id ID of the block
     * @param material Material the block is made of
     * @param strength
     * @param group What item group the block is a part of
     */
    public SimpleBlock(String id, Material material, float hardness, float resistance, ItemGroup group) {
        this.id = new Identifier(AltoidsTin.MOD_ID, id);
        this.blockSettings = FabricBlockSettings.of(material).strength(hardness, resistance);
        this.block = new Block(this.blockSettings);
        this.itemSettings = new Item.Settings().group(group);
        this.blockItem = new BlockItem(this.block, this.itemSettings);
    }

    /**
     * Registers the block with the game
     * 
     * @author Alexander Hill
     */
    public void register() {
        Registry.register(Registry.BLOCK, this.id, this.block);
        Registry.register(Registry.ITEM, this.id, this.blockItem);
    }
}
