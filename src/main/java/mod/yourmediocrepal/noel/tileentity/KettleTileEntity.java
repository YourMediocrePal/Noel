package mod.yourmediocrepal.noel.tileentity;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.blocks.BlockKettle;
import mod.yourmediocrepal.noel.init.NoelItems;
import mod.yourmediocrepal.noel.init.NoelTileEntityTypes;
import mod.yourmediocrepal.noel.util.NoelItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;

public class KettleTileEntity extends TileEntity implements ITickableTileEntity
{
    public int currentSmeltTime;
    private final int maxSmeltTime = 100;
    private NoelItemHandler inventory;
    private boolean hasMilk;
    private boolean hasCocoa;
    private boolean hasHotCocoa;
    private boolean hasBone;
    private boolean hasBoneBlock;
    private boolean hasGelatin;
    private boolean hasSugarCane;
    private boolean hasMolasses;
    private boolean canCook = true;
    private int ignitionTime;
    private boolean isCooking;
    private String activeParticle;
    private String type;


    public KettleTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public KettleTileEntity() {
        this(NoelTileEntityTypes.KETTLE.get());
    }

    public void useItem(Item item, PlayerEntity player) {
        if(!world.isRemote) {
            System.out.println("Player used " + item);
            if (item == Items.FLINT_AND_STEEL.getItem() || item == Items.FIRE_CHARGE) {
                this.playSound(SoundEvents.ITEM_FLINTANDSTEEL_USE);

                ignitionTime = 400;
                System.out.println("Used flint...");

            } else if (item == Items.COCOA_BEANS && !this.hasCocoa) {
                this.playSound(SoundEvents.ITEM_BUCKET_EMPTY);
                if (!player.isCreative()) player.getHeldItem(player.swingingHand).shrink(1);

                this.hasCocoa = true;
                System.out.println("Used Cocoa...");
            } else if (item == Items.MILK_BUCKET && !this.hasMilk) {

                this.playSound(SoundEvents.ITEM_BUCKET_EMPTY);
                if (!player.isCreative()) player.setHeldItem(player.swingingHand, new ItemStack(Items.BUCKET));

                this.hasMilk = true;
                System.out.println("Used Milk...");
            } else if (item == Items.BONE && !this.hasBone) {

                this.playSound(SoundEvents.ITEM_BUCKET_EMPTY);
                if (!player.isCreative()) player.getHeldItem(player.swingingHand).shrink(1);

                this.hasBone = true;
                Noel.LOGGER.info("Player used bone in kettle");
            }  else if (item == Items.BONE_BLOCK && !this.hasBoneBlock) {

                this.playSound(SoundEvents.ITEM_BUCKET_EMPTY);
                if (!player.isCreative()) player.getHeldItem(player.swingingHand).shrink(1);

                this.hasBoneBlock = true;
                Noel.LOGGER.info("Player used bone blockin kettle");
            }else if (item == NoelItems.MUG.get() && this.hasHotCocoa) {

                player.setHeldItem(player.swingingHand, new ItemStack(NoelItems.HOT_CHOCHOLATE.get()));
                this.playSound(SoundEvents.ITEM_BUCKET_FILL);

                this.type = null;
                this.canCook = true;
                this.hasHotCocoa = false;
                Noel.LOGGER.info("Player cooked hot chocolate");
            }else if (this.hasGelatin) {
                if (type == "GELATIN_9") player.addItemStackToInventory(new ItemStack(NoelItems.GELATIN.get(), 9));
                else player.addItemStackToInventory(new ItemStack(NoelItems.GELATIN.get()));
                this.playSound(SoundEvents.ITEM_BUCKET_FILL);

                this.type = null;
                this.canCook = true;
                this.hasGelatin = false;
                Noel.LOGGER.info("Player cooked gelatin");
            } else if (item == Items.SUGAR_CANE && !this.hasSugarCane) {

                if (!player.isCreative()) player.getHeldItem(player.swingingHand).shrink(1);
                this.playSound(SoundEvents.ITEM_BUCKET_FILL);

                this.hasSugarCane = true;
                Noel.LOGGER.info("Player added sugar cane");
            } else if (this.hasMolasses && item == Items.GLASS_BOTTLE) {
                player.setHeldItem(player.swingingHand, new ItemStack(NoelItems.MOLASSES.get()));
                this.playSound(SoundEvents.ITEM_BUCKET_FILL);

                this.type = null;
                this.canCook = true;
                this.hasMolasses = false;
                Noel.LOGGER.info("Player cooked molasses");
            }
            attemptCook();
        }
    }

    public void attemptCook() {
        if(!this.hasSugarCane && !this.hasBone && !this.hasBoneBlock && this.hasMilk && this.hasCocoa && this.ignitionTime > 0 && this.canCook) {
            this.canCook = false;
            this.isCooking = true;
            this.type = "HOT_CHOCOLATE";
            System.out.println("Attempt to Cook...");

            if (this.world != null && !this.world.isRemote) {
                BlockState blockstate = this.getBlockState();
                Block block = blockstate.getBlock();
                if (block instanceof BlockKettle) {
                    BlockKettle.updateState(blockstate, this.world, this.pos, this.isCooking, this.getIgnition());
                }
            }
        } else if(!this.hasSugarCane && this.hasBone && !this.hasBoneBlock && !this.hasMilk && !this.hasCocoa && this.ignitionTime > 0 && this.canCook) {
            this.canCook = false;
            this.isCooking = true;
            this.type = "GELATIN";
            Noel.LOGGER.info("Player is cooking gelatin");

            if (this.world != null && !this.world.isRemote) {
                BlockState blockstate = this.getBlockState();
                Block block = blockstate.getBlock();
                if (block instanceof BlockKettle) {
                    BlockKettle.updateState(blockstate, this.world, this.pos, this.isCooking, this.getIgnition());
                }
            }
        } else if(!this.hasSugarCane && !this.hasBone && this.hasBoneBlock && !this.hasMilk && !this.hasCocoa && this.ignitionTime > 0 && this.canCook) {
            this.canCook = false;
            this.isCooking = true;
            this.type = "GELATIN_9";
            Noel.LOGGER.info("Player is cooking gelatin");

            if (this.world != null && !this.world.isRemote) {
                BlockState blockstate = this.getBlockState();
                Block block = blockstate.getBlock();
                if (block instanceof BlockKettle) {
                    BlockKettle.updateState(blockstate, this.world, this.pos, this.isCooking, this.getIgnition());
                }
            }
        } else if(this.hasSugarCane && !this.hasBone && !this.hasBoneBlock && !this.hasMilk && !this.hasCocoa && this.ignitionTime > 0 && this.canCook) {
            this.canCook = false;
            this.isCooking = true;
            this.type = "MOLASSES";
            Noel.LOGGER.info("Player is cooking molasses");

            if (this.world != null && !this.world.isRemote) {
                BlockState blockstate = this.getBlockState();
                Block block = blockstate.getBlock();
                if (block instanceof BlockKettle) {
                    BlockKettle.updateState(blockstate, this.world, this.pos, this.isCooking, this.getIgnition());
                }
            }
        }

    }

    public boolean getIsCooking() {
        return isCooking;
    }

    public boolean getHasHotCocoa() {
        return hasHotCocoa;
    }

    public boolean getIgnition() {
        if (ignitionTime >= 1) return true;
        else return false;
    }

    @Override
    public void tick() {
        boolean dirty = false;

        if(this.world != null && !this.world.isRemote) {
            if(isCooking) {
                if (this.currentSmeltTime != this.maxSmeltTime) {
                    this.activeParticle = "CLOUD";
                    this.currentSmeltTime++;
                    dirty = true;
                } else if (type == "HOT_CHOCOLATE") {
                    this.hasHotCocoa = true;
                    this.hasMilk = false;
                    this.hasCocoa = false;
                    this.hasBone = false;
                    this.hasBoneBlock = false;
                    this.hasSugarCane = false;
                    this.hasGelatin = false;
                    this.hasMolasses = false;
                    this.currentSmeltTime = 0;
                    this.isCooking = false;
                    this.currentSmeltTime = 0;

                    if(!world.isRemote) this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH);

                    System.out.println("Done!");
                    dirty = true;
                } else if (type == "GELATIN") {
                    this.hasHotCocoa = false;
                    this.hasMilk = false;
                    this.hasCocoa = false;
                    this.hasBone = false;
                    this.hasBoneBlock = false;
                    this.hasSugarCane = false;
                    this.hasGelatin = true;
                    this.hasMolasses = false;
                    this.currentSmeltTime = 0;
                    this.isCooking = false;
                    this.currentSmeltTime = 0;

                    if(!world.isRemote) this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH);

                    System.out.println("Done!");
                    dirty = true;
                } else if (type == "GELATIN_9") {
                    this.hasHotCocoa = false;
                    this.hasMilk = false;
                    this.hasCocoa = false;
                    this.hasBone = false;
                    this.hasBoneBlock = false;
                    this.hasSugarCane = false;
                    this.hasGelatin = true;
                    this.hasMolasses = false;
                    this.currentSmeltTime = 0;
                    this.isCooking = false;
                    this.currentSmeltTime = 0;

                    if(!world.isRemote) this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH);

                    System.out.println("Done!");
                    dirty = true;
                } else if (type == "MOLASSES") {
                    this.hasHotCocoa = false;
                    this.hasMilk = false;
                    this.hasCocoa = false;
                    this.hasBone = false;
                    this.hasBoneBlock = false;
                    this.hasSugarCane = false;
                    this.hasGelatin = false;
                    this.hasMolasses = true;
                    this.currentSmeltTime = 0;
                    this.isCooking = false;
                    this.currentSmeltTime = 0;

                    if(!world.isRemote) this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH);

                    System.out.println("Done!");
                    dirty = true;
                }
            }
            if (ignitionTime >= 0) {
                ignitionTime--;
                dirty = true;
            }

            if(!world.isRemote) {
                BlockState blockstate = this.getBlockState();

                Block block = blockstate.getBlock();
                if (block instanceof BlockKettle) {
                    BlockKettle.updateState(blockstate, this.world, this.pos, this.isCooking, this.getIgnition());
                }
            }
        }
    }

    public int getIgnitionTime() {
        return ignitionTime;
    }


    public void playSound(SoundEvent soundEvent) {
        this.world.playSound((PlayerEntity)null, this.pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    public void read(BlockState state, CompoundNBT compound) {
        super.read(state, compound);
        this.canCook = compound.getBoolean("CanCook");
        this.hasMilk = compound.getBoolean("HasMilk");
        this.hasCocoa = compound.getBoolean("HasCocoa");
        this.hasHotCocoa = compound.getBoolean("HasHotCocoa");
        this.hasBone = compound.getBoolean("HasBone");
        this.hasBoneBlock = compound.getBoolean("HasBoneBlock");
        this.hasGelatin = compound.getBoolean("HasGelatin");
        this.hasSugarCane = compound.getBoolean("HasSugarCane");
        this.hasMolasses = compound.getBoolean("HasMolasses");
        this.isCooking = compound.getBoolean("IsCooking");
        this.currentSmeltTime = compound.getInt("CurrentSmeltTime");
        this.ignitionTime = compound.getInt("IgnitionTime");
        this.type = compound.getString("Type");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putBoolean("CanCook", this.canCook);
        compound.putBoolean("HasMilk", this.hasMilk);
        compound.putBoolean("HasCocoa", this.hasCocoa);
        compound.putBoolean("HasHotCocoa", this.hasHotCocoa);
        compound.putBoolean("HasBone", this.hasBone);
        compound.putBoolean("HasBoneBlock", this.hasBoneBlock);
        compound.putBoolean("HasGelatin", this.hasGelatin);
        compound.putBoolean("HasSugarCane", this.hasSugarCane);
        compound.putBoolean("HasMolasses", this.hasMolasses);
        compound.putBoolean("IsCooking", this.isCooking);
        compound.putInt("CurrentSmeltTime", this.currentSmeltTime);
        compound.putInt("IgnitionTime", this.ignitionTime);
        compound.putString("Type", this.type);
        return compound;
    }

}
