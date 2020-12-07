package mod.yourmediocrepal.noel.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import mod.yourmediocrepal.noel.entities.SugarPlumFairyEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.VexModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class SugarPlumFairyModel<T extends SugarPlumFairyEntity>  extends BipedModel<SugarPlumFairyEntity> {
	private final ModelRenderer leftWing;
	private final ModelRenderer rightWing;

	public SugarPlumFairyModel() {
		super(0.0F, 0.0F, 64, 64);

		this.bipedLeftLeg.showModel = false;
		this.bipedHeadwear.showModel = false;
		this.bipedRightLeg = new ModelRenderer(this, 32, 0);
		this.bipedRightLeg.addBox(-1.0F, -1.0F, -2.0F, 6.0F, 10.0F, 4.0F, 0.0F);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		this.rightWing = new ModelRenderer(this, 0, 32);
		this.rightWing.addBox(-20.0F, 0.0F, 0.0F, 20.0F, 12.0F, 1.0F);
		this.leftWing = new ModelRenderer(this, 0, 32);
		this.leftWing.mirror = true;
		this.leftWing.addBox(0.0F, 0.0F, 0.0F, 20.0F, 12.0F, 1.0F);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.rightWing, this.leftWing));
	}

	public void setRotationAngles(SugarPlumFairyEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

		this.rightWing.rotationPointZ = 2.0F;
		this.leftWing.rotationPointZ = 2.0F;
		this.rightWing.rotationPointY = 1.0F;
		this.leftWing.rotationPointY = 1.0F;
		this.rightWing.rotateAngleY = 0.47123894F + MathHelper.cos(ageInTicks * 0.8F) * (float)Math.PI * 0.05F;
		this.leftWing.rotateAngleY = -this.rightWing.rotateAngleY;
		this.leftWing.rotateAngleZ = -0.47123894F;
		this.leftWing.rotateAngleX = 0.47123894F;
		this.rightWing.rotateAngleX = 0.47123894F;
		this.rightWing.rotateAngleZ = 0.47123894F;
	}

}