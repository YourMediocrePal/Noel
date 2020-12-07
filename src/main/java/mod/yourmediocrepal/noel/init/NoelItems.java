package mod.yourmediocrepal.noel.init;

import mod.yourmediocrepal.noel.Noel;
import mod.yourmediocrepal.noel.blocks.BlockItemBase;
import mod.yourmediocrepal.noel.items.*;
import mod.yourmediocrepal.noel.items.armor.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
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
    public static final RegistryObject<Item> MUG = ITEMS.register("mug", ItemBase::new);
    public static final RegistryObject<Item> SPIRIT = ITEMS.register("spirit", ItemBase::new);
    public static final RegistryObject<Item> CANDLE_ITEM = ITEMS.register("candle", ItemWallOrFloor::new);
    public static final RegistryObject<Item> BELL_RINGER = ITEMS.register("bell_ringer", ItemBellRinger::new);
    public static final RegistryObject<Item> GELATIN = ITEMS.register("gelatin", ItemBase::new);
    public static final RegistryObject<Item> MOLASSES = ITEMS.register("molasses", ItemBase::new);

    //RECORDS
    public static final RegistryObject<ItemRecord> DISC_DECK_THE_HALLS = ITEMS.register("disc_deck_the_halls", () -> new ItemRecord(12, NoelSounds.LAZY_DECK_THE_HALLS_MUSIC));
    public static final RegistryObject<ItemRecord> DISC_JINGLE_BELLS = ITEMS.register("disc_jingle_bells", () -> new ItemRecord(12, NoelSounds.LAZY_JINGLE_BELLS_MUSIC));
    public static final RegistryObject<ItemRecord> DISC_OH_CHRISTMAS_TREE= ITEMS.register("disc_oh_christmas_tree", () -> new ItemRecord(12, NoelSounds.LAZY_OH_CHRISTMAS_TREE_MUSIC));
    public static final RegistryObject<ItemRecord> DISC_SUGAR_PLUM_FAIRIES = ITEMS.register("disc_sugar_plum_fairies", () -> new ItemRecord(12, NoelSounds.LAZY_SUGAR_PLUM_FAIRIES_MUSIC));
    public static final RegistryObject<ItemRecord> DISC_UP_ON_A_HOUSETOP = ITEMS.register("disc_up_on_a_housetop", () -> new ItemRecord(12, NoelSounds.LAZY_UP_ON_A_HOUSETOP_MUSIC));
    public static final RegistryObject<ItemRecord> DISC_WE_WISH_YOU = ITEMS.register("disc_we_wish_you", () -> new ItemRecord(12, NoelSounds.LAZY_WE_WISH_YOU_MUSIC));

    //Spawn Eggs
    //public static final RegistryObject<SpawnEggItem> ELF_SPAWN_EGG = ITEMS.register("elf_spawn_egg", () -> new SpawnEggItem(NoelEntityTypes.ELF.get(), 0x84D52F, 0xF33939, new Item.Properties().group(ItemGroup.MISC)));
    //public static final RegistryObject<SpawnEggItem> SUGAR_PLUM_FAIRY_SPAWN_EGG = ITEMS.register("sugar_plum_spawn_egg", () -> new SpawnEggItem(NoelEntityTypes.SUGAR_PLUM_FAIRY.get(), 0x852776, 0xEFD0EA, new Item.Properties().group(ItemGroup.MISC)));

    //Food
    public static final RegistryObject<ItemHotChocolate> HOT_CHOCHOLATE = ITEMS.register("hot_chocolate", ItemHotChocolate::new);
    public static final RegistryObject<ItemCandyCane> CANDY_CANE = ITEMS.register("candy_cane", ItemCandyCane::new);
    public static final RegistryObject<ItemWarmMilk> WARM_MILK = ITEMS.register("warm_milk", ItemWarmMilk::new);
    public static final RegistryObject<ItemWarmMilk> MUG_MILK = ITEMS.register("mug_milk", ItemWarmMilk::new);
    public static final RegistryObject<ItemPeppermintCandy> PEPPERMINT_CANDY = ITEMS.register("peppermint_candy", ItemPeppermintCandy::new);
    public static final RegistryObject<ItemSugarPlum> SUGAR_PLUM = ITEMS.register("sugar_plum", ItemSugarPlum::new);
    public static final RegistryObject<ItemGingerBreadCookie> GINGER_BREAD_COOKIE = ITEMS.register("ginger_bread_cookie", ItemGingerBreadCookie::new);

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
    public static final RegistryObject<Item> SHRUB_TREE_ITEM = ITEMS.register("shrub_tree", () -> new BlockItemBase(NoelBlocks.SHRUB_TREE.get()));
    public static final RegistryObject<Item> POINSETTIA_ITEM = ITEMS.register("poinsettia", () -> new BlockItemBase(NoelBlocks.POINSETTIA.get()));
    public static final RegistryObject<Item> MISTLETOE_ITEM = ITEMS.register("mistletoe", () -> new BlockItemBase(NoelBlocks.MISTLETOE.get()));
    public static final RegistryObject<Item> GINGER_BREAD_BLOCK_ITEM = ITEMS.register("ginger_bread_block", () -> new BlockItemBase(NoelBlocks.GINGER_BREAD_BLOCK.get()));
    public static final RegistryObject<Item> GINGER_BREAD_SLAB_ITEM = ITEMS.register("ginger_bread_slab", () -> new BlockItemBase(NoelBlocks.GINGER_BREAD_SLAB.get()));
    public static final RegistryObject<Item> GINGER_BREAD_STAIRS_ITEM = ITEMS.register("ginger_bread_stairs", () -> new BlockItemBase(NoelBlocks.GINGER_BREAD_STAIRS.get()));
    public static final RegistryObject<Item> GINGER_BREAD_DOOR_ITEM = ITEMS.register("ginger_bread_door", () -> new BlockItemBase(NoelBlocks.GINGER_BREAD_DOOR.get()));
    public static final RegistryObject<Item> GINGER_BREAD_WALL_ITEM = ITEMS.register("ginger_bread_wall", () -> new BlockItemBase(NoelBlocks.GINGER_BREAD_WALL.get()));

    public static final RegistryObject<Item> RED_GUMDROP_ITEM = ITEMS.register("red_gumdrop", () -> new BlockItemBase(NoelBlocks.RED_GUMDROP.get()));
    public static final RegistryObject<Item> ORANGE_GUMDROP_ITEM = ITEMS.register("orange_gumdrop", () -> new BlockItemBase(NoelBlocks.ORANGE_GUMDROP.get()));
    public static final RegistryObject<Item> YELLOW_GUMDROP_ITEM = ITEMS.register("yellow_gumdrop", () -> new BlockItemBase(NoelBlocks.YELLOW_GUMDROP.get()));
    public static final RegistryObject<Item> GREEN_GUMDROP_ITEM = ITEMS.register("green_gumdrop", () -> new BlockItemBase(NoelBlocks.GREEN_GUMDROP.get()));
    public static final RegistryObject<Item> BLUE_GUMDROP_ITEM = ITEMS.register("blue_gumdrop", () -> new BlockItemBase(NoelBlocks.BLUE_GUMDROP.get()));
    public static final RegistryObject<Item> PURPLE_GUMDROP_ITEM = ITEMS.register("purple_gumdrop", () -> new BlockItemBase(NoelBlocks.PURPLE_GUMDROP.get()));
    //public static final RegistryObject<Item> LIGHT_STRING_ITEM = ITEMS.register("light_string", () -> new BlockItemBase(NoelBlocks.LIGHT_STRING.get()));

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

    //Donation Booth Block Items
    public static final RegistryObject<Item> BLACK_DONATION_BOOTH_ITEM = ITEMS.register("black_donation_booth", () -> new BlockItemBase(NoelBlocks.BLACK_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> BLUE_DONATION_BOOTH_ITEM = ITEMS.register("blue_donation_booth", () -> new BlockItemBase(NoelBlocks.BLUE_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> BROWN_DONATION_BOOTH_ITEM = ITEMS.register("brown_donation_booth", () -> new BlockItemBase(NoelBlocks.BROWN_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> CYAN_DONATION_BOOTH_ITEM = ITEMS.register("cyan_donation_booth", () -> new BlockItemBase(NoelBlocks.CYAN_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> GRAY_DONATION_BOOTH_ITEM = ITEMS.register("gray_donation_booth", () -> new BlockItemBase(NoelBlocks.GRAY_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> GREEN_DONATION_BOOTH_ITEM = ITEMS.register("green_donation_booth", () -> new BlockItemBase(NoelBlocks.GREEN_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_DONATION_BOOTH_ITEM = ITEMS.register("light_blue_donation_booth", () -> new BlockItemBase(NoelBlocks.LIGHT_BLUE_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> LIME_DONATION_BOOTH_ITEM = ITEMS.register("lime_donation_booth", () -> new BlockItemBase(NoelBlocks.LIME_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> MAGENTA_DONATION_BOOTH_ITEM = ITEMS.register("magenta_donation_booth", () -> new BlockItemBase(NoelBlocks.MAGENTA_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> ORANGE_DONATION_BOOTH_ITEM = ITEMS.register("orange_donation_booth", () -> new BlockItemBase(NoelBlocks.ORANGE_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> PINK_DONATION_BOOTH_ITEM = ITEMS.register("pink_donation_booth", () -> new BlockItemBase(NoelBlocks.PINK_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> PURPLE_DONATION_BOOTH_ITEM = ITEMS.register("purple_donation_booth", () -> new BlockItemBase(NoelBlocks.PURPLE_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> RED_DONATION_BOOTH_ITEM = ITEMS.register("red_donation_booth", () -> new BlockItemBase(NoelBlocks.RED_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> LIGHT_GRAY_DONATION_BOOTH_ITEM = ITEMS.register("light_gray_donation_booth", () -> new BlockItemBase(NoelBlocks.LIGHT_GRAY_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> WHITE_DONATION_BOOTH_ITEM = ITEMS.register("white_donation_booth", () -> new BlockItemBase(NoelBlocks.WHITE_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> YELLOW_DONATION_BOOTH_ITEM = ITEMS.register("yellow_donation_booth", () -> new BlockItemBase(NoelBlocks.YELLOW_DONATION_BOOTH.get()));
    public static final RegistryObject<Item> PEPPERMINT_DONATION_BOOTH_ITEM = ITEMS.register("peppermint_donation_booth", () -> new BlockItemBase(NoelBlocks.PEPPERMINT_DONATION_BOOTH.get()));

    //Ribbon Block Items
    public static final RegistryObject<Item> BLACK_RIBBON_ITEM = ITEMS.register("black_ribbon", () -> new BlockItemBase(NoelBlocks.BLACK_RIBBON.get()));
    public static final RegistryObject<Item> BLUE_RIBBON_ITEM = ITEMS.register("blue_ribbon", () -> new BlockItemBase(NoelBlocks.BLUE_RIBBON.get()));
    public static final RegistryObject<Item> BROWN_RIBBON_ITEM = ITEMS.register("brown_ribbon", () -> new BlockItemBase(NoelBlocks.BROWN_RIBBON.get()));
    public static final RegistryObject<Item> CYAN_RIBBON_ITEM = ITEMS.register("cyan_ribbon", () -> new BlockItemBase(NoelBlocks.CYAN_RIBBON.get()));
    public static final RegistryObject<Item> GRAY_RIBBON_ITEM = ITEMS.register("gray_ribbon", () -> new BlockItemBase(NoelBlocks.GRAY_RIBBON.get()));
    public static final RegistryObject<Item> GREEN_RIBBON_ITEM = ITEMS.register("green_ribbon", () -> new BlockItemBase(NoelBlocks.GREEN_RIBBON.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_RIBBON_ITEM = ITEMS.register("light_blue_ribbon", () -> new BlockItemBase(NoelBlocks.LIGHT_BLUE_RIBBON.get()));
    public static final RegistryObject<Item> LIME_RIBBON_ITEM = ITEMS.register("lime_ribbon", () -> new BlockItemBase(NoelBlocks.LIME_RIBBON.get()));
    public static final RegistryObject<Item> MAGENTA_RIBBON_ITEM = ITEMS.register("magenta_ribbon", () -> new BlockItemBase(NoelBlocks.MAGENTA_RIBBON.get()));
    public static final RegistryObject<Item> ORANGE_RIBBON_ITEM = ITEMS.register("orange_ribbon", () -> new BlockItemBase(NoelBlocks.ORANGE_RIBBON.get()));
    public static final RegistryObject<Item> PINK_RIBBON_ITEM = ITEMS.register("pink_ribbon", () -> new BlockItemBase(NoelBlocks.PINK_RIBBON.get()));
    public static final RegistryObject<Item> PURPLE_RIBBON_ITEM = ITEMS.register("purple_ribbon", () -> new BlockItemBase(NoelBlocks.PURPLE_RIBBON.get()));
    public static final RegistryObject<Item> RED_RIBBON_ITEM = ITEMS.register("red_ribbon", () -> new BlockItemBase(NoelBlocks.RED_RIBBON.get()));
    public static final RegistryObject<Item> LIGHT_GRAY_RIBBON_ITEM = ITEMS.register("light_gray_ribbon", () -> new BlockItemBase(NoelBlocks.LIGHT_GRAY_RIBBON.get()));
    public static final RegistryObject<Item> WHITE_RIBBON_ITEM = ITEMS.register("white_ribbon", () -> new BlockItemBase(NoelBlocks.WHITE_RIBBON.get()));
    public static final RegistryObject<Item> YELLOW_RIBBON_ITEM = ITEMS.register("yellow_ribbon", () -> new BlockItemBase(NoelBlocks.YELLOW_RIBBON.get()));

}
