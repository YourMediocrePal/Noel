package mod.yourmediocrepal.noel.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.client.model.SugarPlumFairyModel;
import mod.yourmediocrepal.noel.entities.SugarPlumFairyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.util.ResourceLocation;

public class SugarPlumFairyRenderer extends MobRenderer<SugarPlumFairyEntity, SugarPlumFairyModel<SugarPlumFairyEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Noel.MOD_ID, "textures/entity/sugar_plum_fairy.png");

    public SugarPlumFairyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SugarPlumFairyModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(SugarPlumFairyEntity entity) {
        return TEXTURE;
    }


    protected void preRenderCallback(SugarPlumFairyEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.4F, 0.4F, 0.4F);
    }
}
