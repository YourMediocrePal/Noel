package mod.yourmediocrepal.noel.registry;

import mod.yourmediocrepal.noel.NoelMod;
import mod.yourmediocrepal.noel.block.*;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import org.spongepowered.tools.agent.MixinAgent;

public class BlockRegistry {

    public static final Block ADVENT_CALENDAR = new BlockAdventCalendar(FabricBlockSettings.of(Material.DECORATION).strength(0.2f).nonOpaque().noCollision().breakInstantly());
    public static final Block GLOWSTONE_STAR = new BlockStar(FabricBlockSettings.of(Material.GLASS).strength(1.0f).lightLevel(12).nonOpaque());
    public static final Block GOLD_STAR = new BlockStar(FabricBlockSettings.of(Material.GLASS).strength(1.0f).lightLevel(12).nonOpaque());
    public static final Block KETTLE = new BlockKettle(FabricBlockSettings.of(Material.METAL).strength(2.0f).nonOpaque().ticksRandomly());
    public static final Block SPIRIT_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    //GET RID OF public static final Block STONE_PATH = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block PRESENT = new BlockPresent(FabricBlockSettings.of(Material.DECORATION).strength(0.5f).nonOpaque(), false);
    public static final Block PRESENT_TRAP = new BlockPresent(FabricBlockSettings.of(Material.DECORATION).strength(0.5f).nonOpaque(), true);
    public static final Block WREATH = new BlockWreath(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).nonOpaque().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block SHRUB_TREE = new BlockShrubTree(FabricBlockSettings.of(Material.METAL).strength(4.0f).nonOpaque());
    public static final Block POINSETTIA = new BlockFlower(StatusEffects.POISON, 6, FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block POTTED_POINSETTIA = new BlockFlowerPot(POINSETTIA, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque());
    public static final Block MISTLETOE = new BlockMistletoe(FabricBlockSettings.of(Material.PLANT).strength(0.2f).nonOpaque());
    
    public static final Block GINGER_BREAD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block GINGER_BREAD_STAIRS = new BlockStairs(GINGER_BREAD_BLOCK.getDefaultState(), FabricBlockSettings.copy(GINGER_BREAD_BLOCK));
    public static final Block GINGER_BREAD_SLAB = new BlockSlab(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block GINGER_BREAD_DOOR = new BlockDoor(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block GINGER_BREAD_WALL = new WallBlock(FabricBlockSettings.copy(GINGER_BREAD_BLOCK));

    public static final Block FROSTED_LOG = new BlockPillar(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block FROSTED_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block FROSTED_TRAPDOOR = new BlockTrapdoor(FabricBlockSettings.of(Material.WOOD).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block FROSTED_SLAB = new BlockSlab(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block FROSTED_STAIRS = new BlockStairs(GINGER_BREAD_BLOCK.getDefaultState(), FabricBlockSettings.copy(GINGER_BREAD_BLOCK));
    public static final Block FROSTED_DOOR = new BlockDoor(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block FROSTED_FENCE = new BlockFence(FabricBlockSettings.of(Material.WOOD, FROSTED_PLANKS.getDefaultMapColor()).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block FROSTED_FENCE_GATE = new BlockFenceGate(FabricBlockSettings.of(Material.WOOD, FROSTED_PLANKS.getDefaultMapColor()).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block FROSTED_BUTTON = new BlockButton(FabricBlockSettings.of(Material.WOOD).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD));
    public static final Block FROSTED_PRESSURE_PLATE = new BlockPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.WOOD).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD));

    public static final Block PEPPERMINT_LOG = new BlockPillar(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.WHITE_GRAY).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_TRAPDOOR = new BlockTrapdoor(FabricBlockSettings.of(Material.WOOD).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block PEPPERMINT_SLAB = new BlockSlab(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_STAIRS = new BlockStairs(GINGER_BREAD_BLOCK.getDefaultState(), FabricBlockSettings.copy(GINGER_BREAD_BLOCK));
    public static final Block PEPPERMINT_DOOR = new BlockDoor(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block PEPPERMINT_FENCE = new BlockFence(FabricBlockSettings.of(Material.WOOD, FROSTED_PLANKS.getDefaultMapColor()).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_FENCE_GATE = new BlockFenceGate(FabricBlockSettings.of(Material.WOOD, FROSTED_PLANKS.getDefaultMapColor()).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_BUTTON = new BlockButton(FabricBlockSettings.of(Material.WOOD).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_PRESSURE_PLATE = new BlockPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.WOOD).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD));
    public static final Block PEPPERMINT_WALL = new WallBlock(FabricBlockSettings.copy(PEPPERMINT_LOG));

    public static final Block RED_GUMDROP = new BlockGumdrop(FabricBlockSettings.of(Material.DECORATION).strength(0.3f).sounds(BlockSoundGroup.SHROOMLIGHT));
    public static final Block ORANGE_GUMDROP = new BlockGumdrop(FabricBlockSettings.copy(RED_GUMDROP));
    public static final Block YELLOW_GUMDROP = new BlockGumdrop(FabricBlockSettings.copy(RED_GUMDROP));
    public static final Block GREEN_GUMDROP = new BlockGumdrop(FabricBlockSettings.copy(RED_GUMDROP));
    public static final Block BLUE_GUMDROP = new BlockGumdrop(FabricBlockSettings.copy(RED_GUMDROP));
    public static final Block PURPLE_GUMDROP = new BlockGumdrop(FabricBlockSettings.copy(RED_GUMDROP));

    public static final Block BLACK_ORNAMENT = new BlockOrnament(FabricBlockSettings.of(Material.GLASS).strength(0.3f).nonOpaque().sounds(BlockSoundGroup.GLASS));
    public static final Block BLUE_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block BROWN_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block CYAN_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block GRAY_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block GREEN_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block LIGHT_BLUE_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block LIME_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block MAGENTA_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block ORANGE_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block PINK_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block PURPLE_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block RED_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block LIGHT_GRAY_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block WHITE_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block YELLOW_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block DIAMOND_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block EMERALD_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block GLASS_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block GOLD_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block IRON_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block REDSTONE_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block LAPIS_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));
    public static final Block COAL_ORNAMENT = new BlockOrnament(FabricBlockSettings.copy(BLACK_ORNAMENT));

    public static final Block BLACK_STOCKING = new BlockStocking(FabricBlockSettings.of(Material.WOOL).strength(0.2f).sounds(BlockSoundGroup.WOOL));
    public static final Block BLUE_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block BROWN_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block CYAN_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block GRAY_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block GREEN_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block LIGHT_BLUE_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block LIME_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block MAGENTA_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block ORANGE_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block PINK_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block PURPLE_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block RED_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block LIGHT_GRAY_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block WHITE_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));
    public static final Block YELLOW_STOCKING = new BlockStocking(FabricBlockSettings.copy(BLACK_STOCKING));

    public static final Block BLACK_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.of(Material.METAL).strength(1.25f,6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block BLUE_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block BROWN_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block CYAN_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block GRAY_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block GREEN_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block LIGHT_BLUE_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block LIME_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block MAGENTA_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block ORANGE_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block PINK_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block PURPLE_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block RED_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block LIGHT_GRAY_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block WHITE_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block YELLOW_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH));
    public static final Block PEPPERMINT_DONATION_BOOTH = new BlockDonationBooth(FabricBlockSettings.copy(BLACK_DONATION_BOOTH).sounds(BlockSoundGroup.WOOD));

    public static final Block BLACK_RIBBON = new BlockRibbon(FabricBlockSettings.of(Material.WOOL).strength(0.2f).sounds(BlockSoundGroup.WOOL));
    public static final Block BLUE_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block BROWN_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block CYAN_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block GRAY_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block GREEN_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block LIGHT_BLUE_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block LIME_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block MAGENTA_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block ORANGE_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block PINK_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block PURPLE_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block RED_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block LIGHT_GRAY_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block WHITE_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    public static final Block YELLOW_RIBBON = new BlockRibbon(FabricBlockSettings.copy(BLACK_RIBBON));
    
    public static void init() {

        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("noel", "advent_calendar"), ADVENT_CALENDAR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "glowstone_star"), GLOWSTONE_STAR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "gold_star"), GOLD_STAR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "kettle"), KETTLE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "spirit_ore"), SPIRIT_ORE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "present"), PRESENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "present_trap"), PRESENT_TRAP);
        Registry.register(Registry.BLOCK, new Identifier("noel", "wreath"), WREATH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "shrub_tree"), SHRUB_TREE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "poinsettia"), POINSETTIA);
        Registry.register(Registry.BLOCK, new Identifier("noel", "potted_poinsettia"), POTTED_POINSETTIA);
        Registry.register(Registry.BLOCK, new Identifier("noel", "mistletoe"), MISTLETOE);

        Registry.register(Registry.BLOCK, new Identifier("noel", "ginger_bread_block"), GINGER_BREAD_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("noel", "ginger_bread_stairs"), GINGER_BREAD_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("noel", "ginger_bread_slab"), GINGER_BREAD_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("noel", "ginger_bread_door"), GINGER_BREAD_DOOR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "ginger_bread_wall"), GINGER_BREAD_WALL);

        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_log"), FROSTED_LOG);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_planks"), FROSTED_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_trapdoor"), FROSTED_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_slab"), FROSTED_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_stairs"), FROSTED_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_door"), FROSTED_DOOR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_fence"), FROSTED_FENCE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_fence_gate"), FROSTED_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_button"), FROSTED_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "frosted_pressure_plate"), FROSTED_PRESSURE_PLATE);

        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_log"), PEPPERMINT_LOG);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_planks"), PEPPERMINT_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_trapdoor"), PEPPERMINT_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_slab"), PEPPERMINT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_stairs"), PEPPERMINT_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_door"), PEPPERMINT_DOOR);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_fence"), PEPPERMINT_FENCE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_fence_gate"), PEPPERMINT_FENCE_GATE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_button"), PEPPERMINT_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_pressure_plate"), PEPPERMINT_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_wall"), PEPPERMINT_WALL);

        Registry.register(Registry.BLOCK, new Identifier("noel", "red_gumdrop"), RED_GUMDROP);
        Registry.register(Registry.BLOCK, new Identifier("noel", "orange_gumdrop"), ORANGE_GUMDROP);
        Registry.register(Registry.BLOCK, new Identifier("noel", "yellow_gumdrop"), YELLOW_GUMDROP);
        Registry.register(Registry.BLOCK, new Identifier("noel", "green_gumdrop"), GREEN_GUMDROP);
        Registry.register(Registry.BLOCK, new Identifier("noel", "blue_gumdrop"), BLUE_GUMDROP);
        Registry.register(Registry.BLOCK, new Identifier("noel", "purple_gumdrop"), PURPLE_GUMDROP);
        
        Registry.register(Registry.BLOCK, new Identifier("noel", "black_ornament"), BLACK_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "blue_ornament"), BLUE_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "brown_ornament"), BROWN_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "cyan_ornament"), CYAN_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "gray_ornament"), GRAY_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "green_ornament"), GREEN_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_blue_ornament"), LIGHT_BLUE_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_gray_ornament"), LIGHT_GRAY_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "lime_ornament"), LIME_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "magenta_ornament"), MAGENTA_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "orange_ornament"), ORANGE_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "pink_ornament"), PINK_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "purple_ornament"), PURPLE_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "red_ornament"), RED_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "white_ornament"), WHITE_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "yellow_ornament"), YELLOW_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "diamond_ornament"), DIAMOND_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "emerald_ornament"), EMERALD_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "glass_ornament"), GLASS_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "gold_ornament"), GOLD_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "iron_ornament"), IRON_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "redstone_ornament"), REDSTONE_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "lapis_ornament"), LAPIS_ORNAMENT);
        Registry.register(Registry.BLOCK, new Identifier("noel", "coal_ornament"), COAL_ORNAMENT);

        Registry.register(Registry.BLOCK, new Identifier("noel", "black_stocking"), BLACK_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "blue_stocking"), BLUE_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "brown_stocking"), BROWN_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "cyan_stocking"), CYAN_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "gray_stocking"), GRAY_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "green_stocking"), GREEN_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_blue_stocking"), LIGHT_BLUE_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_gray_stocking"), LIGHT_GRAY_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "lime_stocking"), LIME_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "magenta_stocking"), MAGENTA_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "orange_stocking"), ORANGE_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "pink_stocking"), PINK_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "purple_stocking"), PURPLE_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "red_stocking"), RED_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "white_stocking"), WHITE_STOCKING);
        Registry.register(Registry.BLOCK, new Identifier("noel", "yellow_stocking"), YELLOW_STOCKING);

        Registry.register(Registry.BLOCK, new Identifier("noel", "black_donation_booth"), BLACK_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "blue_donation_booth"), BLUE_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "brown_donation_booth"), BROWN_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "cyan_donation_booth"), CYAN_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "gray_donation_booth"), GRAY_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "green_donation_booth"), GREEN_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_blue_donation_booth"), LIGHT_BLUE_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_gray_donation_booth"), LIGHT_GRAY_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "lime_donation_booth"), LIME_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "magenta_donation_booth"), MAGENTA_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "orange_donation_booth"), ORANGE_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "pink_donation_booth"), PINK_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "purple_donation_booth"), PURPLE_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "red_donation_booth"), RED_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "white_donation_booth"), WHITE_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "yellow_donation_booth"), YELLOW_DONATION_BOOTH);
        Registry.register(Registry.BLOCK, new Identifier("noel", "peppermint_donation_booth"), PEPPERMINT_DONATION_BOOTH);

        Registry.register(Registry.BLOCK, new Identifier("noel", "black_ribbon"), BLACK_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "blue_ribbon"), BLUE_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "brown_ribbon"), BROWN_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "cyan_ribbon"), CYAN_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "gray_ribbon"), GRAY_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "green_ribbon"), GREEN_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_blue_ribbon"), LIGHT_BLUE_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "light_gray_ribbon"), LIGHT_GRAY_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "lime_ribbon"), LIME_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "magenta_ribbon"), MAGENTA_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "orange_ribbon"), ORANGE_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "pink_ribbon"), PINK_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "purple_ribbon"), PURPLE_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "red_ribbon"), RED_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "white_ribbon"), WHITE_RIBBON);
        Registry.register(Registry.BLOCK, new Identifier("noel", "yellow_ribbon"), YELLOW_RIBBON);


        /*
               ###  Block Item  ###
        */

        Registry.register(Registry.ITEM, new Identifier("noel", "advent_calendar"), new BlockItem(ADVENT_CALENDAR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "glowstone_star"), new BlockItem(GLOWSTONE_STAR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "gold_star"), new BlockItem(GOLD_STAR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "kettle"), new BlockItem(KETTLE, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "spirit_ore"), new BlockItem(SPIRIT_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "present"), new BlockItem(PRESENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "present_trap"), new BlockItem(PRESENT_TRAP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "wreath"), new BlockItem(WREATH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "shrub_tree"), new BlockItem(SHRUB_TREE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "poinsettia"), new BlockItem(POINSETTIA, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "mistletoe"), new BlockItem(MISTLETOE, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "ginger_bread_block"), new BlockItem(GINGER_BREAD_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "ginger_bread_stairs"), new BlockItem(GINGER_BREAD_STAIRS, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "ginger_bread_slab"), new BlockItem(GINGER_BREAD_SLAB, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "ginger_bread_door"), new BlockItem(GINGER_BREAD_DOOR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "ginger_bread_wall"), new BlockItem(GINGER_BREAD_WALL, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_log"), new BlockItem(FROSTED_LOG, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_planks"), new BlockItem(FROSTED_PLANKS, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_trapdoor"), new BlockItem(FROSTED_TRAPDOOR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_slab"), new BlockItem(FROSTED_SLAB, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_stairs"), new BlockItem(FROSTED_STAIRS, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_door"), new BlockItem(FROSTED_DOOR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_fence"), new BlockItem(FROSTED_FENCE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_fence_gate"), new BlockItem(FROSTED_FENCE_GATE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_button"), new BlockItem(FROSTED_BUTTON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "frosted_pressure_plate"), new BlockItem(FROSTED_PRESSURE_PLATE, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_log"), new BlockItem(PEPPERMINT_LOG, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_planks"), new BlockItem(PEPPERMINT_PLANKS, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_trapdoor"), new BlockItem(PEPPERMINT_TRAPDOOR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_slab"), new BlockItem(PEPPERMINT_SLAB, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_stairs"), new BlockItem(PEPPERMINT_STAIRS, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_door"), new BlockItem(PEPPERMINT_DOOR, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_fence"), new BlockItem(PEPPERMINT_FENCE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_fence_gate"), new BlockItem(PEPPERMINT_FENCE_GATE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_button"), new BlockItem(PEPPERMINT_BUTTON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_pressure_plate"), new BlockItem(PEPPERMINT_PRESSURE_PLATE, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_wall"), new BlockItem(PEPPERMINT_WALL, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "red_gumdrop"), new BlockItem(RED_GUMDROP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "orange_gumdrop"), new BlockItem(ORANGE_GUMDROP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "yellow_gumdrop"), new BlockItem(YELLOW_GUMDROP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "green_gumdrop"), new BlockItem(GREEN_GUMDROP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "blue_gumdrop"), new BlockItem(BLUE_GUMDROP, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "purple_gumdrop"), new BlockItem(PURPLE_GUMDROP, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "black_ornament"), new BlockItem(BLACK_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "blue_ornament"), new BlockItem(BLUE_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "brown_ornament"), new BlockItem(BROWN_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "cyan_ornament"), new BlockItem(CYAN_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "gray_ornament"), new BlockItem(GRAY_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "green_ornament"), new BlockItem(GREEN_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_blue_ornament"), new BlockItem(LIGHT_BLUE_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_gray_ornament"), new BlockItem(LIGHT_GRAY_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "lime_ornament"), new BlockItem(LIME_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "magenta_ornament"), new BlockItem(MAGENTA_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "orange_ornament"), new BlockItem(ORANGE_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "pink_ornament"), new BlockItem(PINK_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "purple_ornament"), new BlockItem(PURPLE_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "red_ornament"), new BlockItem(RED_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "white_ornament"), new BlockItem(WHITE_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "yellow_ornament"), new BlockItem(YELLOW_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "diamond_ornament"), new BlockItem(DIAMOND_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "emerald_ornament"), new BlockItem(EMERALD_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "glass_ornament"), new BlockItem(GLASS_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "gold_ornament"), new BlockItem(GOLD_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "iron_ornament"), new BlockItem(IRON_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "redstone_ornament"), new BlockItem(REDSTONE_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "lapis_ornament"), new BlockItem(LAPIS_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "coal_ornament"), new BlockItem(COAL_ORNAMENT, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "black_stocking"), new BlockItem(BLACK_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "blue_stocking"), new BlockItem(BLUE_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "brown_stocking"), new BlockItem(BROWN_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "cyan_stocking"), new BlockItem(CYAN_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "gray_stocking"), new BlockItem(GRAY_STOCKING , new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "green_stocking"), new BlockItem(GREEN_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_blue_stocking"), new BlockItem(LIGHT_BLUE_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_gray_stocking"), new BlockItem(LIGHT_GRAY_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "lime_stocking"), new BlockItem(LIME_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "magenta_stocking"), new BlockItem(MAGENTA_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "orange_stocking"), new BlockItem(ORANGE_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "pink_stocking"), new BlockItem(PINK_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "purple_stocking"), new BlockItem(PURPLE_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "red_stocking"), new BlockItem(RED_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "white_stocking"), new BlockItem(WHITE_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "yellow_stocking"), new BlockItem(YELLOW_STOCKING, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "black_donation_booth"), new BlockItem(BLACK_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "blue_donation_booth"), new BlockItem(BLUE_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "brown_donation_booth"), new BlockItem(BROWN_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "cyan_donation_booth"), new BlockItem(CYAN_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "gray_donation_booth"), new BlockItem(GRAY_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "green_donation_booth"), new BlockItem(GREEN_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_blue_donation_booth"), new BlockItem(LIGHT_BLUE_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_gray_donation_booth"), new BlockItem(LIGHT_GRAY_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "lime_donation_booth"), new BlockItem(LIME_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "magenta_donation_booth"), new BlockItem(MAGENTA_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "orange_donation_booth"), new BlockItem(ORANGE_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "pink_donation_booth"), new BlockItem(PINK_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "purple_donation_booth"), new BlockItem(PURPLE_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "red_donation_booth"), new BlockItem(RED_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "white_donation_booth"), new BlockItem(WHITE_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "yellow_donation_booth"), new BlockItem(YELLOW_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "peppermint_donation_booth"), new BlockItem(PEPPERMINT_DONATION_BOOTH, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.ITEM, new Identifier("noel", "black_ribbon"), new BlockItem(BLACK_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "blue_ribbon"), new BlockItem(BLUE_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "brown_ribbon"), new BlockItem(BROWN_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "cyan_ribbon"), new BlockItem(CYAN_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "gray_ribbon"), new BlockItem(GRAY_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "green_ribbon"), new BlockItem(GREEN_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_blue_ribbon"), new BlockItem(LIGHT_BLUE_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "light_gray_ribbon"), new BlockItem(LIGHT_GRAY_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "lime_ribbon"), new BlockItem(LIME_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "magenta_ribbon"), new BlockItem(MAGENTA_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "orange_ribbon"), new BlockItem(ORANGE_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "pink_ribbon"), new BlockItem(PINK_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "purple_ribbon"), new BlockItem(PURPLE_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "red_ribbon"), new BlockItem(RED_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "white_ribbon"), new BlockItem(WHITE_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.ITEM, new Identifier("noel", "yellow_ribbon"), new BlockItem(YELLOW_RIBBON, new FabricItemSettings().group(ItemGroup.MISC)));

    }

    public static void blockRender() {
        BlockRenderLayerMap.INSTANCE.putBlock(FROSTED_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FROSTED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PEPPERMINT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FROSTED_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SHRUB_TREE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(WREATH, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(POINSETTIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(POTTED_POINSETTIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MISTLETOE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(YELLOW_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(LIGHT_GRAY_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RED_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(PURPLE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(PINK_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ORANGE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(MAGENTA_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(LIME_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(LIGHT_BLUE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(GREEN_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(GRAY_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CYAN_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BROWN_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BLACK_ORNAMENT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(GLASS_ORNAMENT, RenderLayer.getTranslucent());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor(), WREATH);
    }
}
