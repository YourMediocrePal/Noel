package mod.yourmediocrepal.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BlockStocking extends WallMountedBlock {

    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 0.5, 1.5, 1.0, 16.0, 15.0);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15.0, 0.5, 1.5, 16.0, 16.0, 15.0);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(1.5, 0.5, 0.0, 15.0, 16.0, 1.0);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(1.5, 0.5, 15.0, 15.0, 16.0, 16.0);
    public BlockStocking(Settings settings) {
        super(settings.strength(0.1f).sounds(BlockSoundGroup.WOOL));
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends WallMountedBlock> getCodec() {
        return null;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, FACE});
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    //button
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = (Direction)state.get(FACING);
        switch (direction) {
            case EAST:
                return EAST_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case NORTH:
                return NORTH_SHAPE;
            default:
                throw new IncompatibleClassChangeError();
        }
    }


    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.offset(((Direction)state.get(FACING)).getOpposite())).isSolid();
    }
}
