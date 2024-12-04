package mod.yourmediocrepal.block.entity;

import mod.yourmediocrepal.init.NoelBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AdventCalendarBlockEntity extends BlockEntity {
    public AdventCalendarBlockEntity(BlockPos pos, BlockState state) {
        super(NoelBlockEntityTypes.ADVENT_CALENDAR_BLOCK, pos, state);
    }

    public void tellDaysUntilChristmas(PlayerEntity player) {
        LocalDate today = LocalDate.now();
        LocalDate christmas = LocalDate.of(today.getYear(), 12, 25);
        long daysUntilChristmas = ChronoUnit.DAYS.between(today, christmas);

        player.sendMessage(Text.of("There are " + daysUntilChristmas + " days left until Christmas!"), false);
    }

}
