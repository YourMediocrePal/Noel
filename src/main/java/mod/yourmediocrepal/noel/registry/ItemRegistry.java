package mod.yourmediocrepal.noel.registry;

import mod.yourmediocrepal.noel.item.NoelArmorMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    //ITEM
    public static final Item BELL_RINGER = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item GELATIN = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item MOLASSES = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item MUG = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item SPIRIT = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    //FOOD
    public static final Item HOT_CHOCOLATE = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item CANDY_CANE = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item WARM_MILK = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item MUG_MILK = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item PEPPERMINT_CANDY = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item SUGAR_PLUM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item GINGER_BREAD_COOKIE = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    //DISC
    public static final Item DISC_DECK_THE_HALLS = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DISC_JINGLE_BELLS = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DISC_OH_CHRISTMAS_TREE = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DISC_SUGAR_PLUM_FAIRIES = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DISC_UP_ON_A_HOUSETOP = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item DISC_WE_WISH_YOU = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    //ARMOR
    public static final Item SANTA_HELMET = (Item)(new ArmorItem(NoelArmorMaterial.SANTA, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item SANTA_CHESTPLATE = (Item)(new ArmorItem(NoelArmorMaterial.SANTA, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item SANTA_LEGGINGS = (Item)(new ArmorItem(NoelArmorMaterial.SANTA, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item SANTA_BOOTS = (Item)(new ArmorItem(NoelArmorMaterial.SANTA, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item PEPPERMINT_HELMET = (Item)(new ArmorItem(NoelArmorMaterial.PEPPERMINT, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item PEPPERMINT_CHESTPLATE = (Item)(new ArmorItem(NoelArmorMaterial.PEPPERMINT, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item PEPPERMINT_LEGGINGS = (Item)(new ArmorItem(NoelArmorMaterial.PEPPERMINT, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item PEPPERMINT_BOOTS = (Item)(new ArmorItem(NoelArmorMaterial.PEPPERMINT, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT)));


    public static void init() {

        //ITEM
        Registry.register(Registry.ITEM, new Identifier("noel", "bell_ringer"), BELL_RINGER);
        Registry.register(Registry.ITEM, new Identifier("noel", "gelatin"), GELATIN);
        Registry.register(Registry.ITEM, new Identifier("noel", "molasses"), MOLASSES);
        Registry.register(Registry.ITEM, new Identifier("noel", "mug"), MUG);
        Registry.register(Registry.ITEM, new Identifier("noel", "spirit"), SPIRIT);

        //FOOD
        Registry.register(Registry.ITEM, new Identifier("noel", "hot_chocolate"), HOT_CHOCOLATE);
        Registry.register(Registry.ITEM, new Identifier("noel", "candy_cane"), CANDY_CANE);
        Registry.register(Registry.ITEM, new Identifier("noel", "warm_milk"), WARM_MILK);
        Registry.register(Registry.ITEM, new Identifier("noel", "mug_milk"), MUG_MILK);
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_candy"), PEPPERMINT_CANDY);
        Registry.register(Registry.ITEM, new Identifier("noel", "sugar_plum"), SUGAR_PLUM);
        Registry.register(Registry.ITEM, new Identifier("noel", "ginger_bread_cookie"), GINGER_BREAD_COOKIE);

        //DISC
        Registry.register(Registry.ITEM, new Identifier("noel", "disc_deck_the_halls"), DISC_DECK_THE_HALLS);
        Registry.register(Registry.ITEM, new Identifier("noel", "disc_jingle_bells"), DISC_JINGLE_BELLS);
        Registry.register(Registry.ITEM, new Identifier("noel", "disc_oh_christmas_tree"), DISC_OH_CHRISTMAS_TREE);
        Registry.register(Registry.ITEM, new Identifier("noel", "disc_sugar_plum_fairies"), DISC_SUGAR_PLUM_FAIRIES);
        Registry.register(Registry.ITEM, new Identifier("noel", "disc_up_on_a_housetop"), DISC_UP_ON_A_HOUSETOP);
        Registry.register(Registry.ITEM, new Identifier("noel", "disc_we_wish_you"), DISC_WE_WISH_YOU);

        //ARMOR
        Registry.register(Registry.ITEM, new Identifier("noel", "santa_helmet"), SANTA_HELMET);
        Registry.register(Registry.ITEM, new Identifier("noel", "santa_chestplate"), SANTA_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("noel", "santa_leggings"), SANTA_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("noel", "santa_boots"), SANTA_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_helmet"), PEPPERMINT_HELMET);
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_chestplate"), PEPPERMINT_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_leggings"), PEPPERMINT_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_boots"), PEPPERMINT_BOOTS);

    }

}
