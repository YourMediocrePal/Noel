package mod.yourmediocrepal.noel.block.entity;

import mod.yourmediocrepal.noel.NoelMod;
import mod.yourmediocrepal.noel.registry.ItemRegistry;
import mod.yourmediocrepal.noel.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class KettleBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory {

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(4, ItemStack.EMPTY);

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public static void tick(World world, BlockPos pos, BlockState state, KettleBlockEntity be) {
        be.craft();
    }

    public KettleBlockEntity(BlockPos pos, BlockState state) {
        super(NoelMod.KETTLE_BLOCK_ENTITY, pos, state);
    }

    public void craft() {
        if(getStack(0).getItem() == Items.COCOA_BEANS && getStack(1).getItem() == Items.MILK_BUCKET
                && getStack(2).getItem() == ItemRegistry.MUG && getStack(3).isEmpty() ) {
            removeStack(0);
            setStack(1, new ItemStack(Items.BUCKET));
            removeStack(2);
            setStack(3, new ItemStack(ItemRegistry.HOT_CHOCOLATE));
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        return super.writeNbt(nbt);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
       if(direction != Direction.UP) {
           if (slot == 0 && getStack(0).isEmpty() && stack.getItem() == Items.COCOA_BEANS) {
               return true;
           }
           else if (slot == 1 && getStack(1).isEmpty() && stack.getItem() == Items.MILK_BUCKET) {
               return true;
           }
           else if (slot == 2 && getStack(2).isEmpty() && stack.getItem() == ItemRegistry.MUG) {
               return true;
           }
           craft();
       }
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        Boolean b = false;
        if(direction == Direction.DOWN) {
            if(slot == 1 && getStack(1).isOf(Items.BUCKET) ||
                slot == 3) {
                    b = true;
            }
        }
        return b;
    }

}
