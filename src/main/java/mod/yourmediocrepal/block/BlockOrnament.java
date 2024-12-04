package mod.yourmediocrepal.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BlockOrnament extends WallMountedBlock {
    public static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 6.0, 11.0, 11.0);
    public static final VoxelShape WEST_SHAPE = Block.createCuboidShape(10.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    public static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 6.0);
    public static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 10.0, 11.0, 11.0, 16.0);
    public static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    public static final VoxelShape UP_SHAPE = Block.createCuboidShape(5.0, 9.0, 5.0, 11.0, 15.0, 11.0);

    public BlockOrnament(Settings settings) {
        super(settings.nonOpaque().notSolid().sounds(BlockSoundGroup.GLASS));
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FACE, BlockFace.WALL));
    }

    @Override
    protected MapCodec<? extends WallMountedBlock> getCodec() {
        return null;
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
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
        switch ((BlockFace)state.get(FACE)) {
            case FLOOR:
                return DOWN_SHAPE;
            case WALL:
                switch (direction) {
                    case EAST:
                        return EAST_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case NORTH:
                    case UP:
                    case DOWN:
                        return NORTH_SHAPE;
                    default:
                        throw new IncompatibleClassChangeError();
                }
            case CEILING:
            default:
                return UP_SHAPE;
        }
    }


    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = getDirection(state).getOpposite();
        BlockPos neighborPos = pos.offset(direction);
        BlockState neighborState = world.getBlockState(neighborPos);

        return neighborState.isSideSolidFullSquare(world, neighborPos, direction) || neighborState.isIn(BlockTags.LEAVES);

    }


}
