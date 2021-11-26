package mod.yourmediocrepal.noel.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BlockPresent extends Block {

    public static final BooleanProperty TRAP = BooleanProperty.of("trap");

    public BlockPresent(Settings settings, boolean isTrap) {
        super(settings);
        if(isTrap) setDefaultState(getStateManager().getDefaultState().with(TRAP, true));
        else setDefaultState(getStateManager().getDefaultState().with(TRAP, false));

    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(3.5D, 0D, 3.5D, 12.5D, 7.5D, 12.5D);
    }

    public static BooleanProperty getTrapProperty() {
        return TRAP;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(TRAP);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(world.getBlockState(pos).get(TRAP) == true) {
            primeTnt(world, pos, player);
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }

    private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (!world.isClient) {
            TntEntity tntEntity = new TntEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, igniter);
            world.spawnEntity(tntEntity);
            world.playSound((PlayerEntity)null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if(world.getBlockState(pos).get(TRAP) == true) {
            if (itemStack.isOf(Items.SHEARS)) {
                world.playSound((PlayerEntity) null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 2.0F);
                world.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY() + 0.5, pos.getZ(), 0.0D, 0.0D, 0.0D);
                world.setBlockState(pos, state.with(TRAP, false));

                if (!player.isCreative()) {
                    if (itemStack.isOf(Items.SHEARS)) {
                        itemStack.damage(1, player, (playerx) -> {
                            playerx.sendToolBreakStatus(hand);
                        });
                    } else {
                        itemStack.decrement(1);
                    }
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
