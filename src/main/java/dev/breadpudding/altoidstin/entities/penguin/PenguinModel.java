package dev.breadpudding.altoidstin.entities.penguin;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

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
        /*
         * Information about following structure:
         * Cuboids are placed relative to the pivot point
         * The uv() call defines the texture coordinates for the following cuboid
         */
        modelPartData.addChild(
                "head",
                ModelPartBuilder.create()
                .uv(16, 0)
                .cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F)
                .uv(0, 5)
                .cuboid(-1.0F, -2.0F, -5.0F, 2.0F, 1.0F, 3.0F),
                ModelTransform.pivot(0.0F, 13.0F, -1.0F)
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

    // Function that handles animating the model
    @Override
    public void setAngles(Penguin entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch){
		// Head rotation (values copied from QuadrupedEntityModel)
        this.head.pitch = headPitch * 0.017453292F;
        this.head.yaw = headYaw * 0.017453292F;

        // Flipper animation (slowly getting closer and further away)
        // TODO: Finalize the animation speed and amount
        float flipper_anim = (animationProgress % 20)/2;
        if(flipper_anim > 5) {
            flipper_anim = 10 - flipper_anim;
        }
        this.flipper_l.roll = -0.1309F + (flipper_anim * 0.01F);
        this.flipper_r.roll = 0.1309F - (flipper_anim *  0.01F);

        // Feet when moving (I honestly have no idea how this works - slightly modified from QuadrupedEntityModel)
        // TODO: Make it so the feet do not go into the ground
        this.foot_l.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance / 2;
        this.foot_r.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2;
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		// TODO: Find a way to make the penguin walk above snow layers as not to hide its feet

        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		flipper_r.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		flipper_l.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		foot_r.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		foot_l.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}