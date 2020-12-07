package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockStairs extends StairsBlock {

    public BlockStairs(BlockState state) {
        super(state, Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0f,3.0f)
                .sound(SoundType.WOOD).harvestTool(ToolType.AXE).setRequiresTool()
        );

    }
}
