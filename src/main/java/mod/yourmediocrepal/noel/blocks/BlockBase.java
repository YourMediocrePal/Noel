package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase() {
        super(Block.Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(2.0f,3.0f)
            .sound(SoundType.WOOD)
        );
    }
}
