package mod.yourmediocrepal.block;

import mod.yourmediocrepal.entity.NoelEntities;
import mod.yourmediocrepal.entity.custom.GingerBreadEntity;
import mod.yourmediocrepal.entity.custom.SugarPlumFairyEntity;
import mod.yourmediocrepal.init.NoelSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class BlockPresent extends Block {

    public static final BooleanProperty TRAPPED = BooleanProperty.of("trap");

    public BlockPresent(boolean isTrap, Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(TRAPPED, isTrap));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TRAPPED);
    }


    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.isOf(this)) {
            if (state.get(TRAPPED)) {
                TntEntity tntEntity = (TntEntity) EntityType.TNT.create((World) world);
                if (tntEntity != null) {
                    tntEntity.refreshPositionAndAngles((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, 0.0F, 0.0F);
                    world.spawnEntity(tntEntity);
                }
            } else {
                double spawnChance = 0.1;
                if (world.getRandom().nextDouble() < spawnChance) {
                    if (world.getRandom().nextBoolean()) { // 50/50 chance between entities
                        SugarPlumFairyEntity sugarPlumFairyEntity = (SugarPlumFairyEntity) NoelEntities.SUGAR_PLUM_FAIRY.create((World) world);
                        if (sugarPlumFairyEntity != null) {
                            sugarPlumFairyEntity.refreshPositionAndAngles((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, 0.0F, 0.0F);
                            world.spawnEntity(sugarPlumFairyEntity);
                        }
                    } else {
                        GingerBreadEntity gingerBreadEntity = (GingerBreadEntity) NoelEntities.GINGER_BREAD.create((World) world);
                        if (gingerBreadEntity != null) {
                            gingerBreadEntity.refreshPositionAndAngles((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, 0.0F, 0.0F);
                            world.spawnEntity(gingerBreadEntity);
                        }
                    }
                }
            }
        }
    }



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    }
}