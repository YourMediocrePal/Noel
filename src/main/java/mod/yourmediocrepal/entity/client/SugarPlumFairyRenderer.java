package mod.yourmediocrepal.entity.client;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.entity.custom.SantaEntity;
import mod.yourmediocrepal.entity.custom.SugarPlumFairyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SugarPlumFairyRenderer extends MobEntityRenderer<SugarPlumFairyEntity, SugarPlumFairyModel<SugarPlumFairyEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Noel.MOD_ID, "textures/entity/sugar_plum_fairy.png");
    public SugarPlumFairyRenderer(EntityRendererFactory.Context context) {
        super(context, new SugarPlumFairyModel<>(context.getPart(NoelModelLayers.SUGAR_PLUM_FAIRY)), 0.25f);
    }

    @Override
    public Identifier getTexture(SugarPlumFairyEntity entity) {
        return TEXTURE;
    }

}
