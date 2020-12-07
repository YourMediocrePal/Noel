package mod.yourmediocrepal.noel.blocks;


import mod.yourmediocrepal.noel.tileentity.AdventCalendarTileEntity;
import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockAdventCalendar extends Block implements IWaterLoggable {

    protected static final VoxelShape CALENDAR_EAST_AABB = Block.makeCuboidShape(0.0D, 1.0D, 1.0D, 1.0D, 15.0D, 15.0D);
    protected static final VoxelShape CALENDAR_WEST_AABB = Block.makeCuboidShape(15.0D, 1.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape CALENDAR_SOUTH_AABB = Block.makeCuboidShape(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 1.0D);
    protected static final VoxelShape CALENDAR_NORTH_AABB = Block.makeCuboidShape(1.0D, 1.0D, 15.0D, 15.0D, 15.0D, 16.0D);

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockAdventCalendar() {
        super(Properties.create(Material.MISCELLANEOUS)
                .hardnessAndResistance(0.2f,0.2f)
                .sound(SoundType.CLOTH)
                .harvestLevel(0)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IWorld iworld = context.getWorld();
        BlockPos blockpos = context.getPos();
        boolean flag = iworld.getFluidState(blockpos).getFluid() == Fluids.WATER;
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, Boolean.valueOf(flag));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return CALENDAR_NORTH_AABB;
            case SOUTH:
                return CALENDAR_SOUTH_AABB;
            case WEST:
                return CALENDAR_WEST_AABB;
            default:
                return CALENDAR_EAST_AABB;
        }
    }

    private boolean canAttachTo(IBlockReader p_196471_1_, BlockPos p_196471_2_, Direction p_196471_3_) {
        BlockState blockstate = p_196471_1_.getBlockState(p_196471_2_);
        return !blockstate.canProvidePower() && blockstate.isSolidSide(p_196471_1_, p_196471_2_, p_196471_3_);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        return this.canAttachTo(worldIn, pos.offset(direction.getOpposite()), direction);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }
    /**Change the block shadow -- Lower return values = more shadow*/
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return NoelTileEntityTypes.ADVENT_CALENDAR.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity advent = worldIn.getTileEntity(pos);
            if (advent instanceof AdventCalendarTileEntity) {
                ((AdventCalendarTileEntity) advent).reportDate(player);
            }
        }
        return ActionResultType.SUCCESS;
    }
}
