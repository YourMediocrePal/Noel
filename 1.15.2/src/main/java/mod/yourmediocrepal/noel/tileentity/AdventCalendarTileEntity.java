package mod.yourmediocrepal.noel.tileentity;

import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.StringTextComponent;

import java.time.LocalDateTime;
import java.time.Month;

public class AdventCalendarTileEntity extends TileEntity
{
    public AdventCalendarTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public AdventCalendarTileEntity() {
        this(NoelTileEntityTypes.ADVENT_CALENDAR.get());
    }

    public static void reportDate(PlayerEntity player) {
        LocalDateTime now = LocalDateTime.now();
        if(now.getMonth() == Month.DECEMBER && now.getDayOfMonth() > 25) {
            String message;
            if(now.getDayOfMonth() > 3) message = "Today is the " + now.getDayOfMonth() + "th of December\nOnly " + (25 - now.getDayOfMonth()) + " days left until Christmas!" ;
            else message = "Today is the " + now.getDayOfMonth() + "of December\nOnly " + (25 - now.getDayOfMonth()) + " days left until Christmas!" ;
            player.sendStatusMessage(new StringTextComponent(message), true);
        }else {
            String message = "The holidays have not begun! Wait until December.";
            player.sendStatusMessage(new StringTextComponent(message), true);
        }
    }
}
