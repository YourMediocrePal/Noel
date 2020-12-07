package mod.yourmediocrepal.noel.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ElfModel<T extends ElfEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer nose;
    private final ModelRenderer body;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_leg;
    private final ModelRenderer headwear;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_arm;

    public ElfModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 10.0F, 0.0F);
        head.setTextureOffset(0, 2).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        nose = new ModelRenderer(this);
        nose.setRotationPoint(0.0F, 10.0F, 0.0F);
        nose.setTextureOffset(24, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 0.0F);
        body.setTextureOffset(16, 20).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 10.0F, 6.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(-4.0F, 12.0F, 0.0F);
        left_arm.setTextureOffset(44, 22).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(1.5F, 20.0F, 0.0F);
        right_leg.setTextureOffset(0, 35).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);

        headwear = new ModelRenderer(this);
        headwear.setRotationPoint(0.0F, 11.0F, 0.0F);
        headwear.setTextureOffset(0, 53).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
        headwear.setTextureOffset(32, 0).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
        headwear.setTextureOffset(38, 46).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 2.0F, 9.0F, 0.0F, false);
        headwear.setTextureOffset(56, 60).addBox(-1.0F, -12.0F, 4.75F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(-1.5F, 20.0F, 0.0F);
        left_leg.setTextureOffset(0, 24).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(0.0F, 24.0F, 0.0F);
        right_arm.setTextureOffset(44, 34).addBox(4.0F, -14.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        nose.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        headwear.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.headwear.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.headwear.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.nose.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.nose.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        //this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        //this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }

}
