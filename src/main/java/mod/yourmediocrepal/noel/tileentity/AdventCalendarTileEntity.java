package mod.yourmediocrepal.noel.tileentity;

import mod.yourmediocrepal.noel.capabilities.AdventCapability;
import mod.yourmediocrepal.noel.capabilities.IAdventCapability;
import mod.yourmediocrepal.noel.init.NoelBlocks;
import mod.yourmediocrepal.noel.init.NoelItems;
import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;

import java.time.LocalDateTime;
import java.time.Month;

public class AdventCalendarTileEntity extends TileEntity {
    public AdventCalendarTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public AdventCalendarTileEntity() {
        this(NoelTileEntityTypes.ADVENT_CALENDAR.get());
    }

    public static void reportDate(PlayerEntity player) {
        LocalDateTime now = LocalDateTime.now();
        int count = 0;
        if (now.getMonth() == Month.DECEMBER) {
            if (now.getDayOfMonth() < 25) {
                String message;
                if (now.getDayOfMonth() > 3)
                    message = "Today is the " + now.getDayOfMonth() + "th of December. Only " + (25 - now.getDayOfMonth()) + " days left until Christmas!";
                else
                    message = "Today is the " + now.getDayOfMonth() + " of December. Only " + (25 - now.getDayOfMonth()) + " days left until Christmas!";
                player.sendStatusMessage(new StringTextComponent(message), true);
                count = 1;
            } else if (now.getDayOfMonth() == 25) {
                String message;
                message = "Today is Christmas! Merry Christmas!";
                player.sendStatusMessage(new StringTextComponent(message), true);
                count = 5;
            }
            if(player.getPersistentData().getInt("AdventUse") != now.getDayOfMonth())
                player.addItemStackToInventory(new ItemStack(NoelBlocks.PRESENT.get(), count));
            else player.sendStatusMessage(new StringTextComponent("You have already recieved a gift today!"), false);
            player.getPersistentData().putInt("AdventUse", now.getDayOfMonth());
            System.out.println("Last used advent day is = " + player.getPersistentData().getInt("AdventUse"));
        }else
        {
            String message = "The holidays have not begun! Wait until December.";
            player.sendStatusMessage(new StringTextComponent(message), true);
        }
    }
}
