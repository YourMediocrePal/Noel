package mod.yourmediocrepal.item;

import mod.yourmediocrepal.event.NoelEffects;
import mod.yourmediocrepal.init.NoelItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ItemHotChocolate extends Item {
    public ItemHotChocolate(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;

        if (playerEntity != null) {
            stack.decrementUnlessCreative(1, playerEntity);
            playerEntity.addStatusEffect(new StatusEffectInstance(NoelEffects.FESTIVE, 6000, 0));
        }

        if (playerEntity == null || !playerEntity.isInCreativeMode()) {
            if (stack.isEmpty()) {
                return new ItemStack(NoelItems.MUG);
            }

            if (playerEntity != null) {
                playerEntity.getInventory().insertStack(new ItemStack(NoelItems.MUG));
            }
        }

        user.emitGameEvent(GameEvent.DRINK);
        return stack;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
