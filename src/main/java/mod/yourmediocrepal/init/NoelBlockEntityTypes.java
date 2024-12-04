package mod.yourmediocrepal.init;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.block.entity.AdventCalendarBlockEntity;
import mod.yourmediocrepal.block.entity.KettleBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class NoelBlockEntityTypes {

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Noel.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<KettleBlockEntity> KETTLE_BLOCK = register(
            "kettle_block",
            BlockEntityType.Builder.create(KettleBlockEntity::new, NoelBlocks.KETTLE).build()
    );

    public static final BlockEntityType<AdventCalendarBlockEntity> ADVENT_CALENDAR_BLOCK = register(
            "advent_calendar_block",
            BlockEntityType.Builder.create(AdventCalendarBlockEntity::new, NoelBlocks.ADVENT_CALENDAR).build()
    );

    public static void initialize() {
    }

}
