package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;

public class BlockStairs extends StairsBlock {

    public BlockStairs() {
        super(Blocks.OAK_PLANKS.getDefaultState(), Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0f,3.0f)
                .sound(SoundType.WOOD)
        );

    }
}
