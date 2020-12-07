package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;

public class BlockWall extends WallBlock {
    public BlockWall() {
        super(Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f,3.0f)
            .sound(SoundType.WOOD)
        );
    }
}
