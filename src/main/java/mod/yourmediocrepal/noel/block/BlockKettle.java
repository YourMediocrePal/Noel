package mod.yourmediocrepal.noel.block;

import mod.yourmediocrepal.noel.NoelMod;
import mod.yourmediocrepal.noel.block.entity.KettleBlockEntity;
import mod.yourmediocrepal.noel.registry.ItemRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class BlockKettle extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING;

    public BlockKettle(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 8.5D, 12.5D);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new KettleBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, NoelMod.KETTLE_BLOCK_ENTITY, (world1, pos, state1, be) -> KettleBlockEntity.tick(world1, pos, state1, be));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockInventory = (Inventory) world.getBlockEntity(blockPos);
        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        ItemStack itemStack = player.getStackInHand(hand);

        if(!world.isClient) {

            if (!itemStack.isEmpty()) {
                if (blockInventory.getStack(0).isEmpty() && itemStack.isOf(Items.COCOA_BEANS)) {
                    blockInventory.setStack(0, new ItemStack(Items.COCOA_BEANS, 1));
                    player.getStackInHand(hand).decrement(1);

                } else if (blockInventory.getStack(1).isEmpty() && itemStack.isOf(Items.MILK_BUCKET)) {
                    blockInventory.setStack(1, new ItemStack(Items.MILK_BUCKET, 1));
                    player.setStackInHand(hand, new ItemStack(Items.BUCKET));

                } else if (blockInventory.getStack(2).isEmpty() && itemStack.isOf(ItemRegistry.MUG)) {
                    blockInventory.setStack(2, new ItemStack(ItemRegistry.MUG));
                    player.getStackInHand(hand).decrement(1);

                } else {
                    System.out.println(blockInventory.getStack(0) + "" + blockInventory.getStack(1) + "" + blockInventory.getStack(2) + "" + blockInventory.getStack(3));
                }

            } else {
                if (!blockInventory.getStack(3).isEmpty()) {
                    player.getInventory().offerOrDrop(blockInventory.getStack(3));
                    blockInventory.removeStack(3);

                }
                if (blockInventory.getStack(1).isOf(Items.BUCKET)) {
                    player.getInventory().offerOrDrop(blockInventory.getStack(1));
                    blockInventory.removeStack(1);

                }

            }
        }
        return ActionResult.SUCCESS;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
    }
}
