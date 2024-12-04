package mod.yourmediocrepal.block;

import com.mojang.serialization.MapCodec;
import mod.yourmediocrepal.block.entity.AdventCalendarBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class BlockAdventCalendar extends BlockWithEntity {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<BlockFace> FACE = Properties.BLOCK_FACE;

    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0, 1.0, 1.0, 1.0, 15.0, 15.0);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15.0, 1.0, 1.0, 16.0, 15.0, 15.0);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(1.0, 1.0, 0.0, 15.0, 15.0, 1.0);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(1.0, 1.0, 15.0, 15.0, 15.0, 16.0);

    public BlockAdventCalendar(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FACE, BlockFace.WALL));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE);
    }


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
        }
        return NORTH_SHAPE;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction facing = state.get(FACING);
        BlockPos blockPos = pos.offset(facing.getOpposite());
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, facing);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AdventCalendarBlockEntity(pos, state);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction[] var2 = ctx.getPlacementDirections();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Direction direction = var2[var4];
            BlockState blockState;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockState = (BlockState)((BlockState)this.getDefaultState().with(FACE, direction == Direction.UP ? BlockFace.CEILING : BlockFace.FLOOR)).with(FACING, ctx.getHorizontalPlayerFacing());
            } else {
                blockState = (BlockState)((BlockState)this.getDefaultState().with(FACE, BlockFace.WALL)).with(FACING, direction.getOpposite());
            }

            if (blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                return blockState;
            }
        }

        return null;
    }

    protected static Direction getDirection(BlockState state) {
        switch ((BlockFace)state.get(FACE)) {
            case CEILING:
                return Direction.DOWN;
            case FLOOR:
                return Direction.UP;
            default:
                return (Direction)state.get(FACING);
        }
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AdventCalendarBlockEntity) {
                ((AdventCalendarBlockEntity) blockEntity).tellDaysUntilChristmas(player);
            }
        }
        return ActionResult.SUCCESS;
    }
}
