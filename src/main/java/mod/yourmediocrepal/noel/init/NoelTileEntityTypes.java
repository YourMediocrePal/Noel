package mod.yourmediocrepal.noel.init;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.tileentity.AdventCalendarTileEntity;
import mod.yourmediocrepal.noel.tileentity.DonationBoothTileEntity;
import mod.yourmediocrepal.noel.tileentity.KettleTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NoelTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Noel.MOD_ID);

    public static final RegistryObject<TileEntityType<DonationBoothTileEntity>> DONATION_BOOTH = TILE_ENTITY_TYPES.register("donation_booth", () -> TileEntityType.Builder.create(DonationBoothTileEntity::new, NoelBlocks.DONATION_BOOTH.get()).build(null));
    public static final RegistryObject<TileEntityType<KettleTileEntity>> KETTLE = TILE_ENTITY_TYPES.register("kettle", () -> TileEntityType.Builder.create(KettleTileEntity::new, NoelBlocks.KETTLE.get()).build(null));
    public static final RegistryObject<TileEntityType<AdventCalendarTileEntity>> ADVENT_CALENDAR = TILE_ENTITY_TYPES.register("advent_calendar", () -> TileEntityType.Builder.create(AdventCalendarTileEntity::new, NoelBlocks.ADVENT_CALENDAR.get()).build(null));
}
