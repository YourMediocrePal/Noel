package mod.yourmediocrepal.noel;

import mod.yourmediocrepal.noel.registry.BlockRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NoelClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRegistry.blockRender();

    }
}
