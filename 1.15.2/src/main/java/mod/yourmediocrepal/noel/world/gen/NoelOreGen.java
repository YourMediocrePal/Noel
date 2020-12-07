package mod.yourmediocrepal.noel.world.gen;

import mod.yourmediocrepal.noel.init.NoelBlocks;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.block.BlockState;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "noel", bus = Mod.EventBusSubscriber.Bus.MOD)
public class NoelOreGen
{
    @SubscribeEvent
    public static void generateOres(final FMLLoadCompleteEvent event) {
        for (final Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER) {
                continue;
            }
            if (biome.getCategory() == Biome.Category.THEEND) {
                continue;
            }
            genOre(biome, 15, 8, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ((Block) NoelBlocks.SPIRIT_ORE.get()).getDefaultState(), 6);
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}