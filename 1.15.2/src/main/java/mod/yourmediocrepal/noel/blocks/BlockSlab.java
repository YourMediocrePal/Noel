package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockSlab extends SlabBlock {
    public BlockSlab() {
        super(Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(5.0f,6.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
        );
    }
}
