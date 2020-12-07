package mod.yourmediocrepal.noel.events;

import mod.yourmediocrepal.noel.capabilities.AdventCapability;
import mod.yourmediocrepal.noel.capabilities.IAdventCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoelEventHandler {

    /*@SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        PlayerEntity player = event.getPlayer();
        IAdventCapability day = (IAdventCapability) player.getCapability(AdventCapability.ADVENT_CAPABILITY);
        IAdventCapability oldDay = (IAdventCapability)  event.getOriginal().getCapability(AdventCapability.ADVENT_CAPABILITY);

        day.set(oldDay.getLastLogin());
    }*/


}
