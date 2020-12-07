package mod.yourmediocrepal.noel.events;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.capabilities.AdventCapability;
import mod.yourmediocrepal.noel.capabilities.IAdventCapability;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import mod.yourmediocrepal.noel.entities.SugarPlumFairyEntity;
import mod.yourmediocrepal.noel.init.NoelEntityTypes;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Noel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NoelEventHandler {

    private static boolean flag;

    @SubscribeEvent
    public static void onPlayerSleepInBed(SleepFinishedTimeEvent event)
    {
        Noel.LOGGER.info("Players have slept" + event.getResult());
        IWorld worldIn = event.getWorld();
        flag = true;

    }

    @SubscribeEvent
    public static void onPlayerWake(PlayerWakeUpEvent event)
    {
        PlayerEntity player = event.getPlayer();
        World worldIn = player.getEntityWorld();
        double x = player.getPosX(); double y = player.getPosY(); double z = player.getPosZ();

        Noel.LOGGER.info("Players have woken");

        if(flag) {
            if(player.getPersistentData().getBoolean("WarmMilk")) {
                Noel.LOGGER.info("Attempting summoning sugar plum fairy...");
                int random = new Random().nextInt(1);
                if (random == 0) {
                    Noel.LOGGER.info("Summoning fairy...");
                    SugarPlumFairyEntity fairy = NoelEntityTypes.SUGAR_PLUM_FAIRY.get().create(worldIn);
                    fairy.setLocationAndAngles(x + 0.5D, y + 1.0D, z + 0.5D, 0.0F, 0.0F);
                    worldIn.addEntity(fairy);
                } else Noel.LOGGER.info("Fairy did not summon, random number was " + random);
                flag = false;
            }
            player.getPersistentData().putBoolean("WarmMilk", false);
            Noel.LOGGER.info("Reset player drank warm milk.");
        }
    }

}
