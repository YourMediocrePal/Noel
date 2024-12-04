// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package mod.yourmediocrepal.entity.client;

import mod.yourmediocrepal.entity.custom.SugarPlumFairyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SugarPlumFairyModel<T extends SugarPlumFairyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart head;
	public SugarPlumFairyModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.right_arm = this.body.getChild("right_arm");
		this.left_arm = this.body.getChild("left_arm");
		this.left_wing = this.body.getChild("left_wing");
		this.right_wing = this.body.getChild("right_wing");
		this.head = this.body.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 10).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 16).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 5.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(23, 6).cuboid(-0.75F, -0.5F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.75F, 0.5F, 0.0F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(23, 0).cuboid(-0.25F, -0.5F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.75F, 0.5F, 0.0F));

		ModelPartData left_wing = body.addChild("left_wing", ModelPartBuilder.create().uv(16, 14).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 1.0F, 1.0F));

		ModelPartData right_wing = body.addChild("right_wing", ModelPartBuilder.create().uv(16, 14).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 1.0F, 1.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -5.01F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		root.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		float k = animationProgress * 20.0F * (float) (Math.PI / 180.0) + limbAngle;
		float l = MathHelper.cos(k) * (float) Math.PI * 0.15F + limbDistance;
		float m = animationProgress - (float)entity.age;
		float n = animationProgress * 9.0F * (float) (Math.PI / 180.0);
		float o = Math.min(limbDistance / 0.3F, 1.0F);
		float p = 1.0F - o;
		float q = entity.method_43397(m);

		this.right_wing.pitch = 0.43633232F * (1.0F - o);
		this.right_wing.yaw = (float) (-Math.PI / 4) + l;
		this.left_wing.pitch = 0.43633232F * (1.0F - o);
		this.left_wing.yaw = (float) (Math.PI / 4) - l;
		this.body.pitch = o * (float) (Math.PI / 4);
		float r = q * MathHelper.lerp(o, (float) (-Math.PI / 3), -1.134464F);
		this.root.pivotY = this.root.pivotY + (float)Math.cos((double)n) * 0.25F * p;
		this.right_arm.pitch = r;
		this.left_arm.pitch = r;
		float s = p * (1.0F - q);
		float t = 0.43633232F - MathHelper.cos(n + (float) (Math.PI * 3.0 / 2.0)) * (float) Math.PI * 0.075F * s;
		this.left_arm.roll = -t;
		this.right_arm.roll = t;
		this.right_arm.yaw = 0.27925268F * q;
		this.left_arm.yaw = -0.27925268F * q;
	}
}