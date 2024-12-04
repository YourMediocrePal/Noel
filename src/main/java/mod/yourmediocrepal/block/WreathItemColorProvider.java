package mod.yourmediocrepal.block;

import mod.yourmediocrepal.init.NoelBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.item.ItemStack;

public class WreathItemColorProvider implements ItemColorProvider {

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 0) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.world != null && client.player != null) {
                return BiomeColors.getFoliageColor(client.world, client.player.getBlockPos());
            }
        }
        return 0xFFFFFF;
    }

    public static void initiialize() {
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.OAK_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.SPRUCE_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.BIRCH_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.JUNGLE_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.DARK_OAK_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.ACACIA_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.AZALEA_WREATH.asItem());
        ColorProviderRegistry.ITEM.register(new WreathItemColorProvider(), NoelBlocks.MANGROVE_WREATH.asItem());

    }

}
