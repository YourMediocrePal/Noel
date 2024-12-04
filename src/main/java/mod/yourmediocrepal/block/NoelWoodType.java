package mod.yourmediocrepal.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

import java.util.Set;
import java.util.stream.Stream;

public record NoelWoodType (String name, BlockSetType setType, BlockSoundGroup soundType, BlockSoundGroup hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen) {

    private static final Set<WoodType> VALUES = new ObjectArraySet();
    public static final WoodType FROSTED = register(new WoodType("frosted", NoelBlockSetType.FROSTED));
    public static final WoodType PEPPERMINT = register(new WoodType("peppermint", NoelBlockSetType.PEPPERMINT));
    public static final WoodType GINGER_BREAD = register(new WoodType("ginger_bread", NoelBlockSetType.GINGER_BREAD));

    private static WoodType register(WoodType type) {
        VALUES.add(type);
        return type;
    }

    public static Stream<WoodType> values() {
        return VALUES.stream();
    }
}
