package mod.yourmediocrepal.entity.client;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.entity.custom.SantaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SantaRenderer extends MobEntityRenderer<SantaEntity, SantaModel<SantaEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Noel.MOD_ID, "textures/entity/santa.png");
    public SantaRenderer(EntityRendererFactory.Context context) {
        super(context, new SantaModel<>(context.getPart(NoelModelLayers.SANTA)), 0.6f);
    }

    @Override
    public Identifier getTexture(SantaEntity entity) {
        return TEXTURE;
    }
}
