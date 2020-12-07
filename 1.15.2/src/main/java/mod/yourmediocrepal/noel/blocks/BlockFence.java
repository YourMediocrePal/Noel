package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockFence extends FenceBlock {
    public BlockFence() {
        super(Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(2.0f,3.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
        );
    }
}
