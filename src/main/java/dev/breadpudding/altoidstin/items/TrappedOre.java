package dev.breadpudding.altoidstin.items;

import java.util.Random;
import java.util.function.Predicate;

import dev.breadpudding.altoidstin.AltoidsTin;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import net.minecraft.world.explosion.Explosion.DestructionType;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.YOffset;

/**
 * Fake ores that have a 50% chance of exploding when mined
 * 
 * @author Alexander Hill
 */
public class TrappedOre {
    private Block block;
    private BlockItem blockItem;
    private FabricBlockSettings blockSettings;
    private Identifier id;
    private Item.Settings itemSettings;
    private ConfiguredFeature<?, ?> oreGeneration;
    private OreType type;

    public TrappedOre(String id, float hardness, float resistance, int miningLevel, OreType type, int lowest, int highest, int veinSize, int veinCount) {
        // TODO: Add parameters for acceptable depth, vein size, and vein count.
        this.id = new Identifier(AltoidsTin.MOD_ID, id);
        this.blockSettings = FabricBlockSettings.of(Material.STONE).strength(hardness, resistance).breakByTool(FabricToolTags.PICKAXES, miningLevel).requiresTool();
        this.block = new TrappedBlock(this.blockSettings);
        this.itemSettings = new Item.Settings().group(ItemGroup.BUILDING_BLOCKS);
        this.blockItem = new BlockItem(this.block, this.itemSettings);
        this.type = type;
        RuleTest config = null;
        if(type == OreType.DEEPSLATE) {
            config = OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES;
        } else if(type == OreType.NETHER) {
            config = OreFeatureConfig.Rules.NETHERRACK;
        } else if(type == OreType.STONE) {
            config = OreFeatureConfig.Rules.STONE_ORE_REPLACEABLES;
        }
        this.oreGeneration = Feature.ORE
        .configure(new OreFeatureConfig(config, block.getDefaultState(), veinSize))
        .range(new RangeDecoratorConfig(
            UniformHeightProvider.create(YOffset.aboveBottom(lowest), YOffset.fixed(highest))))
        .spreadHorizontally()
        .repeat(veinCount);
    }

    /**
     * Registers the block with the game
     * 
     * @author Alexander Hill
     */
    public void register() {
        Identifier oreGenId = new Identifier(AltoidsTin.MOD_ID, this.id.getPath() + "_oregen");
        RegistryKey<ConfiguredFeature<?, ?>> key = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, oreGenId);
        Registry.register(Registry.BLOCK, this.id, this.block);
        Registry.register(Registry.ITEM, this.id, this.blockItem);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), this.oreGeneration);
        Predicate<BiomeSelectionContext> foundLocation = BiomeSelectors.foundInOverworld();
        if(this.type == OreType.NETHER) {
            foundLocation = BiomeSelectors.foundInTheNether();
        }
        BiomeModifications.addFeature(foundLocation, GenerationStep.Feature.UNDERGROUND_ORES, key);
    }

    /**
     * A class to introduce the basic behavior of trapped blocks
     * 
     * @author Alexander Hill
     */
    private class TrappedBlock extends Block {
        public TrappedBlock(Block.Settings settings) {
            super(settings);
        }

        @Override
        public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
            if(!world.isClient) {
                ServerWorld serverWorld = (ServerWorld)world;
                // TODO: Does Silk Touch guarantee that it won't blow up?
                if(!player.isCreative() && Math.random() > 0.5) {
                    // TODO: Can we use a custom death message here(preferably one to humiliate players)?
                    Explosion explosion = serverWorld.createExplosion(null, DamageSource.explosion(player), new ExplosionBehavior(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5.0f, true, DestructionType.DESTROY);
                    explosion.collectBlocksAndDamageEntities();
                }
                // TODO: Drop the ore if it doesn't explode.
            }
        }

        @Environment(EnvType.CLIENT)
        @Override
        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            // Get the current position of the block
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            // Pick a random face to spawn the particle
            int side = random.nextInt() % 6;
            // Pick a random location on the chosen face
            double offsetX = random.nextGaussian() / 2;
            double offsetY = random.nextGaussian() / 2;
            // Calculate the coordinates for the place we just selected
            switch(side) {
                case 0:
                    x += 1.0;
                case 1:
                    y += offsetX;
                    z += offsetY;
                    break;
                case 2:
                    y += 1.0;
                case 3:
                    x += offsetX;
                    z += offsetY;
                    break;
                case 4:
                    z += 1.0;
                case 5:
                    x += offsetX;
                    y += offsetY;
                    break;
                default:
                    break; // How do we even get here?
            }
            // Add the gunpowder particle to the world
            world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    public enum OreType {
        DEEPSLATE,
        NETHER,
        STONE
    }
}
