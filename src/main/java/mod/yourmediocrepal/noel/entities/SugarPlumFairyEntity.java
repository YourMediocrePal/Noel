package mod.yourmediocrepal.noel.entities;

import mod.yourmediocrepal.noel.init.NoelItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.EnumSet;


public class SugarPlumFairyEntity extends CreatureEntity implements IFlyingAnimal {

    public static final Ingredient temptation_items = Ingredient.fromItems(NoelItems.SUGAR_PLUM.get());

    public SugarPlumFairyEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new FlyingMovementController(this, 20, true);
    }

    public void move(MoverType typeIn, Vector3d pos) {
        super.move(typeIn, pos);
        this.doBlockCollisions();
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 12.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.6D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.1D, temptation_items, false));
        this.goalSelector.addGoal(2, new SugarPlumFairyEntity.WanderGoal());
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.BLOCK_NOTE_BLOCK_CHIME; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_BAT_DEATH; }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_BAT_HURT; }

    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
    }

    public float getBrightness() {
        return 1.0F;
    }

    private void startMovingTo(BlockPos pos) {
        Vector3d vector3d = Vector3d.copyCenteredHorizontally(pos);
        int i = 0;
        BlockPos blockpos = this.getPosition();
        int j = (int)vector3d.y - blockpos.getY();
        if (j > 2) {
            i = 4;
        } else if (j < -2) {
            i = -4;
        }

        int k = 6;
        int l = 8;
        int i1 = blockpos.manhattanDistance(pos);
        if (i1 < 15) {
            k = i1 / 2;
            l = i1 / 2;
        }

        Vector3d vector3d1 = RandomPositionGenerator.func_226344_b_(this, k, l, i, vector3d, (double)((float)Math.PI / 10F));
        if (vector3d1 != null) {
            this.navigator.setRangeMultiplier(0.5F);
            this.navigator.tryMoveToXYZ(vector3d1.x, vector3d1.y, vector3d1.z, 1.0D);
        }
    }

    protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn) {
            public boolean canEntityStandOnPos(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }
        };
        flyingpathnavigator.setCanOpenDoors(true);
        flyingpathnavigator.setCanSwim(true);
        flyingpathnavigator.setCanEnterDoors(true);
        return flyingpathnavigator;
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    class WanderGoal extends Goal {
        WanderGoal() {
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }


        public boolean shouldExecute() {
            return SugarPlumFairyEntity.this.navigator.noPath() && SugarPlumFairyEntity.this.rand.nextInt(10) == 0;
        }

        public boolean shouldContinueExecuting() {
            return SugarPlumFairyEntity.this.navigator.hasPath();
        }

        public void startExecuting() {
            Vector3d vector3d = this.getRandomLocation();
            if (vector3d != null) {
                SugarPlumFairyEntity.this.navigator.setPath(SugarPlumFairyEntity.this.navigator.getPathToPos(new BlockPos(vector3d), 1), 1.0D);
            }

        }

        @Nullable
        private Vector3d getRandomLocation() {
            Vector3d vector3d = SugarPlumFairyEntity.this.getLook(0.0F);

            int i = 8;
            Vector3d vector3d2 = RandomPositionGenerator.findAirTarget(SugarPlumFairyEntity.this, 8, 7, vector3d, ((float)Math.PI / 2F), 2, 1);
            return vector3d2 != null ? vector3d2 : RandomPositionGenerator.findGroundTarget(SugarPlumFairyEntity.this, 8, 4, -2, vector3d, (double)((float)Math.PI / 2F));
        }
    }


}
