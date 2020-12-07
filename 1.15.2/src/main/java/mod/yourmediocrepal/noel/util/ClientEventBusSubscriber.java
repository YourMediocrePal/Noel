package mod.yourmediocrepal.noel.util;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.client.render.ElfRenderer;
import mod.yourmediocrepal.noel.init.NoelEntityTypes;
import mod.yourmediocrepal.noel.items.ItemSpawnEgg;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Noel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(NoelEntityTypes.ELF.get(), ElfRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ItemSpawnEgg.initSpawnEggs();
    }
}
