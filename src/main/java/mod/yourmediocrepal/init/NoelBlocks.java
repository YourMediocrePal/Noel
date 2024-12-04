package mod.yourmediocrepal.init;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import mod.yourmediocrepal.Noel;
import mod.yourmediocrepal.block.*;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class NoelBlocks {

    public static void initialize() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_ORNAMENT, EXPOSED_COPPER_ORNAMENT);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_ORNAMENT, WEATHERED_COPPER_ORNAMENT);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_ORNAMENT, OXIDIZED_COPPER_ORNAMENT);

        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_ORNAMENT, WAXED_COPPER_ORNAMENT);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_ORNAMENT, WAXED_EXPOSED_COPPER_ORNAMENT);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_ORNAMENT, WAXED_WEATHERED_COPPER_ORNAMENT);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_ORNAMENT, WAXED_OXIDIZED_COPPER_ORNAMENT);

        StrippableBlockRegistry.register(FROSTED_LOG, STRIPPED_FROSTED_LOG);
        StrippableBlockRegistry.register(FROSTED_WOOD, STRIPPED_FROSTED_WOOD);

        CompostingChanceRegistry.INSTANCE.add(NoelBlocks.POINSETTIA.asItem(), 0.65F);
    }

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(Noel.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Identifier GINGER_BREAD_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "entity/signs/ginger_bread");
    public static final Identifier GINGER_BREAD_HANGING_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "entity/signs/hanging/ginger_bread");
    public static final Identifier GINGER_BREAD_HANGING_GUI_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "textures/gui/hanging_signs/ginger_bread");
    public static final Identifier FROSTED_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "entity/signs/frosted");
    public static final Identifier FROSTED_HANGING_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "entity/signs/hanging/frosted");
    public static final Identifier FROSTED_HANGING_GUI_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "textures/gui/hanging_signs/frosted");
    public static final Identifier PEPPERMINT_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "entity/signs/peppermint");
    public static final Identifier PEPPERMINT_HANGING_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "entity/signs/hanging/peppermint");
    public static final Identifier PEPPERMINT_HANGING_GUI_SIGN_TEXTURE = Identifier.of(Noel.MOD_ID, "textures/gui/hanging_signs/peppermint");

    public static final Block ADVENT_CALENDAR = register(new BlockAdventCalendar(AbstractBlock.Settings.create().sounds(BlockSoundGroup.VINE).noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY)), "advent_calendar", true);
    public static final Block GLOWSTONE_STAR = register(new BlockTopper(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().noCollision().breakInstantly().luminance((state) -> {return 15;})), "glowstone_star", true);
    public static final Block GOLD_STAR = register(new BlockTopper(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().noCollision().breakInstantly().luminance((state) -> {return 15;})), "gold_star", true);
    public static final Block KETTLE = register(new BlockKettle(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(2.0f).pistonBehavior(PistonBehavior.BLOCK)), "kettle", true);
    public static final Block PRESENT = register(new BlockPresent(false, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.25f).notSolid()), "present", true);
    public static final Block PRESENT_TRAP = register(new BlockPresent(true, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).strength(0.28f)), "present_trap", true);
    public static final Block OAK_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "oak_wreath", true);
    public static final Block SPRUCE_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "spruce_wreath", true);
    public static final Block BIRCH_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "birch_wreath", true);
    public static final Block DARK_OAK_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "dark_oak_wreath", true);
    public static final Block JUNGLE_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "jungle_wreath", true);
    public static final Block ACACIA_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "acacia_wreath", true);
    public static final Block AZALEA_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "azalea_wreath", true);
    public static final Block MANGROVE_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "mangrove_wreath", true);
    public static final Block CHERRY_WREATH = register(new BlockWreath(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "cherry_wreath", true);
    public static final Block SHRUB_TREE = register(new BlockShrubTree(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "shrub_tree", true);
    public static final Block POINSETTIA = register(new BlockFlower(StatusEffects.POISON, 6, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "poinsettia", true);
    public static final Block POTTED_POINSETTIA = register(new BlockFlowerPot(NoelBlocks.POINSETTIA, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), "potted_poinsettia", true);
    public static final Block MISTLETOE = register(new BlockMistletoe(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS).noCollision().breakInstantly()), "mistletoe", true);
    public static final Block GINGER_BREAD_BLOCK = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "ginger_bread_block", true);
    public static final Block GINGER_BREAD_SLAB = register(new BlockSlab(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "ginger_bread_slab", true);
    public static final Block GINGER_BREAD_STAIRS = register(new BlockStairs(NoelBlocks.GINGER_BREAD_BLOCK.getDefaultState(), AbstractBlock.Settings.copyShallow(GINGER_BREAD_BLOCK)), "ginger_bread_stairs", true);
    public static final Block GINGER_BREAD_DOOR = register(new BlockDoor(NoelBlockSetType.GINGER_BREAD, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(3.0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), "ginger_bread_door", true);
    public static final Block GINGER_BREAD_WALL = register(new BlockWall(AbstractBlock.Settings.copyShallow(GINGER_BREAD_BLOCK).solid()), "ginger_bread_wall", true);
    public static final Block GINGER_BREAD_STANDING_SIGN = register(new TerraformSignBlock(GINGER_BREAD_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_SIGN)), "ginger_bread_standing_sign", false);
    public static final Block GINGER_BREAD_WALL_SIGN = register(new TerraformWallSignBlock(GINGER_BREAD_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_WALL_SIGN)), "ginger_bread_wall_sign", false);
    public static final Block GINGER_BREAD_HANGING_SIGN = register(new TerraformHangingSignBlock(GINGER_BREAD_HANGING_SIGN_TEXTURE, GINGER_BREAD_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_HANGING_SIGN)), "ginger_bread_hanging_sign", false);
    public static final Block GINGER_BREAD_WALL_HANGING_SIGN = register(new TerraformWallHangingSignBlock(GINGER_BREAD_HANGING_SIGN_TEXTURE, GINGER_BREAD_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_WALL_HANGING_SIGN)), "ginger_bread_wall_hanging_sign", false);
    public static final Block FROSTED_LOG = register(new BlockPillar(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "frosted_log", true);
    public static final Block STRIPPED_FROSTED_LOG = register(new BlockPillar(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "stripped_frosted_log", true);
    public static final Block STRIPPED_FROSTED_WOOD = register(new BlockPillar(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "stripped_frosted_wood", true);
    public static final Block FROSTED_PLANKS = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "frosted_planks", true);
    public static final Block FROSTED_SLAB = register(new BlockSlab(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "frosted_slab", true);
    public static final Block FROSTED_STAIRS = register(new BlockStairs(NoelBlocks.FROSTED_PLANKS.getDefaultState(),AbstractBlock.Settings.copyShallow(FROSTED_PLANKS)), "frosted_stairs", true);
    public static final Block FROSTED_TRAPDOOR = register(new BlockTrapdoor(NoelBlockSetType.FROSTED,AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).nonOpaque().strength(3.0f).allowsSpawning(Blocks::never)), "frosted_trapdoor", true);
    public static final Block FROSTED_DOOR = register(new BlockDoor(NoelBlockSetType.FROSTED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(3.0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), "frosted_door", true);
    public static final Block FROSTED_FENCE = register(new BlockFence(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).solid().strength(2.0F, 3.0F)), "frosted_fence", true);
    public static final Block FROSTED_FENCE_GATE = register(new BlockFenceGate(NoelWoodType.FROSTED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).solid().strength(2.0F, 3.0F)), "frosted_fence_gate", true);
    public static final Block FROSTED_BUTTON = register(new BlockButton(NoelBlockSetType.FROSTED, 30, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).noCollision().strength(0.5f).pistonBehavior(PistonBehavior.DESTROY)), "frosted_button", true);
    public static final Block FROSTED_PRESSURE_PLATE = register(new BlockPressurePlate(NoelBlockSetType.FROSTED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).solid().strength(0.5f).noCollision().pistonBehavior(PistonBehavior.DESTROY)), "frosted_pressure_plate", true);
    public static final Block FROSTED_STANDING_SIGN = register(new TerraformSignBlock(FROSTED_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_SIGN)), "frosted_standing_sign", false);
    public static final Block FROSTED_WALL_SIGN = register(new TerraformWallSignBlock(FROSTED_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_WALL_SIGN)), "frosted_wall_sign", false);
    public static final Block FROSTED_HANGING_SIGN = register(new TerraformHangingSignBlock(FROSTED_HANGING_SIGN_TEXTURE, FROSTED_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_HANGING_SIGN)), "frosted_hanging_sign", false);
    public static final Block FROSTED_WALL_HANGING_SIGN = register(new TerraformWallHangingSignBlock(FROSTED_HANGING_SIGN_TEXTURE, FROSTED_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_WALL_HANGING_SIGN)), "frosted_wall_hanging_sign", false);
    public static final Block FROSTED_WOOD = register(new BlockPillar(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f)), "frosted_wood", true);
    public static final Block PEPPERMINT_LOG = register(new BlockPillar(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).strength(2.0f, 3.0f)), "peppermint_log", true);
    public static final Block PEPPERMINT_PLANKS = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).strength(2.0f, 3.0f)), "peppermint_planks", true);
    public static final Block PEPPERMINT_SLAB = register(new BlockSlab(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).strength(2.0f, 3.0f)), "peppermint_slab", true);
    public static final Block PEPPERMINT_STAIRS = register(new BlockStairs(NoelBlocks.PEPPERMINT_PLANKS.getDefaultState(), AbstractBlock.Settings.copyShallow(PEPPERMINT_PLANKS)), "peppermint_stairs", true);
    public static final Block PEPPERMINT_TRAPDOOR = register(new BlockTrapdoor(NoelBlockSetType.PEPPERMINT, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).nonOpaque().strength(3.0f).allowsSpawning(Blocks::never)), "peppermint_trapdoor", true);
    public static final Block PEPPERMINT_DOOR = register(new BlockDoor(NoelBlockSetType.PEPPERMINT, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).strength(3.0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), "peppermint_door", true);
    public static final Block PEPPERMINT_FENCE = register(new BlockFence(AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).solid().strength(2.0F, 3.0F)), "peppermint_fence", true);
    public static final Block PEPPERMINT_FENCE_GATE = register(new BlockFenceGate(NoelWoodType.PEPPERMINT, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).solid().strength(2.0F, 3.0F)), "peppermint_fence_gate", true);
    public static final Block PEPPERMINT_BUTTON = register(new BlockButton(NoelBlockSetType.PEPPERMINT, 30, AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).noCollision().strength(0.5f).pistonBehavior(PistonBehavior.DESTROY)), "peppermint_button", true);
    public static final Block PEPPERMINT_PRESSURE_PLATE = register(new BlockPressurePlate(NoelBlockSetType.PEPPERMINT,AbstractBlock.Settings.create().sounds(BlockSoundGroup.BONE).solid().strength(0.5f).noCollision().pistonBehavior(PistonBehavior.DESTROY)), "peppermint_pressure_plate", true);
    public static final Block PEPPERMINT_WALL = register(new BlockWall(AbstractBlock.Settings.copyShallow(PEPPERMINT_LOG).solid()), "peppermint_wall", true);
    public static final Block PEPPERMINT_STANDING_SIGN = register(new TerraformSignBlock(PEPPERMINT_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_SIGN)), "peppermint_standing_sign", false);
    public static final Block PEPPERMINT_WALL_SIGN = register(new TerraformWallSignBlock(PEPPERMINT_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_WALL_SIGN)), "peppermint_wall_sign", false);
    public static final Block PEPPERMINT_HANGING_SIGN = register(new TerraformHangingSignBlock(PEPPERMINT_HANGING_SIGN_TEXTURE, PEPPERMINT_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_HANGING_SIGN)), "peppermint_hanging_sign", false);
    public static final Block PEPPERMINT_WALL_HANGING_SIGN = register(new TerraformWallHangingSignBlock(PEPPERMINT_HANGING_SIGN_TEXTURE, PEPPERMINT_HANGING_GUI_SIGN_TEXTURE, AbstractBlock.Settings.copyShallow(Blocks.OAK_WALL_HANGING_SIGN)), "peppermint_wall_hanging_sign", false);

    public static final Block RED_GUMDROP = register(new BlockGumdrop(AbstractBlock.Settings.create().sounds(BlockSoundGroup.HONEY).strength(0.25f).slipperiness(0.8F).nonOpaque()), "red_gumdrop", true);
    public static final Block ORANGE_GUMDROP = register(new BlockGumdrop(AbstractBlock.Settings.create().sounds(BlockSoundGroup.HONEY).strength(0.25f).slipperiness(0.8F).nonOpaque()), "orange_gumdrop", true);
    public static final Block YELLOW_GUMDROP = register(new BlockGumdrop(AbstractBlock.Settings.create().sounds(BlockSoundGroup.HONEY).strength(0.25f).slipperiness(0.8F).nonOpaque()), "yellow_gumdrop", true);
    public static final Block GREEN_GUMDROP = register(new BlockGumdrop(AbstractBlock.Settings.create().sounds(BlockSoundGroup.HONEY).strength(0.25f).slipperiness(0.8F).nonOpaque()), "green_gumdrop", true);
    public static final Block BLUE_GUMDROP = register(new BlockGumdrop(AbstractBlock.Settings.create().sounds(BlockSoundGroup.HONEY).strength(0.25f).slipperiness(0.8F).nonOpaque()), "blue_gumdrop", true);
    public static final Block PURPLE_GUMDROP = register(new BlockGumdrop(AbstractBlock.Settings.create().sounds(BlockSoundGroup.HONEY).strength(0.25f).slipperiness(0.8F).nonOpaque()), "purple_gumdrop", true);
    public static final Block BLACK_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "black_ornament", true);
    public static final Block BLUE_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "blue_ornament", true);
    public static final Block BROWN_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "brown_ornament", true);
    public static final Block CYAN_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "cyan_ornament", true);
    public static final Block GRAY_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "gray_ornament", true);
    public static final Block GREEN_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "green_ornament", true);
    public static final Block LIGHT_BLUE_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "light_blue_ornament", true);
    public static final Block LIME_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "lime_ornament", true);
    public static final Block MAGENTA_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "magenta_ornament", true);
    public static final Block ORANGE_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "orange_ornament", true);
    public static final Block PINK_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "pink_ornament", true);
    public static final Block PURPLE_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "purple_ornament", true);
    public static final Block RED_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "red_ornament", true);
    public static final Block LIGHT_GRAY_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "light_gray_ornament", true);
    public static final Block WHITE_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "white_ornament", true);
    public static final Block YELLOW_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)), "yellow_ornament", true);
    public static final Block DIAMOND_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "diamond_ornament", true);
    public static final Block EMERALD_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "emerald_ornament", true);
    public static final Block GLASS_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "glass_ornament", true);
    public static final Block GOLD_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "gold_ornament", true);
    public static final Block IRON_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "iron_ornament", true);
    public static final Block COPPER_ORNAMENT = register(new BlockCopperOrnament(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "copper_ornament", true);
    public static final Block EXPOSED_COPPER_ORNAMENT = register(new BlockCopperOrnament(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "exposed_copper_ornament", true);
    public static final Block WEATHERED_COPPER_ORNAMENT = register(new BlockCopperOrnament(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "weathered_copper_ornament", true);
    public static final Block OXIDIZED_COPPER_ORNAMENT = register(new BlockCopperOrnament(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "oxidized_copper_ornament", true);
    public static final Block WAXED_COPPER_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.copy(COPPER_ORNAMENT)), "waxed_copper_ornament", true);
    public static final Block WAXED_EXPOSED_COPPER_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.copy(EXPOSED_COPPER_ORNAMENT)), "waxed_exposed_copper_ornament", true);
    public static final Block WAXED_WEATHERED_COPPER_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.copy(WEATHERED_COPPER_ORNAMENT)), "waxed_weathered_copper_ornament", true);
    public static final Block WAXED_OXIDIZED_COPPER_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.copy(OXIDIZED_COPPER_ORNAMENT)), "waxed_oxidized_copper_ornament", true);
    public static final Block REDSTONE_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "redstone_ornament", true);
    public static final Block LAPIS_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "lapis_ornament", true);
    public static final Block COAL_ORNAMENT = register(new BlockOrnament(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never)), "coal_ornament", true);
    public static final Block BLACK_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "black_stocking", true);
    public static final Block BLUE_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "blue_stocking", true);
    public static final Block BROWN_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "brown_stocking", true);
    public static final Block CYAN_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "cyan_stocking", true);
    public static final Block GRAY_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "gray_stocking", true);
    public static final Block GREEN_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "green_stocking", true);
    public static final Block LIGHT_BLUE_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "light_blue_stocking", true);
    public static final Block LIME_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "lime_stocking", true);
    public static final Block MAGENTA_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "magenta_stocking", true);
    public static final Block ORANGE_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "orange_stocking", true);
    public static final Block PINK_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "pink_stocking", true);
    public static final Block PURPLE_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "purple_stocking", true);
    public static final Block RED_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "red_stocking", true);
    public static final Block LIGHT_GRAY_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "light_gray_stocking", true);
    public static final Block WHITE_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "white_stocking", true);
    public static final Block YELLOW_STOCKING = register(new BlockStocking(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "yellow_stocking", true);
    public static final Block BLACK_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "black_ribbon", true);
    public static final Block BLUE_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "blue_ribbon", true);
    public static final Block BROWN_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "brown_ribbon", true);
    public static final Block CYAN_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "cyan_ribbon", true);
    public static final Block GRAY_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "gray_ribbon", true);
    public static final Block GREEN_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "green_ribbon", true);
    public static final Block LIGHT_BLUE_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "light_blue_ribbon", true);
    public static final Block LIME_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "lime_ribbon", true);
    public static final Block MAGENTA_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "magenta_ribbon", true);
    public static final Block ORANGE_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "orange_ribbon", true);
    public static final Block PINK_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "pink_ribbon", true);
    public static final Block PURPLE_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "purple_ribbon", true);
    public static final Block RED_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "red_ribbon", true);
    public static final Block WHITE_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "white_ribbon", true);
    public static final Block YELLOW_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "yellow_ribbon", true);
    public static final Block LIGHT_GRAY_RIBBON = register(new BlockRibbon(AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOL).noCollision().breakInstantly()), "light_gray_ribbon", true);


}
