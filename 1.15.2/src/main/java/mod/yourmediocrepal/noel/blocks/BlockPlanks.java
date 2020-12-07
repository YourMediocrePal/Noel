package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockPlanks extends Block {
    public BlockPlanks() {
        super(Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f,3.0f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
        );
    }
}
