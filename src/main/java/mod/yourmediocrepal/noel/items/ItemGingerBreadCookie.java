package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ItemGingerBreadCookie extends Item {

    public ItemGingerBreadCookie() {
        super(new Properties()
                .group(Noel.TAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(2.0f)
                        .build() )
        );
    }
}
