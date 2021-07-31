package dev.breadpudding.altoidstin;

import dev.breadpudding.altoidstin.entities.penguin.PenguinEntity;
import dev.breadpudding.altoidstin.entities.penguin.PenguinEntityModel;
import dev.breadpudding.altoidstin.entities.penguin.PenguinEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AltoidsTinClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_PENGUIN_LAYER = new EntityModelLayer(new Identifier("altoidstin", "penguin"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(PenguinEntity.PENGUIN, PenguinEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PENGUIN_LAYER, PenguinEntityModel::getTexturedModelData);
    }
}