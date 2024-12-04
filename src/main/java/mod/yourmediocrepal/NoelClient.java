package mod.yourmediocrepal;


import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import mod.yourmediocrepal.block.WreathBlockColorProvider;
import mod.yourmediocrepal.block.WreathItemColorProvider;
import mod.yourmediocrepal.entity.NoelBoats;
import mod.yourmediocrepal.entity.NoelEntities;
import mod.yourmediocrepal.entity.client.*;
import mod.yourmediocrepal.init.NoelBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;


public class NoelClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.FROSTED_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.FROSTED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.PEPPERMINT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.PEPPERMINT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.SHRUB_TREE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.OAK_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.SPRUCE_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.BIRCH_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.JUNGLE_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.ACACIA_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.DARK_OAK_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.AZALEA_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.MANGROVE_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.CHERRY_WREATH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.POINSETTIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.POTTED_POINSETTIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.MISTLETOE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.PRESENT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.PRESENT_TRAP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.YELLOW_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.WHITE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.LIGHT_GRAY_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.RED_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.PURPLE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.PINK_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.ORANGE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.MAGENTA_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.LIME_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.LIGHT_BLUE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.BLUE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.GREEN_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.GRAY_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.CYAN_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.BROWN_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.BLACK_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(NoelBlocks.GLASS_ORNAMENT, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(NoelModelLayers.SANTA, SantaModel::getTexturedModelData);
        EntityRendererRegistry.register(NoelEntities.SANTA, SantaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(NoelModelLayers.SUGAR_PLUM_FAIRY, SugarPlumFairyModel::getTexturedModelData);
        EntityRendererRegistry.register(NoelEntities.SUGAR_PLUM_FAIRY, SugarPlumFairyRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(NoelModelLayers.GINGER_BREAD, GingerBreadModel::getTexturedModelData);
        EntityRendererRegistry.register(NoelEntities.GINGER_BREAD, GingerBreadRenderer::new);

        TerraformBoatClientHelper.registerModelLayers(NoelBoats.FROSTED_BOAT_ID, false);

        WreathBlockColorProvider.initiialize();
        WreathItemColorProvider.initiialize();
    }
}
