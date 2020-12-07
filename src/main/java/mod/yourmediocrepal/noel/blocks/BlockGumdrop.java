package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockGumdrop extends HorizontalFaceBlock implements IWaterLoggable {

    protected static final VoxelShape FLOOR = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    protected static final VoxelShape CEILING = Block.makeCuboidShape(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    protected static final VoxelShape SHAPE_WALL_NORTH = Block.makeCuboidShape(3.0D, 3.0D, 8.0D, 13.0D, 13.0D, 16.0D);
    protected static final VoxelShape SHAPE_WALL_SOUTH = Block.makeCuboidShape(3.0D, 3.0D, 0.0D, 13.0D, 13.0D, 8.0D);
    protected static final VoxelShape SHAPE_WALL_EAST = Block.makeCuboidShape(0.0D, 3.0D, 3.0D, 8.0D, 13.0D, 13.0D);
    protected static final VoxelShape SHAPE_WALL_WEST = Block.makeCuboidShape(8.0D, 3.0D, 3.0D, 16.0D, 13.0D, 13.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockGumdrop() {
        super(Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(0.3f,0.3f)
            .sound(SoundType.SHROOMLIGHT)
            .notSolid()
        );

        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(FACE, AttachFace.WALL).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @OnlyIn(Dist.CLIENT)
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1.0F;
    }

    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private VoxelShape getShapeFromState(BlockState state) {
        Direction direction = state.get(HORIZONTAL_FACING);
        switch((AttachFace)state.get(FACE)) {
            case FLOOR:
                return FLOOR;
            case WALL:
                if (direction == Direction.NORTH) {
                    return SHAPE_WALL_NORTH;
                } else if (direction == Direction.SOUTH) {
                    return SHAPE_WALL_SOUTH;
                } else {
                    if (direction == Direction.EAST) {
                        return SHAPE_WALL_EAST;
                    }

                    return SHAPE_WALL_WEST;
                }
            case CEILING:
                return CEILING;
            default:
                return CEILING;
        }
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.getShapeFromState(state);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.getShapeFromState(state);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return true;
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }


    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, FACE, WATERLOGGED);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance * 0.5F);
    }

    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.onLanded(worldIn, entityIn);
        } else {
            this.bounceEntity(entityIn);
        }

    }

    private void bounceEntity(Entity entity) {
        Vector3d vector3d = entity.getMotion();
        if (vector3d.y < 0.0D) {
            double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setMotion(vector3d.x, -vector3d.y * (double)0.66F * d0, vector3d.z);
        }

    }
}


