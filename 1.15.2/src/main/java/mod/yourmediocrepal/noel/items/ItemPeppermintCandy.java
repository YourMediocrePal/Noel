package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ItemPeppermintCandy extends Item {

    public ItemPeppermintCandy() {
        super(new Properties()
                .group(Noel.TAB)
                .food(new Food.Builder()
                        .hunger(1)
                        .saturation(0f)
                        .fastToEat()
                        .build() )
        );
    }
}
