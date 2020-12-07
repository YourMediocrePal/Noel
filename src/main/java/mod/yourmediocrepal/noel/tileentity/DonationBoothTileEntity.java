package mod.yourmediocrepal.noel.tileentity;

import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.UUID;

public class DonationBoothTileEntity extends TileEntity {

    private int diamondCount;
    private int goldCount;
    private int ironCount;
    private String playerUniqueId;

    public DonationBoothTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public DonationBoothTileEntity() {
        this(NoelTileEntityTypes.DONATION_BOOTH.get());
    }

    public void setPlayer(UUID playerUniqueId) {
        this.playerUniqueId = playerUniqueId.toString();
    }

    public boolean canAddItem(Item item) {
        if (diamondCount < 64 && item == Items.DIAMOND) return true;
        else if (goldCount < 64 && item == Items.GOLD_INGOT) return true;
        else if (ironCount < 64 && item == Items.IRON_INGOT) return true;
        else return false;
    }

    public void addItem(Item item, int count) {
        if(item == Items.DIAMOND) diamondCount++;
        if(item == Items.GOLD_INGOT) goldCount++;
        if(item == Items.IRON_INGOT) ironCount++;
    }

    public void removeItem(UUID player) {
        if(!world.isRemote) {
            if (player.toString() == playerUniqueId) {
                ItemEntity diamondItem = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, new ItemStack(Items.DIAMOND, diamondCount));
                ItemEntity goldItem = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, new ItemStack(Items.GOLD_INGOT, goldCount));
                ItemEntity ironItem = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, new ItemStack(Items.IRON_INGOT, ironCount));

                if (diamondCount >= 1) {
                    world.addEntity(diamondItem);
                    diamondCount = 0;
                }
                if (goldCount >= 1) {
                    world.addEntity(goldItem);
                    goldCount = 0;
                }
                if (ironCount >= 1) {
                    world.addEntity(ironItem);
                    ironCount = 0;
                }
            }
        }
    }

    public void destroyedBlock() {
        if(!world.isRemote) {
            ItemEntity diamondItem = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, new ItemStack(Items.DIAMOND, diamondCount));
            ItemEntity goldItem = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, new ItemStack(Items.GOLD_INGOT, goldCount));
            ItemEntity ironItem = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, new ItemStack(Items.IRON_INGOT, ironCount));
            world.addEntity(diamondItem);
            world.addEntity(goldItem);
            world.addEntity(ironItem);
        }
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        this.diamondCount = compound.getInt("Diamond");
        this.goldCount = compound.getInt("Gold");
        this.ironCount = compound.getInt("Iron");
        this.playerUniqueId = compound.getString("Player");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("Diamond", this.diamondCount);
        compound.putInt("Gold", this.goldCount);
        compound.putInt("Iron", this.ironCount);
        compound.putString("Player", this.playerUniqueId);

        return compound;
    }

}
