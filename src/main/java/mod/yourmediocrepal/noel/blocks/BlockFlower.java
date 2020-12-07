package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;

public class BlockFlower extends FlowerBlock {

    public BlockFlower() {
        super(Effects.NAUSEA, 7, Properties.create(Material.PLANTS)
            .zeroHardnessAndResistance()
            .sound(SoundType.PLANT)
            .doesNotBlockMovement()
            .notSolid()
        );
    }
}
