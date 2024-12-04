package mod.yourmediocrepal.block.entity;

import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.init.NoelBlockEntityTypes;
import mod.yourmediocrepal.init.NoelItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;


public class KettleBlockEntity extends BlockEntity {

    private static boolean isCooking = false;
    private static int cookingTimer = 0; // Timer to track cooking progress
    private static final int COOKING_TIME = 300; // Time required to cook (in ticks, 1 tick = 1/20 of a second)
    private static int particleCooldown = 0;

    public static final Logger LOGGER = LoggerFactory.getLogger(Noel.MOD_ID);

    public KettleBlockEntity(BlockPos pos, BlockState state) {
        super(NoelBlockEntityTypes.KETTLE_BLOCK, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, KettleBlockEntity blockEntity) {
        if (isCooking) {
            cookingTimer--;

            if (particleCooldown <= 0) {
                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, 0.0, 0.02, 0.0);
                particleCooldown = 10;
            } else {
                particleCooldown--;
            }

            if (cookingTimer <= 0) {

                spawnItemAboveKettle(world, pos);
            }
        }
    }

    public void startCooking(World world, BlockPos pos, PlayerEntity player) {
        Inventory inventory = player.getInventory();
        LOGGER.info("Start Cooking");
        if (hasIngredients(player)) {
            LOGGER.info("Has Ingredients");
            isCooking = true;
            cookingTimer = COOKING_TIME;

            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);

            for (int i = 0; i < inventory.size(); i++) {
                ItemStack stack = inventory.getStack(i);
                if (stack.getItem() == Items.MILK_BUCKET && stack.getCount() > 0) {
                    inventory.setStack(i, new ItemStack(Items.BUCKET));
                    break;
                }
            }

            for (int i = 0; i < inventory.size(); i++) {
                ItemStack stack = inventory.getStack(i);
                if (stack.getItem() == Items.COCOA_BEANS) {
                    inventory.removeStack(i, 1);
                    break;
                }
                if (stack.getItem() == NoelItems.MUG) {
                    inventory.removeStack(i, 1);
                    break;
                }
            }
        } else {
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, 0.0, 0.1, 0.0);
        }
    }

    private boolean hasIngredients(PlayerEntity player) {
        Inventory inventory = player.getInventory();
        boolean hasMilk = false, hasCocoaBeans = false, hasMug = false;
        List<String> missingItems = new ArrayList<>();


        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            if (stack.getItem() == Items.MILK_BUCKET && stack.getCount() > 0) hasMilk = true;
            if (stack.getItem() == Items.COCOA_BEANS && stack.getCount() > 0) hasCocoaBeans = true;
            if (stack.getItem() == NoelItems.MUG && stack.getCount() > 0) hasMug = true;
        }

        if (!hasMilk) missingItems.add("Milk");
        if (!hasCocoaBeans) missingItems.add("Cocoa Beans");
        if (!hasMug) missingItems.add("Mug");

        if (!missingItems.isEmpty()) {
            player.sendMessage(Text.literal("Missing ingredients: " + String.join(", ", missingItems)), false);
            return false;
        }

        return hasMilk && hasCocoaBeans && hasMug;
    }


    private static void spawnItemAboveKettle(World world, BlockPos pos) {
        if (world != null && !world.isClient) {
            LOGGER.info("Is Cooking");
            ItemStack hotChocolate = new ItemStack(NoelItems.HOT_CHOCOLATE);

            isCooking = false;
            cookingTimer = 0;

            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 1.0;
            double z = pos.getZ() + 0.5;
            ItemEntity itemEntity = new ItemEntity(world, x, y, z, hotChocolate);
            world.spawnEntity(itemEntity);
        }
    }




}
