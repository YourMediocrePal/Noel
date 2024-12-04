package mod.yourmediocrepal.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import mod.yourmediocrepal.Noel;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

import java.util.Set;
import java.util.stream.Stream;

public record NoelBlockSetType(String name, boolean canOpenByHand, BlockSoundGroup soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet();
    public static final BlockSetType FROSTED = register(new BlockSetType(Noel.MOD_ID + ":frosted"));
    public static final BlockSetType PEPPERMINT = register(new BlockSetType(Noel.MOD_ID + ":peppermint"));
    public static final BlockSetType GINGER_BREAD = register(new BlockSetType(Noel.MOD_ID + ":ginger_bread"));
    private static BlockSetType register(BlockSetType type) {
        VALUES.add(type);
        return type;
    }

    public static Stream<BlockSetType> values() {
        return VALUES.stream();
    }
}
