package mod.yourmediocrepal;

import mod.yourmediocrepal.block.WreathBlockColorProvider;
import mod.yourmediocrepal.entity.NoelBoats;
import mod.yourmediocrepal.entity.NoelEntities;
import mod.yourmediocrepal.entity.custom.GingerBreadEntity;
import mod.yourmediocrepal.entity.custom.SantaEntity;
import mod.yourmediocrepal.entity.custom.SugarPlumFairyEntity;
import mod.yourmediocrepal.event.NoelEffects;
import mod.yourmediocrepal.init.*;
import mod.yourmediocrepal.world.FeatureInjector;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Noel implements ModInitializer {
	public static final String MOD_ID = "noel";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		NoelItems.initialize();
		NoelBlocks.initialize();
		NoelArmorMaterials.initialize();
		NoelBlockEntityTypes.initialize();
		NoelSounds.initiialize();
		FeatureInjector.initiialize();
		NoelBoats.registerBoats();


		LOGGER.info("Hello From Noel!");

		FabricDefaultAttributeRegistry.register(NoelEntities.SANTA, SantaEntity.createSantaAttributes());
		FabricDefaultAttributeRegistry.register(NoelEntities.SUGAR_PLUM_FAIRY, SugarPlumFairyEntity.createSugarPlumFairyAttributes());
		FabricDefaultAttributeRegistry.register(NoelEntities.GINGER_BREAD, GingerBreadEntity.createGingerAttributes());

		EntitySleepEvents.START_SLEEPING.register((entity, sleepingPos) -> {
			BlockPos pos = entity.getBlockPos();
			World world = entity.getWorld();
			SantaEntity santa = NoelEntities.SANTA.create(world);

			if(entity.hasStatusEffect(NoelEffects.FESTIVE)) {
				santa.refreshPositionAndAngles(pos.getX(), pos.getY() + 0.5, pos.getZ(), 0f, 0f);
				world.spawnEntity(santa);
				world.playSound(pos.getX(), pos.getY(), pos.getZ(), NoelSounds.JINGLE_BELLS, SoundCategory.NEUTRAL, 1.0f, 0.0f, false);
				entity.removeStatusEffect(NoelEffects.FESTIVE);
				world.playSound((PlayerEntity) entity, pos, NoelSounds.JINGLE_BELLS, SoundCategory.NEUTRAL);
			}

		});

	}

}