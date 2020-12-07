package mod.yourmediocrepal.noel.capabilities;

import com.google.common.base.Throwables;
import mod.yourmediocrepal.noel.Noel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.Callable;

public class AdventCapability {

    @CapabilityInject(IAdventCapability.class)
    static Capability<IAdventCapability> ADVENT_CAP = null;
    public static final ResourceLocation ID = new ResourceLocation(Noel.MOD_ID, "advent");


    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = Noel.MOD_ID)
    private static class EventHandler {

        @SubscribeEvent
        public static void attachCapabilities(final AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof PlayerEntity) {
                //event.addCapability(ID, createNewCapability((PlayerEntity) event.getObject()));
            }
        }

        @SubscribeEvent
        public static void playerClone(final PlayerEvent.Clone event) {

        }
    }
}

