package mod.yourmediocrepal.noel.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.client.model.GingerBreadModel;
import mod.yourmediocrepal.noel.client.model.SugarPlumFairyModel;
import mod.yourmediocrepal.noel.entities.GingerBreadEntity;
import mod.yourmediocrepal.noel.entities.SugarPlumFairyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GingerBreadRenderer extends MobRenderer<GingerBreadEntity, GingerBreadModel<GingerBreadEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Noel.MOD_ID, "textures/entity/ginger_bread_man.png");

    public GingerBreadRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GingerBreadModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(GingerBreadEntity entity) {
        return TEXTURE;
    }


    protected void preRenderCallback(GingerBreadEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.4F, 0.4F, 0.4F);
    }
}
