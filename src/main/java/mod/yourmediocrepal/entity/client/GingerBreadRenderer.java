package mod.yourmediocrepal.entity.client;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.entity.custom.GingerBreadEntity;
import mod.yourmediocrepal.entity.custom.SantaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GingerBreadRenderer extends MobEntityRenderer<GingerBreadEntity, GingerBreadModel<GingerBreadEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Noel.MOD_ID, "textures/entity/ginger_bread.png");
    public GingerBreadRenderer(EntityRendererFactory.Context context) {
        super(context, new GingerBreadModel<>(context.getPart(NoelModelLayers.GINGER_BREAD)), 0.25f);
    }

    @Override
    public Identifier getTexture(GingerBreadEntity entity) {
        return TEXTURE;
    }
}
