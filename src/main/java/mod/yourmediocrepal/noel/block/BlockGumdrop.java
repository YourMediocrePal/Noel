package mod.yourmediocrepal.noel.block;

import mod.yourmediocrepal.noel.NoelMod;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BlockGumdrop extends WallMountedBlock {

    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape DOWN_SHAPE;
    protected static final VoxelShape UP_SHAPE;

    
    public BlockGumdrop(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(FACE, WallMountLocation.WALL));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING, FACE);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction direction = (Direction)state.get(FACING);
        switch((WallMountLocation)state.get(FACE)) {
            case FLOOR:
                return DOWN_SHAPE;
            case WALL:
                switch(direction) {
                    case EAST:
                        return EAST_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case NORTH:
                    default:
                        return NORTH_SHAPE;
                }
            case CEILING:
            default:
                return UP_SHAPE;
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canPlaceAt(world, pos, getDirection(state).getOpposite());
    }

    public static boolean canPlaceAt(WorldView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction);
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction.getOpposite()) ||
                world.getBlockState(blockPos).isIn(NoelMod.ORNAMENT_ATTACH);
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0F, DamageSource.FALL);
        }

    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounce(entity);
        }
    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0D) {
            double d = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }

    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        double d = Math.abs(entity.getVelocity().y);
        if (d < 0.1D && !entity.bypassesSteppingEffects()) {
            double e = 0.4D + d * 0.2D;
            entity.setVelocity(entity.getVelocity().multiply(e, 1.0D, e));
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    static {
        DOWN_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
        UP_SHAPE = Block.createCuboidShape(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D);
        NORTH_SHAPE = Block.createCuboidShape(3.0D, 3.0D, 8.0D, 13.0D, 13.0D, 16.0D);
        SOUTH_SHAPE = Block.createCuboidShape(3.0D, 3.0D, 0.0D, 13.0D, 13.0D, 8.0D);
        EAST_SHAPE = Block.createCuboidShape(0.0D, 3.0D, 3.0D, 8.0D, 13.0D, 13.0D);
        WEST_SHAPE = Block.createCuboidShape(8.0D, 3.0D, 3.0D, 16.0D, 13.0D, 13.0D);
    }
}
