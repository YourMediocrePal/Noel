package mod.yourmediocrepal.noel.block;

import mod.yourmediocrepal.noel.block.entity.DonationBoothBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class BlockDonationBooth extends Block implements BlockEntityProvider {

    protected static final VoxelShape SHAPE;

    public BlockDonationBooth(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DonationBoothBlockEntity(pos, state);
    }

    static {
        SHAPE = VoxelShapes.union(Block.createCuboidShape(7.4, 0, 0, 8.6, 16, 1), Block.createCuboidShape(0, 0, 7.3, 1.1, 16, 8.7),
                Block.createCuboidShape(14.9, 0, 7.4, 16, 16, 8.6), Block.createCuboidShape(7.4, 0, 14.9, 8.6, 16, 16),
                Block.createCuboidShape(7.4, 15, 0, 8.6, 16, 16), Block.createCuboidShape(0, 14.9, 7.4, 16, 16, 8.6),
                Block.createCuboidShape(4.9, 3.9, 4.9, 11.1, 10.1, 11.1), Block.createCuboidShape(7.4, 4.9, 7.4, 8.6, 15, 8.6));
    }
}
