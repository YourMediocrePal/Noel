package mod.yourmediocrepal.noel.world.gen;

import com.google.common.collect.ImmutableList;
import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.init.NoelBlocks;
import mod.yourmediocrepal.noel.init.NoelEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NoelFeatures {

 @SubscribeEvent
    public static void init(RegistryEvent.Register<Feature<?>> event)
    {
    }

    public static void addFeatures(BiomeLoadingEvent event)
    {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        MobSpawnInfoBuilder spawns = event.getSpawns();

        if (event.getCategory() == Biome.Category.ICY)
        {
            spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(NoelEntityTypes.ELF.get(), 2, 2, 4));

            builder.withFeature(GenerationStage.Decoration.RAW_GENERATION, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), NoelBlocks.SPIRIT_ORE.get().getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

        }
        if (event.getCategory() == Biome.Category.PLAINS || event.getCategory() == Biome.Category.EXTREME_HILLS || event.getCategory() == Biome.Category.FOREST)
        {

            builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(new BlockClusterFeatureConfig.Builder(
                    new SimpleBlockStateProvider(NoelBlocks.POINSETTIA.get().getDefaultState()),
                    SimpleBlockPlacer.PLACER
            ).tries(32).build())
                    .withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                    .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                    .func_242731_b(1));

        }

    }

}
