package mod.yourmediocrepal.noel.entities;

import mod.yourmediocrepal.noel.init.NoelItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ElfEntity extends CreatureEntity {

    public static final Ingredient temptation_items = Ingredient.fromItems(NoelItems.HOT_CHOCHOLATE.get());

    public ElfEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 12.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.1D, temptation_items, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new InteractDoorGoal(this) {@Override protected boolean canDestroy() { return false; }
        });
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_VILLAGER_AMBIENT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_VILLAGER_DEATH; }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_VILLAGER_HURT; }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP, 0.15F, 1.0F);
    }

}
