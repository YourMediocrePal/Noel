package mod.yourmediocrepal.noel;

import mod.yourmediocrepal.noel.block.entity.DonationBoothBlockEntity;
import mod.yourmediocrepal.noel.block.entity.KettleBlockEntity;
import mod.yourmediocrepal.noel.registry.BlockRegistry;
import mod.yourmediocrepal.noel.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoelMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("noel");

	public static final Tag<Block> ORNAMENT_ATTACH = TagFactory.BLOCK.create(new Identifier("noel", "ornament_attach"));

	public static final BlockEntityType<KettleBlockEntity> KETTLE_BLOCK_ENTITY;
	public static final BlockEntityType<DonationBoothBlockEntity> DONATION_BOOTH_BLOCK_ENTITY;

	static {
		KETTLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("noel", "kettle"), FabricBlockEntityTypeBuilder.create(KettleBlockEntity::new, BlockRegistry.KETTLE).build(null));
		DONATION_BOOTH_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("noel", "donation_booth"), FabricBlockEntityTypeBuilder.create(DonationBoothBlockEntity::new, BlockRegistry.BLACK_DONATION_BOOTH).build(null));
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		BlockRegistry.init();
		ItemRegistry.init();

	}
}
