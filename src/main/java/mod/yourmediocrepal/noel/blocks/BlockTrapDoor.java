package mod.yourmediocrepal.noel.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class BlockTrapDoor extends TrapDoorBlock {
     public BlockTrapDoor() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0f,2.0f)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE).setRequiresTool()
                .notSolid()
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(OPEN, Boolean.valueOf(false)).with(HALF, Half.BOTTOM).with(POWERED, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.valueOf(false)));
    }

}
