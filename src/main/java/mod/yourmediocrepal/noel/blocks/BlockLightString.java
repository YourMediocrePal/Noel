package mod.yourmediocrepal.noel.blocks;


import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BlockLightString extends Block {

    public static final BooleanProperty UP = SixWayBlock.UP;
    public static final BooleanProperty NORTH = SixWayBlock.NORTH;
    public static final BooleanProperty EAST = SixWayBlock.EAST;
    public static final BooleanProperty SOUTH = SixWayBlock.SOUTH;
    public static final BooleanProperty WEST = SixWayBlock.WEST;
    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = SixWayBlock.FACING_TO_PROPERTY_MAP.entrySet().stream().filter((facingProperty) -> {
        return facingProperty.getKey() != Direction.DOWN;
    }).collect(Util.toMapCollector());
    private static final VoxelShape UP_AABB = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_AABB = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
    private final Map<BlockState, VoxelShape> stateToShapeMap;


    public BlockLightString() {
        super(Properties.create(Material.MISCELLANEOUS)
                .hardnessAndResistance(2.0f,3.0f)
                .sound(SoundType.GLASS));
        this.setDefaultState(this.stateContainer.getBaseState().with(UP, Boolean.valueOf(false)).with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)));
        this.stateToShapeMap = ImmutableMap.copyOf(this.stateContainer.getValidStates().stream().collect(Collectors.toMap(Function.identity(), BlockLightString::getShapeForState)));
    }

    private static VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelshape = VoxelShapes.empty();
        if (state.get(UP)) {
            voxelshape = UP_AABB;
        }

        if (state.get(NORTH)) {
            voxelshape = VoxelShapes.or(voxelshape, SOUTH_AABB);
        }

        if (state.get(SOUTH)) {
            voxelshape = VoxelShapes.or(voxelshape, NORTH_AABB);
        }

        if (state.get(EAST)) {
            voxelshape = VoxelShapes.or(voxelshape, WEST_AABB);
        }

        if (state.get(WEST)) {
            voxelshape = VoxelShapes.or(voxelshape, EAST_AABB);
        }

        return voxelshape;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.stateToShapeMap.get(state);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return this.getBlocksAttachedTo(this.func_196545_h(state, worldIn, pos));
    }

    private boolean getBlocksAttachedTo(BlockState state) {
        return this.countBlocksVineIsAttachedTo(state) > 0;
    }

    private int countBlocksVineIsAttachedTo(BlockState state) {
        int i = 0;

        for(BooleanProperty booleanproperty : FACING_TO_PROPERTY_MAP.values()) {
            if (state.get(booleanproperty)) {
                ++i;
            }
        }

        return i;
    }

    private boolean hasAttachment(IBlockReader blockReader, BlockPos pos, Direction direction) {
        if (direction == Direction.DOWN) {
            return false;
        } else {
            BlockPos blockpos = pos.offset(direction);
            if (canAttachTo(blockReader, blockpos, direction)) {
                return true;
            } else if (direction.getAxis() == Direction.Axis.Y) {
                return false;
            } else {
                BooleanProperty booleanproperty = FACING_TO_PROPERTY_MAP.get(direction);
                BlockState blockstate = blockReader.getBlockState(pos.up());
                return blockstate.isIn(this) && blockstate.get(booleanproperty);
            }
        }
    }

    public static boolean canAttachTo(IBlockReader blockReader, BlockPos worldIn, Direction neighborPos) {
        BlockState blockstate = blockReader.getBlockState(worldIn);
        return Block.doesSideFillSquare(blockstate.getCollisionShape(blockReader, worldIn), neighborPos.getOpposite());
    }

    private BlockState func_196545_h(BlockState state, IBlockReader blockReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        if (state.get(UP)) {
            state = state.with(UP, Boolean.valueOf(canAttachTo(blockReader, blockpos, Direction.DOWN)));
        }

        BlockState blockstate = null;

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BooleanProperty booleanproperty = getPropertyFor(direction);
            if (state.get(booleanproperty)) {
                boolean flag = this.hasAttachment(blockReader, pos, direction);
                if (!flag) {
                    if (blockstate == null) {
                        blockstate = blockReader.getBlockState(blockpos);
                    }

                    flag = blockstate.isIn(this) && blockstate.get(booleanproperty);
                }

                state = state.with(booleanproperty, Boolean.valueOf(flag));
            }
        }

        return state;
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.DOWN) {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            BlockState blockstate = this.func_196545_h(stateIn, worldIn, currentPos);
            return !this.getBlocksAttachedTo(blockstate) ? Blocks.AIR.getDefaultState() : blockstate;
        }
    }


    private BlockState func_196544_a(BlockState state, BlockState state2, Random rand) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (rand.nextBoolean()) {
                BooleanProperty booleanproperty = getPropertyFor(direction);
                if (state.get(booleanproperty)) {
                    state2 = state2.with(booleanproperty, Boolean.valueOf(true));
                }
            }
        }

        return state2;
    }

    private boolean isFacingCardinal(BlockState state) {
        return state.get(NORTH) || state.get(EAST) || state.get(SOUTH) || state.get(WEST);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());
        boolean flag = blockstate.isIn(this);
        BlockState blockstate1 = flag ? blockstate : this.getDefaultState();

        for(Direction direction : context.getNearestLookingDirections()) {
            if (direction != Direction.DOWN) {
                BooleanProperty booleanproperty = getPropertyFor(direction);
                boolean flag1 = flag && blockstate.get(booleanproperty);
                if (!flag1 && this.hasAttachment(context.getWorld(), context.getPos(), direction)) {
                    return blockstate1.with(booleanproperty, Boolean.valueOf(true));
                }
            }
        }

        return flag ? blockstate1 : null;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, SOUTH, WEST);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        switch(rot) {
            case CLOCKWISE_180:
                return state.with(NORTH, state.get(SOUTH)).with(EAST, state.get(WEST)).with(SOUTH, state.get(NORTH)).with(WEST, state.get(EAST));
            case COUNTERCLOCKWISE_90:
                return state.with(NORTH, state.get(EAST)).with(EAST, state.get(SOUTH)).with(SOUTH, state.get(WEST)).with(WEST, state.get(NORTH));
            case CLOCKWISE_90:
                return state.with(NORTH, state.get(WEST)).with(EAST, state.get(NORTH)).with(SOUTH, state.get(EAST)).with(WEST, state.get(SOUTH));
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        switch(mirrorIn) {
            case LEFT_RIGHT:
                return state.with(NORTH, state.get(SOUTH)).with(SOUTH, state.get(NORTH));
            case FRONT_BACK:
                return state.with(EAST, state.get(WEST)).with(WEST, state.get(EAST));
            default:
                return super.mirror(state, mirrorIn);
        }
    }

    public static BooleanProperty getPropertyFor(Direction side) {
        return FACING_TO_PROPERTY_MAP.get(side);
    }

 }
