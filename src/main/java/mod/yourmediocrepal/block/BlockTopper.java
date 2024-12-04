package mod.yourmediocrepal.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class BlockTopper extends Block {
    public BlockTopper(Settings settings) {
        super(settings.nonOpaque().breakInstantly().luminance((state) ->  {return 4;}));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BlockSlab.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
    }
}