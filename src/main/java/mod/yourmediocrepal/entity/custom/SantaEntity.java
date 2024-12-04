package mod.yourmediocrepal.entity.custom;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.init.NoelBlocks;
import mod.yourmediocrepal.init.NoelSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Npc;
import net.minecraft.entity.ai.goal.LongDoorInteractGoal;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.dimension.DimensionTypes;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class SantaEntity extends PathAwareEntity implements Npc {

    private Set<BlockPos> visitedStars;
    private BlockPos foundPointOfInterest;
    private BlockPos targetPos;

    public SantaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.visitedStars = new HashSet<>();
        ((MobNavigation)this.getNavigation()).setCanPathThroughDoors(true);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new LongDoorInteractGoal(this, false));
        this.goalSelector.add(1, new FindStarGoal(this, NoelBlocks.GLOWSTONE_STAR, 1.0D, 30));
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.6));
    }

    public static DefaultAttributeContainer.Builder createSantaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5);
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }

    public BlockPos getFoundPointOfInterest() {
        return foundPointOfInterest;
    }

    public void setFoundPointOfInterest(BlockPos pos) {
        this.foundPointOfInterest = pos;
    }

    public BlockPos getTargetPos() {
        return targetPos;
    }

    public void setTargetPos(BlockPos pos) {
        this.targetPos = pos;
    }

    @Override
    protected void mobTick() {
        if(this.getWorld().getTimeOfDay() == 6000) {
            this.getWorld().addParticle(ParticleTypes.END_ROD, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5), 0.0, 0.0, 0.0);
            this.playSound(NoelSounds.JINGLE_BELLS);
            this.remove(RemovalReason.DISCARDED);

            Noel.LOGGER.info("Santa despawned during the day!");

        }
    }


    private class FindStarGoal extends MoveToTargetPosGoal {
        private final SantaEntity entity;
        private final Block targetBlock;
        private final int searchRange;
        int presentChance = 5;

        public FindStarGoal(SantaEntity entity, Block targetBlock, double speed, int searchRange) {
            super(entity, speed, searchRange);
            this.entity = entity;
            this.targetBlock = targetBlock;
            this.searchRange = searchRange;
        }

        @Override
        protected boolean isTargetPos(WorldView world, BlockPos pos) {
            BlockState state = world.getBlockState(pos);
            return state.getBlock() == targetBlock && !entity.visitedStars.contains(pos);
        }

        @Override
        protected boolean findTargetPos() {
            int i = this.searchRange;
            BlockPos blockPos = this.entity.getBlockPos();
            BlockPos.Mutable mutable = new BlockPos.Mutable();

            for (int x = -i; x <= i; x++) {
                for (int y = -i; y <= i; y++) {
                    for (int z = -i; z <= i; z++) {
                        mutable.set(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);

                        if (entity.visitedStars.contains(mutable)) {
                            continue;
                        }

                        if (this.entity.isInWalkTargetRange(mutable) && this.isTargetPos(this.entity.getWorld(), mutable)) {
                            this.targetPos = mutable;
                            Noel.LOGGER.info("Found target block at: " + mutable);
                            return true;
                        } else {
                            Noel.LOGGER.debug("Checked block at " + mutable + " but not suitable.");
                        }
                    }
                }
            }
            Noel.LOGGER.info("Target block not found within search range.");
            return false;
        }

        @Override
        public boolean canStart() {
            return super.canStart();
        }

        @Override
        protected void startMovingToTarget() {
            this.entity.getNavigation().startMovingTo(
                    (double) this.targetPos.getX() + 0.5,
                    (double) (this.targetPos.getY() + 1),
                    (double) this.targetPos.getZ() + 0.5,
                    this.speed
            );
            Noel.LOGGER.info("Santa is moving to target position: " + this.targetPos); // Debug log
        }

        @Override
        public void tick() {
            super.tick();
            double targetY = this.targetPos.getY();
            double entityY = this.entity.getY();

            if (this.targetBlock != null && this.entity.squaredDistanceTo(this.targetPos.getX(), this.entity.getY(), this.targetPos.getZ()) < 15.0D) {
                Noel.LOGGER.info("Santa reached target position: " + this.targetPos);
                this.entity.playSound(NoelSounds.JINGLE_BELLS);

                entity.visitedStars.add(this.targetPos);
                setTargetPos(this.targetPos);
                for (int i = 0; i < presentChance; i++) {
                    placeRandomPresent(entity);
                }

                entity.remove(RemovalReason.DISCARDED);
                this.stop();
            }
        }

        @Override
        public void stop() {
            super.stop();
            Noel.LOGGER.info("FindStarGoal has been stopped.");
        }
    }

    private void placeRandomPresent(SantaEntity entity) {
        int MAX_ATTEMPTS = 5;
        int range = 5;
        BlockPos entityPos = entity.getBlockPos();

        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            int randomX = entityPos.getX() + entity.getRandom().nextInt(range * 2 + 1) - range;
            int randomZ = entityPos.getZ() + entity.getRandom().nextInt(range * 2 + 1) - range;

            int randomY = entityPos.getY() + entity.getRandom().nextInt(4) - 2;

            BlockPos randomPos = new BlockPos(randomX, randomY, randomZ);

            BlockPos groundPos = findGroundLevel(randomPos, entity);
            if (groundPos != null) {
                BlockState targetBlockState = entity.getWorld().getBlockState(groundPos);
                if (targetBlockState.isAir() && isBlockSolid(groundPos.down(), entity)) {
                    entity.getWorld().setBlockState(groundPos, NoelBlocks.PRESENT.getDefaultState());
                    Noel.LOGGER.info("Random present successfully placed at: " + groundPos);
                    return;
                }
            }
        }

        Noel.LOGGER.warn("Failed to place a random present after " + MAX_ATTEMPTS + " attempts.");
    }

    private BlockPos findGroundLevel(BlockPos pos, SantaEntity entity) {
        for (int y = pos.getY(); y >= entity.getWorld().getBottomY(); y--) {
            BlockPos currentPos = new BlockPos(pos.getX(), y, pos.getZ());
            BlockState state = entity.getWorld().getBlockState(currentPos);
            if (state.isSolid()) {
                Noel.LOGGER.info("Ground found at: " + currentPos);
                return currentPos.up();
            }
        }
        Noel.LOGGER.info("No ground level found starting from: " + pos);
        return null;
    }

    private boolean isBlockSolid(BlockPos pos, SantaEntity entity) {
        BlockState blockState = entity.getWorld().getBlockState(pos);
        return blockState.isSolid();
    }


}
