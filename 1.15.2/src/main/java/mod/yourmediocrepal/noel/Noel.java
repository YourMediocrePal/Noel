package mod.yourmediocrepal.noel;

import mod.yourmediocrepal.noel.entities.ElfEntity;
import mod.yourmediocrepal.noel.init.NoelBlocks;
import mod.yourmediocrepal.noel.init.NoelEntityTypes;
import mod.yourmediocrepal.noel.init.NoelItems;
import mod.yourmediocrepal.noel.items.ItemSpawnEgg;
import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Mod(Noel.MOD_ID)
public class Noel {

    public static final String MOD_ID = "noel";
    private static final Logger LOGGER = LogManager.getLogger();

    public Noel() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.debug("Hello from Noel!");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        NoelBlocks.init();
        NoelItems.init();
        NoelEntityTypes.ENTITY_TYPES.register(modEventBus);
        NoelTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    }


    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderType solid = RenderType.getSolid();
        RenderType cutout_mipped = RenderType.getCutoutMipped();
        RenderType cutout = RenderType.getCutout();
        RenderType translucent = RenderType.getTranslucent();
        RenderType translucent_no_crumbling = RenderType.getTranslucentNoCrumbling();

        RenderTypeLookup.setRenderLayer(NoelBlocks.YELLOW_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.WHITE_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.LIGHT_GRAY_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.RED_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.PURPLE_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.PINK_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.ORANGE_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.MAGENTA_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.LIME_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.LIGHT_BLUE_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.BLUE_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.GREEN_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.GRAY_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.CYAN_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.BROWN_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.BLACK_ORNAMENT.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.GLASS_ORNAMENT.get(), translucent);

        RenderTypeLookup.setRenderLayer(NoelBlocks.PEPPERMINT_TRAPDOOR.get(), cutout);
        RenderTypeLookup.setRenderLayer(NoelBlocks.PEPPERMINT_DOOR.get(), cutout);
        RenderTypeLookup.setRenderLayer(NoelBlocks.FROSTED_TRAPDOOR.get(), cutout);
        RenderTypeLookup.setRenderLayer(NoelBlocks.FROSTED_DOOR.get(), cutout);
        RenderTypeLookup.setRenderLayer(NoelBlocks.SHRUB_TREE.get(), translucent);
        RenderTypeLookup.setRenderLayer(NoelBlocks.WREATH.get(), cutout);
    }

    public static final ItemGroup TAB = new ItemGroup("noelTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(NoelItems.CANDY_CANE.get());
        }
    };

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ItemSpawnEgg.initSpawnEggs();
    }

}


