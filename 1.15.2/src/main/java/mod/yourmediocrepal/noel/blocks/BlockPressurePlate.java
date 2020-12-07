package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockPressurePlate extends PressurePlateBlock {
    public BlockPressurePlate() {
        super(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.create(Material.WOOD)
            .hardnessAndResistance(0.5f)
            .sound(SoundType.WOOD)
            .doesNotBlockMovement()
            .harvestTool(ToolType.AXE)
        );
    }
}
