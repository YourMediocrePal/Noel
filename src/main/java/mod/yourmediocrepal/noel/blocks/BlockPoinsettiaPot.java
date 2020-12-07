package mod.yourmediocrepal.noel.blocks;


import mod.yourmediocrepal.noel.init.NoelBlocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;

public class BlockPoinsettiaPot extends FlowerPotBlock {

    public BlockPoinsettiaPot() {
        super(NoelBlocks.POINSETTIA.get(), Properties.create(Material.PLANTS)
            .zeroHardnessAndResistance()
            .sound(SoundType.PLANT)
        );
    }
}
