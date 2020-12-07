package mod.yourmediocrepal.noel.blocks;


import mod.yourmediocrepal.noel.tileentity.DonationBoothTileEntity;
import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class BlockDonationBooth extends Block implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(7.5, 0, 0, 8.5, 16, 1), Block.makeCuboidShape(0, 0, 7.5, 1, 16, 8.5),
            Block.makeCuboidShape(15, 0, 7.5, 16, 16, 8.5), Block.makeCuboidShape(7.5, 0, 15, 8.5, 16, 16),
            Block.makeCuboidShape(7.5, 15, 0, 8.5, 16, 16), Block.makeCuboidShape(0, 15, 7.5, 16, 16, 8.5),
            Block.makeCuboidShape(5, 4, 5, 11, 10, 11), Block.makeCuboidShape(7.5, 5, 7.5, 8.5, 15, 8.5)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BlockDonationBooth() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.25f,6.0f)
                .sound(SoundType.METAL)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IWorld iworld = context.getWorld();
        BlockPos blockpos = context.getPos();
        boolean flag = iworld.getFluidState(blockpos).getFluid() == Fluids.WATER;
        return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(flag));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isViewBlocking(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if(!worldIn.isRemote) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof DonationBoothTileEntity) {
                ((DonationBoothTileEntity) tileentity).setPlayer(placer.getUniqueID());
            }
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof DonationBoothTileEntity) {
                if(!player.isSneaking()) {
                    if(((DonationBoothTileEntity) tileentity).canAddItem(player.getHeldItem(player.swingingHand).getItem()))
                    {
                        ((DonationBoothTileEntity) tileentity).addItem(player.getHeldItem(player.swingingHand).getItem(), player.getHeldItem(player.swingingHand).getCount());
                        player.getHeldItem(player.swingingHand).shrink(1);
                    }
                }
                else ((DonationBoothTileEntity) tileentity).removeItem(player.getUniqueID());
            }

            return ActionResultType.SUCCESS;
        }
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return NoelTileEntityTypes.DONATION_BOOTH.get().create();
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!worldIn.isRemote) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof DonationBoothTileEntity) {
                ((DonationBoothTileEntity) tileentity).destroyedBlock();
            }
        }
    }
}
