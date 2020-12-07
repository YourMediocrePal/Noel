package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemCandyCane extends Item {

    public ItemCandyCane() {
        super(new Item.Properties()
                .group(Noel.TAB)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(1.0f)
                        .build() )
        );
    }
}
