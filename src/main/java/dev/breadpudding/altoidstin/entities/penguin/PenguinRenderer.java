package dev.breadpudding.altoidstin.entities.penguin;

import dev.breadpudding.altoidstin.AltoidsTinClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PenguinRenderer extends MobEntityRenderer<Penguin, PenguinModel> {
    public PenguinRenderer(EntityRendererFactory.Context context) {
        super(context, new PenguinModel(context.getPart(AltoidsTinClient.MODEL_PENGUIN_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(Penguin entity) {
        return new Identifier("altoidstin", "textures/entity/penguin/penguin.png");
    }
}
