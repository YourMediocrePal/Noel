package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockButton extends WoodButtonBlock {
    public BlockButton() {
        super(Properties.create(Material.WOOD)
            .hardnessAndResistance(0.5f)
            .sound(SoundType.WOOD)
            .harvestTool(ToolType.AXE)
        );
    }
}
