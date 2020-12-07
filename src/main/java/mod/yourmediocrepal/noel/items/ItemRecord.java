package mod.yourmediocrepal.noel.items;

import mod.yourmediocrepal.noel.Noel;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;

public class ItemRecord extends MusicDiscItem {

    public ItemRecord(int comparatorValue, Lazy<SoundEvent> soundIn) {
        super(comparatorValue, soundIn, new Item.Properties().maxStackSize(1).group(Noel.TAB).rarity(Rarity.RARE));
    }
}
