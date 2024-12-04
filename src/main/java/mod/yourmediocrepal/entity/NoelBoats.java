package mod.yourmediocrepal.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.init.NoelBlocks;
import mod.yourmediocrepal.init.NoelItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class NoelBoats {

    public final static Identifier FROSTED_BOAT_ID = Identifier.of(Noel.MOD_ID, "frosted_boat");
    public final static Identifier FROSTED_CHEST_BOAT_ID = Identifier.of(Noel.MOD_ID, "frosted_chest_boat");

    public static final RegistryKey<TerraformBoatType> FROSTED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(FROSTED_BOAT_ID);

    public static void registerBoats() {

        TerraformBoatType frostedBoat = new TerraformBoatType.Builder()
                .item(NoelItems.FROSTED_BOAT)
                .chestItem(NoelItems.FROSTED_CHEST_BOAT)
                .planks(NoelBlocks.FROSTED_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, FROSTED_BOAT_KEY, frostedBoat);
    }
}
