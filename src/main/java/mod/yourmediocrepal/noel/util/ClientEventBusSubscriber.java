package mod.yourmediocrepal.noel.util;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.client.render.ElfRenderer;
import mod.yourmediocrepal.noel.client.render.GingerBreadRenderer;
import mod.yourmediocrepal.noel.client.render.SugarPlumFairyRenderer;
import mod.yourmediocrepal.noel.init.NoelEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Noel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(NoelEntityTypes.ELF.get(), ElfRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(NoelEntityTypes.SUGAR_PLUM_FAIRY.get(), SugarPlumFairyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(NoelEntityTypes.GINGER_BREAD_MAN.get(), GingerBreadRenderer::new);
    }

}
