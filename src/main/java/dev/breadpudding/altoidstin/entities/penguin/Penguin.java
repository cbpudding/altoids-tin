package dev.breadpudding.altoidstin.entities.penguin;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class Penguin extends PathAwareEntity {
    public static final EntityType<Penguin> PENGUIN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("altoidstin", "penguin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Penguin::new).build()
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(PENGUIN, Penguin.createMobAttributes());
    }

    public Penguin(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
