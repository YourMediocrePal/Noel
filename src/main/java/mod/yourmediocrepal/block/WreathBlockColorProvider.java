package mod.yourmediocrepal.block;

import mod.yourmediocrepal.init.NoelBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.biome.FoliageColors;

public class WreathBlockColorProvider implements BlockColorProvider {

    @Override
    public int getColor(BlockState state, BlockRenderView view, BlockPos pos, int tintIndex) {
        if (view != null && pos != null) {
            int biomeColor = BiomeColors.getFoliageColor(view, pos);

            if (state.isOf(NoelBlocks.SPRUCE_WREATH)) {
                return FoliageColors.getSpruceColor();
            }
            if (state.isOf(NoelBlocks.BIRCH_WREATH)) {
                return FoliageColors.getBirchColor();
            }
            if (state.isOf(NoelBlocks.MANGROVE_WREATH)) {
                return FoliageColors.getMangroveColor();
            }

            return biomeColor;
        }

        return 0xFFFFFF;
    }


    public static void initiialize() {
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.OAK_WREATH);
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.SPRUCE_WREATH);
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.BIRCH_WREATH);
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.JUNGLE_WREATH);
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.DARK_OAK_WREATH);
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.ACACIA_WREATH);
        ColorProviderRegistry.BLOCK.register(new WreathBlockColorProvider(), NoelBlocks.MANGROVE_WREATH);


    }
}
