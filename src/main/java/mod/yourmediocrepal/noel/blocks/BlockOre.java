package mod.yourmediocrepal.noel.blocks;


import mod.yourmediocrepal.noel.init.NoelBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockOre extends Block {
    public BlockOre() {
        super(Properties.create(Material.ROCK)
            .hardnessAndResistance(5.0f,6.0f)
            .sound(SoundType.STONE)
            .setRequiresTool()
        );
    }

    protected int getExperience(Random rand) {
        if (this == Blocks.COAL_ORE) {
            return MathHelper.nextInt(rand, 0, 2);
        } else {
            return this == NoelBlocks.SPIRIT_ORE.get() ? MathHelper.nextInt(rand, 2, 5) : 0;
        }
    }

    /**
     * Perform side-effects from block dropping, such as creating silverfish
     */
    public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.getExperience(RANDOM) : 0;
    }
}
