package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemSugarPlum extends Item {

    public ItemSugarPlum() {
        super(new Properties()
                .group(Noel.TAB)
                .food(new Food.Builder()
                        .hunger(8)
                        .saturation(5f)
                        .effect(new EffectInstance(Effects.SPEED, 200, 1), 1f)
                        .build() )
        );
    }
}
