package dev.breadpudding.altoidstin.entities.penguin;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class Penguin extends AnimalEntity {
    public static final EntityType<Penguin> PENGUIN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("altoidstin", "penguin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Penguin::new).dimensions(EntityDimensions.fixed(0.5F, 1.0F)).build()
    );

    private static final Ingredient BREEDING_INGREDIENT;

    public static void register() {
        FabricDefaultAttributeRegistry.register(PENGUIN, Penguin.createMobAttributes());
        BiomeModifications.addSpawn(
                BiomeSelectors.categories(Biome.Category.ICY),
                SpawnGroup.CREATURE,
                PENGUIN,
                10,
                3,
                5
        );
    }

    public Penguin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.initGoals();
    }

    protected void initGoals() {
        // Introduce goals to make the entity move and interact.
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25D/3));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.0D/3));
        this.goalSelector.add(4, new TemptGoal(this, 1.2D/3, BREEDING_INGREDIENT, false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.1D/3));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D/3));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    // TODO: Create and import sound effects for Penguins

    @Override
    public PassiveEntity createChild(ServerWorld serverWorld, PassiveEntity entity) {
        // TODO: Make an actual baby penguin (and make sure the FollowParentGoal functions correctly)
        return PENGUIN.create(serverWorld);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    static {
        BREEDING_INGREDIENT = Ingredient.ofItems(
                Items.TROPICAL_FISH,
                Items.TROPICAL_FISH_BUCKET,
                Items.COD,
                Items.COD_BUCKET,
                Items.SALMON,
                Items.SALMON_BUCKET
        );
    }
}
