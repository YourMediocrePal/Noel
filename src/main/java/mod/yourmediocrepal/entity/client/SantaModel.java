package mod.yourmediocrepal.entity.client;

import mod.yourmediocrepal.entity.custom.SantaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;


public class SantaModel<T extends SantaEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Santa;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	public SantaModel(ModelPart root) {
		this.Santa = root.getChild("Santa");
		this.body = this.Santa.getChild("body");
		this.head = this.body.getChild("head");
		this.hat = this.head.getChild("hat");
		this.leftLeg = this.body.getChild("leftLeg");
		this.rightLeg = this.body.getChild("rightLeg");
		this.rightArm = this.body.getChild("rightArm");
		this.leftArm = this.body.getChild("leftArm");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Santa = modelPartData.addChild("Santa", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = Santa.addChild("body", ModelPartBuilder.create().uv(0, 36).cuboid(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(28, 17).cuboid(6.5F, -11.75F, -1.75F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 24).cuboid(-4.5F, -9.75F, -5.0F, 10.0F, 2.0F, 10.0F, new Dilation(0.0F))
				.uv(28, 36).cuboid(-3.5F, -12.75F, -4.0F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F))
				.uv(40, 26).cuboid(-1.0F, -4.0F, -6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(40, 17).cuboid(-3.0F, -2.1F, -3.0F, 9.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -12.75F, 0.0F, 0.0F, 0.0F, 0.3054F));

		ModelPartData hat = head.addChild("hat", ModelPartBuilder.create(), ModelTransform.of(1.5F, -12.75F, 0.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData leftLeg = body.addChild("leftLeg", ModelPartBuilder.create().uv(28, 47).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -12.0F, 0.0F));

		ModelPartData rightLeg = body.addChild("rightLeg", ModelPartBuilder.create().uv(44, 47).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -12.0F, 0.0F));

		ModelPartData rightArm = body.addChild("rightArm", ModelPartBuilder.create().uv(0, 54).cuboid(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -23.0F, 0.0F));

		ModelPartData leftArm = body.addChild("leftArm", ModelPartBuilder.create().uv(60, 0).cuboid(-1.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -23.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(SantaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yaw = netHeadYaw * ((float)Math.PI / 180F);
		this.head.pitch = headPitch * ((float)Math.PI / 180F);

		this.leftArm.pitch = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.rightArm.pitch = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;

		this.leftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
		this.rightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Santa.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return Santa;
	}

}