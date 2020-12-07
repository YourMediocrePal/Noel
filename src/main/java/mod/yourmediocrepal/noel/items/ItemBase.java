package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(Noel.TAB));
    }
}
