package mod.yourmediocrepal.noel.client.render;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.client.model.ElfModel;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ElfRenderer extends MobRenderer<ElfEntity, ElfModel<ElfEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Noel.MOD_ID, "textures/entity/elf.png");
    public ElfRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ElfModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ElfEntity entity) {
        return TEXTURE;
    }
}
