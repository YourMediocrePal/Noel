package mod.yourmediocrepal.noel.block;

import mod.yourmediocrepal.noel.NoelMod;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BlockMistletoe extends WallMountedBlock {
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape DOWN_SHAPE;
    protected static final VoxelShape UP_SHAPE;

    public BlockMistletoe(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FACE, WallMountLocation.WALL));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING, FACE);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction direction = (Direction)state.get(FACING);
        switch((WallMountLocation)state.get(FACE)) {
            case FLOOR:
                return DOWN_SHAPE;
            case WALL:
                switch(direction) {
                    case EAST:
                        return EAST_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return NORTH_SHAPE;
                }
            case CEILING:
            default:
                return UP_SHAPE;
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canPlaceAt(world, pos, getDirection(state).getOpposite());
    }

    public static boolean canPlaceAt(WorldView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction);
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction.getOpposite()) ||
                world.getBlockState(blockPos).isIn(NoelMod.ORNAMENT_ATTACH);
    }


    static {
        DOWN_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
        UP_SHAPE = Block.createCuboidShape(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D);
        NORTH_SHAPE = Block.createCuboidShape(3.0D, 3.0D, 8.0D, 13.0D, 13.0D, 16.0D);
        SOUTH_SHAPE = Block.createCuboidShape(3.0D, 3.0D, 0.0D, 13.0D, 13.0D, 8.0D);
        EAST_SHAPE = Block.createCuboidShape(0.0D, 3.0D, 3.0D, 8.0D, 13.0D, 13.0D);
        WEST_SHAPE = Block.createCuboidShape(8.0D, 3.0D, 3.0D, 16.0D, 13.0D, 13.0D);
    }
}
