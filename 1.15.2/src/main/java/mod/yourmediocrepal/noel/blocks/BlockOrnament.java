package mod.yourmediocrepal.noel.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.GrindstoneContainer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockOrnament extends HorizontalFaceBlock {

    protected static final VoxelShape FLOOR = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    protected static final VoxelShape CEILING = Block.makeCuboidShape(5.0D, 9.0D, 5.0D, 11.0D, 15.0D, 11.0D);
    protected static final VoxelShape SHAPE_WALL_NORTH = Block.makeCuboidShape(5.0D, 5.0D, 10.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape SHAPE_WALL_SOUTH = Block.makeCuboidShape(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 6.0D);
    protected static final VoxelShape SHAPE_WALL_EAST = Block.makeCuboidShape(0.0D, 5.0D, 5.0D, 6.0D, 11.0D, 11.0D);
    protected static final VoxelShape SHAPE_WALL_WEST = Block.makeCuboidShape(10.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);

    public BlockOrnament() {
        super(Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(0.3f,0.3f)
            .sound(SoundType.GLASS)
            .notSolid()
        );

        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
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

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, FACE);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
