package mod.yourmediocrepal.noel.blocks;


import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.entities.ElfEntity;
import mod.yourmediocrepal.noel.entities.GingerBreadEntity;
import mod.yourmediocrepal.noel.init.NoelEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockPresent extends Block implements IWaterLoggable {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockPresent() {
        super(Properties.create(Material.MISCELLANEOUS)
            .hardnessAndResistance(0.5f,1.0f)
            .sound(SoundType.CLOTH)
            .notSolid()
        );

        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(false)));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isViewBlocking(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IWorld iworld = context.getWorld();
        BlockPos blockpos = context.getPos();
        boolean flag = iworld.getFluidState(blockpos).getFluid() == Fluids.WATER;
        return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(flag));
    }

    private void spawnElf(ServerWorld world, BlockPos pos) {
        ElfEntity elfentity = NoelEntityTypes.ELF.get().create(world);
        elfentity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
        world.addEntity(elfentity);
    }

    private void spawnGingerBread(ServerWorld world, BlockPos pos) {
        GingerBreadEntity gingerentity = NoelEntityTypes.GINGER_BREAD_MAN.get().create(world);
        gingerentity.setLocationAndAngles((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
        world.addEntity(gingerentity);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        Random rand = new Random();
        if(rand.nextInt(10) == 0) {
            if (worldIn instanceof ServerWorld) {
                this.spawnElf((ServerWorld) worldIn, pos);
            }
        } else if(rand.nextInt(10) == 1) {
            if (worldIn instanceof ServerWorld) {
                this.spawnGingerBread((ServerWorld) worldIn, pos);
            }
        }
        if(!worldIn.isRemote) worldIn.playSound((PlayerEntity)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
