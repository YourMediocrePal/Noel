package mod.yourmediocrepal.noel.capabilities;

import jdk.internal.dynalink.linker.LinkerServices;
import net.minecraft.command.arguments.NBTCompoundTagArgument;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.NBTTypes;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class AdventStorage implements Capability.IStorage<IAdventCapability> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IAdventCapability> capability, IAdventCapability instance, Direction side) {
        return IntNBT.valueOf(instance.getLastLogin());
    }

    @Override
    public void readNBT(Capability<IAdventCapability> capability, IAdventCapability instance, Direction side, INBT nbt) {
        if (!(instance instanceof Advent))
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");

        instance.set(((IntNBT)nbt).getInt());

    }

}


