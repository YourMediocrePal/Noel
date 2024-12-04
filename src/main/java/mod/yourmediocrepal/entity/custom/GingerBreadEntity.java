package mod.yourmediocrepal.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class GingerBreadEntity extends PathAwareEntity {
    public GingerBreadEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new FleeGoal(this, PlayerEntity.class, 8.0F, 1.5, 2.0));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.6));
    }

    public static DefaultAttributeContainer.Builder createGingerAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_ARMOR, 0);
    }

    static class FleeGoal<T extends LivingEntity> extends FleeEntityGoal<T> {
        private final GingerBreadEntity gingerBread;

        public FleeGoal(GingerBreadEntity gingerBread, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
            super(gingerBread, fleeFromType, distance, slowSpeed, fastSpeed);
            this.gingerBread = gingerBread;
        }

        @Override
        public boolean canStart() {
            return super.canStart();
        }
    }

}
