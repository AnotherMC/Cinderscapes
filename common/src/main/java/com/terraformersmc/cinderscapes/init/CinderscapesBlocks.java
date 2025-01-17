package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherTallPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNyliumBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesOreBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesTransparentBlock;
import com.terraformersmc.cinderscapes.block.CrystiniumBlock;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.PhotofernBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.block.PottedCrystiniumBlock;
import com.terraformersmc.cinderscapes.block.PottedPyracinthBlock;
import com.terraformersmc.cinderscapes.block.PyracinthBlock;
import com.terraformersmc.cinderscapes.init.helpers.CinderscapesRegistry;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CinderscapesBlocks {

    /////////////////
    // Ashy Shoals //
    /////////////////

    public static Block SCORCHED_STEM;
    public static Block STRIPPED_SCORCHED_STEM;

    public static Block SCORCHED_HYPHAE;
    public static Block STRIPPED_SCORCHED_HYPHAE;
    public static Block SCORCHED_SHRUB;
    public static Block POTTED_SCORCHED_SHRUB;

    public static Block SCORCHED_TENDRILS;
    public static Block SCORCHED_SPROUTS;
    public static Block POTTED_SCORCHED_TENDRILS;

    public static Block ASH;
    public static Block ASH_BLOCK;

    public static Block PYRACINTH;
    public static Block POTTED_PYRACINTH;

    ////////////////////
    // Luminous Grove //
    ////////////////////

    // Umbral Nylia

    public static Block UMBRAL_STEM;
    public static Block STRIPPED_UMBRAL_STEM;

    public static Block UMBRAL_HYPHAE;
    public static Block STRIPPED_UMBRAL_HYPHAE;

    public static Block UMBRAL_NYLIUM;

    public static Block UMBRAL_FUNGUS;
    public static Block POTTED_UMBRAL_FUNGUS;

    public static Block UMBRAL_WART_BLOCK;
    public static Block UMBRAL_FLESH_BLOCK;

    // Other

    public static Block TWILIGHT_VINE_BLOCK;
    public static Block TWILIGHT_TENDRILS;
    public static Block POTTED_TWILIGHT_TENDRILS;
    public static Block TWILIGHT_FESCUES;

    public static Block PHOTOFERN;
    public static Block POTTED_PHOTOFERN;

    public static Block TALL_PHOTOFERN;

    public static Block LUMINOUS_POD;
    public static Block POTTED_LUMINOUS_POD;
    public static Block GHASTLY_ECTOPLASM;

    ///////////
    // Other //
    ///////////

    public static Block BRAMBLE_BERRY_BUSH;

    public static Block NODZOL;

    public static Block SULFUR_BLOCK;
    public static Block SULFUR_ORE;

    ///////////////////
    // Quartz Cavern //
    ///////////////////

    public static Block CRYSTINIUM;
    public static Block POTTED_CRYSTINIUM;

    public static Block CRYSTALLINE_QUARTZ;

    // Sulfur Quartz

    public static Block SULFUR_QUARTZ_ORE;
    public static Block SULFUR_QUARTZ_BLOCK;
    public static Block CHISELED_SULFUR_QUARTZ_BLOCK;
    public static Block SULFUR_QUARTZ_PILLAR;
    public static Block SMOOTH_SULFUR_QUARTZ;
    public static Block SULFUR_QUARTZ_BRICKS;

    public static Block CRYSTALLINE_SULFUR_QUARTZ;

    // Rose Quartz

    public static Block ROSE_QUARTZ_ORE;
    public static Block ROSE_QUARTZ_BLOCK;
    public static Block CHISELED_ROSE_QUARTZ_BLOCK;
    public static Block ROSE_QUARTZ_PILLAR;
    public static Block SMOOTH_ROSE_QUARTZ;
    public static Block ROSE_QUARTZ_BRICKS;

    public static Block CRYSTALLINE_ROSE_QUARTZ;

    // Smoky Quartz

    public static Block SMOKY_QUARTZ_ORE;
    public static Block SMOKY_QUARTZ_BLOCK;
    public static Block CHISELED_SMOKY_QUARTZ_BLOCK;
    public static Block SMOKY_QUARTZ_PILLAR;
    public static Block SMOOTH_SMOKY_QUARTZ;
    public static Block SMOKY_QUARTZ_BRICKS;

    public static Block CRYSTALLINE_SMOKY_QUARTZ;

    public static void init() {

        /////////////////
        // Ashy Shoals //
        /////////////////

        SCORCHED_STEM = CinderscapesRegistry.register("scorched_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.GRAY, MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_STEM = CinderscapesRegistry.register("stripped_scorched_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.GRAY));

        SCORCHED_HYPHAE = CinderscapesRegistry.register("scorched_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.TERRACOTTA_GRAY));
        STRIPPED_SCORCHED_HYPHAE = CinderscapesRegistry.register("stripped_scorched_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.GRAY));

        SCORCHED_SHRUB = CinderscapesRegistry.register("scorched_shrub", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.DEAD_BUSH).mapColor(MapColor.TERRACOTTA_GRAY));
        POTTED_SCORCHED_SHRUB = CinderscapesRegistry.register("potted_scorched_shrub", settings -> new FlowerPotBlock(SCORCHED_SHRUB, settings), AbstractBlock.Settings.copy(Blocks.POTTED_DEAD_BUSH));

        SCORCHED_SPROUTS = CinderscapesRegistry.register("scorched_sprouts", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.NETHER_SPROUTS).mapColor(MapColor.GRAY));
        SCORCHED_TENDRILS = CinderscapesRegistry.register("scorched_tendrils", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_ROOTS).mapColor(MapColor.GRAY));
        POTTED_SCORCHED_TENDRILS = CinderscapesRegistry.register("potted_scorched_tendrils", settings -> new FlowerPotBlock(SCORCHED_TENDRILS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_CRIMSON_ROOTS));

        ASH = CinderscapesRegistry.register("ash", AshLayerBlock::new, AbstractBlock.Settings.copy(Blocks.SNOW).mapColor(MapColor.GRAY));
        ASH_BLOCK = CinderscapesRegistry.register("ash_block", Block::new, AbstractBlock.Settings.copy(Blocks.SNOW_BLOCK).mapColor(MapColor.GRAY));

        PYRACINTH = CinderscapesRegistry.register("pyracinth", PyracinthBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.ORANGE));
        POTTED_PYRACINTH = CinderscapesRegistry.register("potted_pyracinth", PottedPyracinthBlock::new, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM));

        ////////////////////
        // Luminous Grove //
        ////////////////////

        // Umbral Nylia

        UMBRAL_STEM = CinderscapesRegistry.register("umbral_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.LIGHT_BLUE_GRAY, MapColor.BLUE));
        STRIPPED_UMBRAL_STEM = CinderscapesRegistry.register("stripped_umbral_stem", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_HYPHAE = CinderscapesRegistry.register("umbral_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.BLUE));
        STRIPPED_UMBRAL_HYPHAE = CinderscapesRegistry.register("stripped_umbral_hyphae", PillarBlock::new, PillarLogHelper.createNetherSettings(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_NYLIUM = CinderscapesRegistry.register("umbral_nylium", CinderscapesNyliumBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_NYLIUM).mapColor(MapColor.LIGHT_BLUE_GRAY));

        UMBRAL_FUNGUS = CinderscapesRegistry.register("umbral_fungus", settings -> new FungusBlock(CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_PLANTED, UMBRAL_NYLIUM, settings), AbstractBlock.Settings.copy(Blocks.WARPED_FUNGUS).mapColor(MapColor.BLUE).luminance(state -> 15));
        POTTED_UMBRAL_FUNGUS = CinderscapesRegistry.register("potted_umbral_fungus", settings -> new FlowerPotBlock(UMBRAL_FUNGUS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_FUNGUS).luminance(state -> 12));

        UMBRAL_WART_BLOCK = CinderscapesRegistry.register("umbral_wart_block", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLUE).nonOpaque());
        UMBRAL_FLESH_BLOCK = CinderscapesRegistry.register("umbral_flesh_block", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(UMBRAL_WART_BLOCK).luminance(state -> 15));
       // Other

        TWILIGHT_VINE_BLOCK = CinderscapesRegistry.register("twilight_vine_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASS).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM));
        TWILIGHT_TENDRILS = CinderscapesRegistry.register("twilight_tendrils", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PALE_PURPLE).luminance(state -> 15));
        POTTED_TWILIGHT_TENDRILS = CinderscapesRegistry.register("potted_twilight_tendrils", settings -> new FlowerPotBlock(TWILIGHT_TENDRILS, settings), AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance(state -> 12));
        TWILIGHT_FESCUES = CinderscapesRegistry.register("twilight_fescues", settings -> new CinderscapesNetherPlantBlock(state -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.NETHER_SPROUTS).mapColor(MapColor.PURPLE));

        PHOTOFERN = CinderscapesRegistry.register("photofern", PhotofernBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PURPLE));
        POTTED_PHOTOFERN = CinderscapesRegistry.register("potted_photofern", settings -> new FlowerPotBlock(PHOTOFERN, settings), AbstractBlock.Settings.copy(Blocks.POTTED_FERN));

        TALL_PHOTOFERN = CinderscapesRegistry.register("tall_photofern", settings -> new CinderscapesNetherTallPlantBlock(state -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PURPLE));

        LUMINOUS_POD = CinderscapesRegistry.register("luminous_pod", settings -> new CinderscapesNetherTallPlantBlock(state -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0), settings), AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.PALE_GREEN).luminance(state -> 15));
        POTTED_LUMINOUS_POD = CinderscapesRegistry.register("potted_luminous_pod", settings -> new FlowerPotBlock(LUMINOUS_POD, settings), AbstractBlock.Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance(state -> 12));
        GHASTLY_ECTOPLASM = CinderscapesRegistry.register("ghastly_ectoplasm", GhastlyEctoplasmBlock::new, AbstractBlock.Settings.copy(Blocks.WEEPING_VINES_PLANT).mapColor(MapColor.OFF_WHITE).sounds(BlockSoundGroup.ROOTS));

        ///////////
        // Other //
        ///////////

        BRAMBLE_BERRY_BUSH = CinderscapesRegistry.register("bramble_berry_bush", BrambleBerryBushBlock::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH).mapColor(MapColor.TERRACOTTA_BLACK));

        NODZOL = CinderscapesRegistry.register("nodzol", Block::new, AbstractBlock.Settings.copy(Blocks.NETHERRACK).mapColor(MapColor.BROWN));

        SULFUR_BLOCK = CinderscapesRegistry.register("sulfur_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F, 0.5f).sounds(BlockSoundGroup.GRAVEL));
        SULFUR_ORE = CinderscapesRegistry.register("sulfur_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());

        ///////////////////
        // Quartz Cavern //
        ///////////////////

        CRYSTINIUM = CinderscapesRegistry.register("crystinium", CrystiniumBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_ROOTS).mapColor(MapColor.YELLOW));
        POTTED_CRYSTINIUM = CinderscapesRegistry.register("potted_crystinium", PottedCrystiniumBlock::new, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM));

        CRYSTALLINE_QUARTZ = CinderscapesRegistry.register("crystalline_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never));

        // Sulfur Quartz

        SULFUR_QUARTZ_ORE = CinderscapesRegistry.register("sulfur_quartz_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.YELLOW).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("sulfur_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW));
        CHISELED_SULFUR_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_sulfur_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW));
        SULFUR_QUARTZ_PILLAR = CinderscapesRegistry.register("sulfur_quartz_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.YELLOW));
        SMOOTH_SULFUR_QUARTZ = CinderscapesRegistry.register("smooth_sulfur_quartz", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.YELLOW));
        SULFUR_QUARTZ_BRICKS = CinderscapesRegistry.register("sulfur_quartz_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.YELLOW));

        CRYSTALLINE_SULFUR_QUARTZ = CinderscapesRegistry.register("crystalline_sulfur_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.YELLOW));

        // Rose Quartz

        ROSE_QUARTZ_ORE = CinderscapesRegistry.register("rose_quartz_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.PINK).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("rose_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK));
        CHISELED_ROSE_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_rose_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK));
        ROSE_QUARTZ_PILLAR = CinderscapesRegistry.register("rose_quartz_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.PINK));
        SMOOTH_ROSE_QUARTZ = CinderscapesRegistry.register("smooth_rose_quartz", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.PINK));
        ROSE_QUARTZ_BRICKS = CinderscapesRegistry.register("rose_quartz_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.PINK));

        CRYSTALLINE_ROSE_QUARTZ = CinderscapesRegistry.register("crystalline_rose_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.PINK));

        // Smoky Quartz

        SMOKY_QUARTZ_ORE = CinderscapesRegistry.register("smoky_quartz_ore", CinderscapesOreBlock::new, AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.GRAY).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("smoky_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY));
        CHISELED_SMOKY_QUARTZ_BLOCK = CinderscapesRegistry.register("chiseled_smoky_quartz_block", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY));
        SMOKY_QUARTZ_PILLAR = CinderscapesRegistry.register("smoky_quartz_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_PILLAR).mapColor(MapColor.GRAY));
        SMOOTH_SMOKY_QUARTZ = CinderscapesRegistry.register("smooth_smoky_quartz", Block::new, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.GRAY));
        SMOKY_QUARTZ_BRICKS = CinderscapesRegistry.register("smoky_quartz_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS).mapColor(MapColor.GRAY));

        CRYSTALLINE_SMOKY_QUARTZ = CinderscapesRegistry.register("crystalline_smoky_quartz", CinderscapesTransparentBlock::new, AbstractBlock.Settings.copy(CRYSTALLINE_QUARTZ).mapColor(MapColor.GRAY));

        addStrippables();
    }

    private static void addStrippables() {
        StrippableBlockRegistry.register(SCORCHED_STEM, STRIPPED_SCORCHED_STEM);
        StrippableBlockRegistry.register(SCORCHED_HYPHAE, STRIPPED_SCORCHED_HYPHAE);
        StrippableBlockRegistry.register(UMBRAL_STEM, STRIPPED_UMBRAL_STEM);
        StrippableBlockRegistry.register(UMBRAL_HYPHAE, STRIPPED_UMBRAL_HYPHAE);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}
