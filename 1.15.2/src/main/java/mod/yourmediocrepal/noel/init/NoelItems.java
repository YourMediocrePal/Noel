package mod.yourmediocrepal.noel.init;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.blocks.BlockItemBase;
import mod.yourmediocrepal.noel.items.*;
import mod.yourmediocrepal.noel.items.armor.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NoelItems<pubic> {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Noel.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    //public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", ItemBase::new);
    public static final RegistryObject<Item> MUG = ITEMS.register("mug", ItemBase::new);
    public static final RegistryObject<Item> SPIRIT = ITEMS.register("spirit", ItemBase::new);
    public static final RegistryObject<Item> CANDLE_ITEM = ITEMS.register("candle", ItemWallOrFloor::new);
    public static final RegistryObject<Item> BELL_RINGER = ITEMS.register("bell_ringer", ItemBellRinger::new);
    //public static final RegistryObject<SpawnEggItem> ELF_SPAWN_EGG = ITEMS.register("elf_spawn_egg", () -> new SpawnEggItem(NoelEntityTypes.ELF.get(), 0x84D52F, 0xF33939, new Item.Properties().group(ItemGroup.MISC)));

    //Food
    public static final RegistryObject<ItemHotChocolate> HOT_CHOCHOLATE = ITEMS.register("hot_chocolate", ItemHotChocolate::new);
    public static final RegistryObject<ItemCandyCane> CANDY_CANE = ITEMS.register("candy_cane", ItemCandyCane::new);
    public static final RegistryObject<ItemWarmMilk> WARM_MILK = ITEMS.register("warm_milk", ItemWarmMilk::new);
    public static final RegistryObject<ItemWarmMilk> MUG_MILK = ITEMS.register("mug_milk", ItemWarmMilk::new);
    public static final RegistryObject<ItemPeppermintCandy> PEPPERMINT_CANDY = ITEMS.register("peppermint_candy", ItemPeppermintCandy::new);

    //Armor
    public static final RegistryObject<ArmorItem> PEPPERMINT_HELMET = ITEMS.register("peppermint_helmet", () -> new ArmorItem(ModArmorMaterial.PEPPERMINT, EquipmentSlotType.HEAD, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> PEPPERMINT_CHESTPLATE = ITEMS.register("peppermint_chestplate", () -> new ArmorItem(ModArmorMaterial.PEPPERMINT, EquipmentSlotType.CHEST, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> PEPPERMINT_LEGGINGS = ITEMS.register("peppermint_leggings", () -> new ArmorItem(ModArmorMaterial.PEPPERMINT, EquipmentSlotType.LEGS, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> PEPPERMINT_BOOTS = ITEMS.register("peppermint_boots", () -> new ArmorItem(ModArmorMaterial.PEPPERMINT, EquipmentSlotType.FEET, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> SANTA_HELMET = ITEMS.register("santa_helmet", () -> new ArmorItem(ModArmorMaterial.SANTA, EquipmentSlotType.HEAD, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> SANTA_CHESTPLATE = ITEMS.register("santa_chestplate", () -> new ArmorItem(ModArmorMaterial.SANTA, EquipmentSlotType.CHEST, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> SANTA_LEGGINGS = ITEMS.register("santa_leggings", () -> new ArmorItem(ModArmorMaterial.SANTA, EquipmentSlotType.LEGS, new Item.Properties().group(Noel.TAB)));
    public static final RegistryObject<ArmorItem> SANTA_BOOTS = ITEMS.register("santa_boots", () -> new ArmorItem(ModArmorMaterial.SANTA, EquipmentSlotType.FEET, new Item.Properties().group(Noel.TAB)));

    //////////-----BLOCKITEMS-----//////////

    //BlockItems
    //public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItemBase(EXAMPLE_BLOCK.get()));
    public static final RegistryObject<Item> ADVENT_CALENDAR_ITEM = ITEMS.register("advent_calendar", () -> new BlockItemBase(NoelBlocks.ADVENT_CALENDAR.get()));
    //public static final RegistryObject<Item> CANDLE_ITEM = ITEMS.register("candle", () -> new BlockItemBase(NoelBlocks.CANDLE.get()));
    public static final RegistryObject<Item> DONATION_BOOTH_ITEM = ITEMS.register("donation_booth", () -> new BlockItemBase(NoelBlocks.DONATION_BOOTH.get()));
    public static final RegistryObject<Item> GOLD_STAR_ITEM = ITEMS.register("gold_star", () -> new BlockItemBase(NoelBlocks.GOLD_STAR.get()));
    public static final RegistryObject<Item> GLOWSTONE_STAR_ITEM = ITEMS.register("glowstone_star", () -> new BlockItemBase(NoelBlocks.GLOWSTONE_STAR.get()));
    public static final RegistryObject<Item> KETTLE_ITEM = ITEMS.register("kettle", () -> new BlockItemBase(NoelBlocks.KETTLE.get()));
    public static final RegistryObject<Item> FROSTED_LOG_ITEM = ITEMS.register("frosted_log", () -> new BlockItemBase(NoelBlocks.FROSTED_LOG.get()));
    public static final RegistryObject<Item> FROSTED_PLANKS_ITEM = ITEMS.register("frosted_planks", () -> new BlockItemBase(NoelBlocks.FROSTED_PLANKS.get()));
    public static final RegistryObject<Item> FROSTED_TRAPDOOR_ITEM = ITEMS.register("frosted_trapdoor", () -> new BlockItemBase(NoelBlocks.FROSTED_TRAPDOOR.get()));
    public static final RegistryObject<Item> FROSTED_SLAB_ITEM = ITEMS.register("frosted_slab", () -> new BlockItemBase(NoelBlocks.FROSTED_SLAB.get()));
    public static final RegistryObject<Item> FROSTED_DOOR_ITEM = ITEMS.register("frosted_door", () -> new BlockItemBase(NoelBlocks.FROSTED_DOOR.get()));
    public static final RegistryObject<Item> FROSTED_FENCE_ITEM = ITEMS.register("frosted_fence", () -> new BlockItemBase(NoelBlocks.FROSTED_FENCE.get()));
    public static final RegistryObject<Item> FROSTED_FENCE_GATE_ITEM = ITEMS.register("frosted_fence_gate", () -> new BlockItemBase(NoelBlocks.FROSTED_FENCE_GATE.get()));
    public static final RegistryObject<Item> FROSTED_BUTTON_ITEM = ITEMS.register("frosted_button", () -> new BlockItemBase(NoelBlocks.FROSTED_BUTTON.get()));
    public static final RegistryObject<Item> FROSTED_PRESSURE_PLATE_ITEM = ITEMS.register("frosted_pressure_plate", () -> new BlockItemBase(NoelBlocks.FROSTED_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> FROSTED_STAIRS_ITEM = ITEMS.register("frosted_stairs", () -> new BlockItemBase(NoelBlocks.FROSTED_STAIRS.get()));
    public static final RegistryObject<Item> SPIRIT_ORE_ITEM = ITEMS.register("spirit_ore", () -> new BlockItemBase(NoelBlocks.SPIRIT_ORE.get()));
    public static final RegistryObject<Item> PEPPERMINT_LOG_ITEM = ITEMS.register("peppermint_log", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_LOG.get()));
    public static final RegistryObject<Item> PEPPERMINT_PLANKS_ITEM = ITEMS.register("peppermint_planks", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_PLANKS.get()));
    public static final RegistryObject<Item> PEPPERMINT_TRAPDOOR_ITEM = ITEMS.register("peppermint_trapdoor", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_TRAPDOOR.get()));
    public static final RegistryObject<Item> PEPPERMINT_SLAB_ITEM = ITEMS.register("peppermint_slab", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_SLAB.get()));
    public static final RegistryObject<Item> PEPPERMINT_DOOR_ITEM = ITEMS.register("peppermint_door", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_DOOR.get()));
    public static final RegistryObject<Item> PEPPERMINT_FENCE_ITEM = ITEMS.register("peppermint_fence", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_FENCE.get()));
    public static final RegistryObject<Item> PEPPERMINT_FENCE_GATE_ITEM = ITEMS.register("peppermint_fence_gate", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_FENCE_GATE.get()));
    public static final RegistryObject<Item> PEPPERMINT_BUTTON_ITEM = ITEMS.register("peppermint_button", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_BUTTON.get()));
    public static final RegistryObject<Item> PEPPERMINT_PRESSURE_PLATE_ITEM = ITEMS.register("peppermint_pressure_plate", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_PRESSURE_PLATE.get()));
    public static final RegistryObject<Item> PEPPERMINT_STAIRS_ITEM = ITEMS.register("peppermint_stairs", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_STAIRS.get()));
    public static final RegistryObject<Item> PEPPERMINT_WALL_ITEM = ITEMS.register("peppermint_wall", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_WALL.get()));
    public static final RegistryObject<Item> PRESENT_ITEM = ITEMS.register("present", () -> new BlockItemBase(NoelBlocks.PRESENT.get()));
    public static final RegistryObject<Item> PRESENT_TRAP_ITEM = ITEMS.register("present_trap", () -> new BlockItemBase(NoelBlocks.PRESENT_TRAP.get()));
    public static final RegistryObject<Item> STONE_PATH_ITEM = ITEMS.register("stone_path", () -> new BlockItemBase(NoelBlocks.STONE_PATH.get()));
    public static final RegistryObject<Item> WREATH_ITEM = ITEMS.register("wreath", () -> new BlockItemBase(NoelBlocks.WREATH.get()));
    public static final RegistryObject<Item> RIBBON_ITEM = ITEMS.register("ribbon", () -> new BlockItemBase(NoelBlocks.RIBBON.get()));
    public static final RegistryObject<Item> SHRUB_TREE_ITEM = ITEMS.register("shrub_tree", () -> new BlockItemBase(NoelBlocks.SHRUB_TREE.get()));

    //Ornament Block Items
    public static final RegistryObject<Item> COAL_ORNAMENT_ITEM = ITEMS.register("coal_ornament", () -> new BlockItemBase(NoelBlocks.COAL_ORNAMENT.get()));
    public static final RegistryObject<Item> DIAMOND_ORNAMENT_ITEM = ITEMS.register("diamond_ornament", () -> new BlockItemBase(NoelBlocks.DIAMOND_ORNAMENT.get()));
    public static final RegistryObject<Item> EMERMALD_ORNAMENT_ITEM = ITEMS.register("emerald_ornament", () -> new BlockItemBase(NoelBlocks.EMERALD_ORNAMENT.get()));
    public static final RegistryObject<Item> GLASS_ORNAMENT_ITEM = ITEMS.register("glass_ornament", () -> new BlockItemBase(NoelBlocks.GLASS_ORNAMENT.get()));
    public static final RegistryObject<Item> GOLD_ORNAMENT_ITEM = ITEMS.register("gold_ornament", () -> new BlockItemBase(NoelBlocks.GOLD_ORNAMENT.get()));
    public static final RegistryObject<Item> IRON_ORNAMENT_ITEM = ITEMS.register("iron_ornament", () -> new BlockItemBase(NoelBlocks.IRON_ORNAMENT.get()));
    public static final RegistryObject<Item> REDSTONE_ORNAMENT_ITEM = ITEMS.register("redstone_ornament", () -> new BlockItemBase(NoelBlocks.REDSTONE_ORNAMENT.get()));
    public static final RegistryObject<Item> LAPIS_ORNAMENT_ITEM = ITEMS.register("lapis_ornament", () -> new BlockItemBase(NoelBlocks.LAPIS_ORNAMENT.get()));
    public static final RegistryObject<Item> BLACK_ORNAMENT_ITEM = ITEMS.register("black_ornament", () -> new BlockItemBase(NoelBlocks.BLACK_ORNAMENT.get()));
    public static final RegistryObject<Item> BLUE_ORNAMENT_ITEM = ITEMS.register("blue_ornament", () -> new BlockItemBase(NoelBlocks.BLUE_ORNAMENT.get()));
    public static final RegistryObject<Item> BROWN_ORNAMENT_ITEM = ITEMS.register("brown_ornament", () -> new BlockItemBase(NoelBlocks.BROWN_ORNAMENT.get()));
    public static final RegistryObject<Item> CYAN_ORNAMENT_ITEM = ITEMS.register("cyan_ornament", () -> new BlockItemBase(NoelBlocks.CYAN_ORNAMENT.get()));
    public static final RegistryObject<Item> GRAY_ORNAMENT_ITEM = ITEMS.register("gray_ornament", () -> new BlockItemBase(NoelBlocks.GRAY_ORNAMENT.get()));
    public static final RegistryObject<Item> GREEN_ORNAMENT_ITEM = ITEMS.register("green_ornament", () -> new BlockItemBase(NoelBlocks.GREEN_ORNAMENT.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_ORNAMENT_ITEM = ITEMS.register("light_blue_ornament", () -> new BlockItemBase(NoelBlocks.LIGHT_BLUE_ORNAMENT.get()));
    public static final RegistryObject<Item> LIME_ORNAMENT_ITEM = ITEMS.register("lime_ornament", () -> new BlockItemBase(NoelBlocks.LIME_ORNAMENT.get()));
    public static final RegistryObject<Item> MAGENTA_ORNAMENT_ITEM = ITEMS.register("magenta_ornament", () -> new BlockItemBase(NoelBlocks.MAGENTA_ORNAMENT.get()));
    public static final RegistryObject<Item> ORANGE_ORNAMENT_ITEM = ITEMS.register("orange_ornament", () -> new BlockItemBase(NoelBlocks.ORANGE_ORNAMENT.get()));
    public static final RegistryObject<Item> PINK_ORNAMENT_ITEM = ITEMS.register("pink_ornament", () -> new BlockItemBase(NoelBlocks.PINK_ORNAMENT.get()));
    public static final RegistryObject<Item> PURPLE_ORNAMENT_ITEM = ITEMS.register("purple_ornament", () -> new BlockItemBase(NoelBlocks.PURPLE_ORNAMENT.get()));
    public static final RegistryObject<Item> RED_ORNAMENT_ITEM = ITEMS.register("red_ornament", () -> new BlockItemBase(NoelBlocks.RED_ORNAMENT.get()));
    public static final RegistryObject<Item> LIGHT_GRAY_ORNAMENT_ITEM = ITEMS.register("light_gray_ornament", () -> new BlockItemBase(NoelBlocks.LIGHT_GRAY_ORNAMENT.get()));
    public static final RegistryObject<Item> WHITE_ORNAMENT_ITEM = ITEMS.register("white_ornament", () -> new BlockItemBase(NoelBlocks.WHITE_ORNAMENT.get()));
    public static final RegistryObject<Item> YELLOW_ORNAMENT_ITEM = ITEMS.register("yellow_ornament", () -> new BlockItemBase(NoelBlocks.YELLOW_ORNAMENT.get()));

    //Stocking Block Items
    public static final RegistryObject<Item> BLACK_STOCKING_ITEM = ITEMS.register("black_stocking", () -> new BlockItemBase(NoelBlocks.BLACK_STOCKING.get()));
    public static final RegistryObject<Item> BLUE_STOCKING_ITEM = ITEMS.register("blue_stocking", () -> new BlockItemBase(NoelBlocks.BLUE_STOCKING.get()));
    public static final RegistryObject<Item> BROWN_STOCKING_ITEM = ITEMS.register("brown_stocking", () -> new BlockItemBase(NoelBlocks.BROWN_STOCKING.get()));
    public static final RegistryObject<Item> CYAN_STOCKING_ITEM = ITEMS.register("cyan_stocking", () -> new BlockItemBase(NoelBlocks.CYAN_STOCKING.get()));
    public static final RegistryObject<Item> GRAY_STOCKING_ITEM = ITEMS.register("gray_stocking", () -> new BlockItemBase(NoelBlocks.GRAY_STOCKING.get()));
    public static final RegistryObject<Item> GREEN_STOCKING_ITEM = ITEMS.register("green_stocking", () -> new BlockItemBase(NoelBlocks.GREEN_STOCKING.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_STOCKING_ITEM = ITEMS.register("light_blue_stocking", () -> new BlockItemBase(NoelBlocks.LIGHT_BLUE_STOCKING.get()));
    public static final RegistryObject<Item> LIME_STOCKING_ITEM = ITEMS.register("lime_stocking", () -> new BlockItemBase(NoelBlocks.LIME_STOCKING.get()));
    public static final RegistryObject<Item> MAGENTA_STOCKING_ITEM = ITEMS.register("magenta_stocking", () -> new BlockItemBase(NoelBlocks.MAGENTA_STOCKING.get()));
    public static final RegistryObject<Item> ORANGE_STOCKING_ITEM = ITEMS.register("orange_stocking", () -> new BlockItemBase(NoelBlocks.ORANGE_STOCKING.get()));
    public static final RegistryObject<Item> PINK_STOCKING_ITEM = ITEMS.register("pink_stocking", () -> new BlockItemBase(NoelBlocks.PINK_STOCKING.get()));
    public static final RegistryObject<Item> PURPLE_STOCKING_ITEM = ITEMS.register("purple_stocking", () -> new BlockItemBase(NoelBlocks.PURPLE_STOCKING.get()));
    public static final RegistryObject<Item> RED_STOCKING_ITEM = ITEMS.register("red_stocking", () -> new BlockItemBase(NoelBlocks.RED_STOCKING.get()));
    public static final RegistryObject<Item> LIGHT_GRAY_STOCKING_ITEM = ITEMS.register("light_gray_stocking", () -> new BlockItemBase(NoelBlocks.LIGHT_GRAY_STOCKING.get()));
    public static final RegistryObject<Item> WHITE_STOCKING_ITEM = ITEMS.register("white_stocking", () -> new BlockItemBase(NoelBlocks.WHITE_STOCKING.get()));
    public static final RegistryObject<Item> YELLOW_STOCKING_ITEM = ITEMS.register("yellow_stocking", () -> new BlockItemBase(NoelBlocks.YELLOW_STOCKING.get()));

}
