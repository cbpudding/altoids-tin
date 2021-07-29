package dev.breadpudding.altoidstin.entities.penguin;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PenguinModel extends EntityModel<Penguin> {
    private final ModelPart head;
	private final ModelPart body;
	private final ModelPart flipper_r;
	private final ModelPart flipper_l;
	private final ModelPart foot_r;
	private final ModelPart foot_l;

    public PenguinModel(ModelPart modelPart) {
        this.head = modelPart.getChild("head");
        this.body = modelPart.getChild("body");
        this.flipper_r = modelPart.getChild("flipper_r");
        this.flipper_l = modelPart.getChild("flipper_l");
        this.foot_r = modelPart.getChild("foot_r");
        this.foot_l = modelPart.getChild("foot_l");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(
                "head",
                ModelPartBuilder.create()
                .uv(16, 0)
                .cuboid(-2.0F, -15.0F, -3.0F, 4.0F, 4.0F, 4.0F)
                .uv(0, 5)
                .cuboid(-1.0F, -13.0F, -6.0F, 2.0F, 1.0F, 3.0F),
                ModelTransform.pivot(0.0F, 24.0F, 0.0F)

        );

        modelPartData.addChild(
                "body",
                ModelPartBuilder.create()
                .uv(10, 17)
                .cuboid(-3.0F, -6.25F, -2.0F, 6.0F, 10.0F, 5.0F),
                ModelTransform.pivot(0.0F, 19.25F, -1.0F)
        );

        modelPartData.addChild(
                "flipper_r",
                ModelPartBuilder.create()
                .uv(0, 23)
                .cuboid(-1.0F, 0.0F, -1.5F, 1.0F, 6.0F, 3.0F),
                ModelTransform.of(-3.0F, 14.0F, -0.5F, 0.0F, 0.0F, 0.1309F)
        );

        modelPartData.addChild(
                "flipper_l",
                ModelPartBuilder.create()
                .uv(0, 23)
                .cuboid(-1.0F, 0.0F, -1.5F, 1.0F, 6.0F, 3.0F),
                ModelTransform.of(3.0F, 14.0F, -0.5F, 0.0F, 3.1416F, -0.1309F)

        );

        modelPartData.addChild(
                "foot_r",
                ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-2.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F),
                ModelTransform.of(-1.0F, 23.0F, 0.0F, 0.0F, 0.3927F, 0.0F)
        );

        modelPartData.addChild(
                "foot_l",
                ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(0.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F),
                ModelTransform.of(1.0F, 24.0F, 0.0F, 0.0F, -0.3927F, 0.0F)
       );

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(Penguin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        matrixStack.translate(0, 1, 0);

		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		flipper_r.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		flipper_l.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		foot_r.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		foot_l.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}