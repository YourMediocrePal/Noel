package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.init.NoelBlocks;
import mod.yourmediocrepal.noel.init.NoelItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.time.LocalDateTime;

public class ItemWarmMilk extends Item {

    public ItemWarmMilk() {
        super(new Properties()
                .group(Noel.TAB)
                .food(new Food.Builder()
                    .hunger(6)
                    .saturation(3.0f)
                    .build() )
        );
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);

        if (entityLiving instanceof ServerPlayerEntity) {
            LocalDateTime now = LocalDateTime.now();
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));

            serverplayerentity.getPersistentData().putBoolean("WarmMilk", true);
            Noel.LOGGER.info("Player drank warm milk!");
            serverplayerentity.sendStatusMessage(new StringTextComponent("You feel you will rest well tonight."), true);
        }

        if (!worldIn.isRemote) {
            entityLiving.removePotionEffect(Effects.POISON);
        }

        if (stack.isEmpty()) {
            return new ItemStack(NoelItems.MUG.get());
        } else {
            if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
                ItemStack itemstack = new ItemStack(NoelItems.MUG.get());
                PlayerEntity playerentity = (PlayerEntity)entityLiving;
                if (!playerentity.inventory.addItemStackToInventory(itemstack)) {
                    playerentity.dropItem(itemstack, false);
                }
            }

            return stack;
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }
}
