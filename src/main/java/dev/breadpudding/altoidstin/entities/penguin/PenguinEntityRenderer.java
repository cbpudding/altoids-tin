package dev.breadpudding.altoidstin.entities.penguin;

import dev.breadpudding.altoidstin.AltoidsTinClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PenguinEntityRenderer extends MobEntityRenderer<PenguinEntity, PenguinEntityModel> {
    public PenguinEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PenguinEntityModel(context.getPart(AltoidsTinClient.MODEL_PENGUIN_LAYER)), /* Shadow Radius */ 0.3f);
    }

    @Override
    public Identifier getTexture(PenguinEntity entity) {
        return new Identifier("altoidstin", "textures/entity/penguin/penguin.png");
    }
}
