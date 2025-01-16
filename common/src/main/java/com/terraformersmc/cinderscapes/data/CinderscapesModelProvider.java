package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesArmorTrimMaterials;
import com.terraformersmc.cinderscapes.init.CinderscapesBlockFamilies;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CinderscapesModelProvider extends FabricModelProvider {
    private static final List<ItemModelGenerator.TrimMaterial> TRIM_MATERIALS = List.of(
            new ItemModelGenerator.TrimMaterial("cinderscapes_rose_quartz", CinderscapesArmorTrimMaterials.ROSE_QUARTZ, Map.of()),
            new ItemModelGenerator.TrimMaterial("cinderscapes_smoky_quartz", CinderscapesArmorTrimMaterials.SMOKY_QUARTZ, Map.of()),
            new ItemModelGenerator.TrimMaterial("cinderscapes_sulfur_quartz", CinderscapesArmorTrimMaterials.SULFUR_QUARTZ, Map.of())
    );

    public CinderscapesModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {

        /////////////////
        // Ashy Shoals //
        /////////////////

        // Scorched wood set
        //generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SCORCHED.getBaseBlock()).family(CinderscapesBlockFamilies.SCORCHED);
        generator.registerLog(CinderscapesBlocks.SCORCHED_STEM).log(CinderscapesBlocks.SCORCHED_STEM).wood(CinderscapesBlocks.SCORCHED_HYPHAE);
        generator.registerLog(CinderscapesBlocks.STRIPPED_SCORCHED_STEM).log(CinderscapesBlocks.STRIPPED_SCORCHED_STEM).wood(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);
        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_STEM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SCORCHED_HYPHAE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);

        // Misc. vegetation
        generator.registerFlowerPotPlantAndItem(CinderscapesBlocks.SCORCHED_SHRUB, CinderscapesBlocks.POTTED_SCORCHED_SHRUB, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerTintableCrossBlockState(CinderscapesBlocks.SCORCHED_SPROUTS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerTintableCross(CinderscapesBlocks.SCORCHED_TENDRILS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.SCORCHED_TENDRILS, CinderscapesBlocks.POTTED_SCORCHED_TENDRILS, true);
        generator.registerFlowerPotPlant(CinderscapesBlocks.PYRACINTH, CinderscapesBlocks.POTTED_PYRACINTH, BlockStateModelGenerator.CrossType.NOT_TINTED);

        // BlockStateModelGenerator.registerSnows() equivalent  (Ash is a snow-like layered powder block)
        // We have to make models inheriting from vanilla's hand-rolled snow models...
        TextureMap ashTexture = TextureMap.all(CinderscapesBlocks.ASH);
        Identifier ashModelId = Models.CUBE_ALL.upload(CinderscapesBlocks.ASH_BLOCK, ashTexture, generator.modelCollector);
        /*generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(CinderscapesBlocks.ASH).coordinate(
                BlockStateVariantMap.create(Properties.LAYERS).register(height -> BlockStateVariant.create()
                        .put(VariantSettings.MODEL,
                                height < 8 ?
                                new Model(Optional.of(ModelIds.getBlockSubModelId(Blocks.SNOW, "_height" + height * 2)),
                                        Optional.empty(), TextureKey.PARTICLE, TextureKey.TEXTURE)
                                        .upload(ModelIds.getBlockSubModelId(CinderscapesBlocks.ASH, "_height" + height * 2),
                                                ashTexture, generator.modelCollector) :
                                ashModelId))));*/
        generator.registerParentedItemModel(CinderscapesBlocks.ASH, ModelIds.getBlockSubModelId(CinderscapesBlocks.ASH, "_height2"));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(CinderscapesBlocks.ASH_BLOCK, ashModelId));
        this.registerBlockItemModel(generator, CinderscapesBlocks.ASH_BLOCK);


        ////////////////////
        // Luminous Grove //
        ////////////////////

        // Umbral wood set
        //generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.UMBRAL.getBaseBlock()).family(CinderscapesBlockFamilies.UMBRAL);
        generator.registerLog(CinderscapesBlocks.UMBRAL_STEM).log(CinderscapesBlocks.UMBRAL_STEM).wood(CinderscapesBlocks.UMBRAL_HYPHAE);
        generator.registerLog(CinderscapesBlocks.STRIPPED_UMBRAL_STEM).log(CinderscapesBlocks.STRIPPED_UMBRAL_STEM).wood(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);
        generator.registerFlowerPotPlantAndItem(CinderscapesBlocks.UMBRAL_FUNGUS, CinderscapesBlocks.POTTED_UMBRAL_FUNGUS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // Item models missed by vanilla code
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_STEM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_HYPHAE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);

        // Luminous Grove misc.
        generator.registerNetherrackBottomCustomTop(CinderscapesBlocks.UMBRAL_NYLIUM);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_NYLIUM);
        generator.registerSimpleCubeAll(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.UMBRAL_WART_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.UMBRAL_WART_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
        generator.registerTintableCross(CinderscapesBlocks.TWILIGHT_TENDRILS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.TWILIGHT_TENDRILS, CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS, true);
        generator.registerTintableCrossBlockState(CinderscapesBlocks.TWILIGHT_FESCUES, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerFlowerPotPlant(CinderscapesBlocks.PHOTOFERN, CinderscapesBlocks.POTTED_PHOTOFERN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        generator.registerDoubleBlock(CinderscapesBlocks.TALL_PHOTOFERN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        // Luminous Pod is two tall but potted
        generator.registerDoubleBlock(CinderscapesBlocks.LUMINOUS_POD, BlockStateModelGenerator.CrossType.NOT_TINTED);
        this.registerPottedPlantOnly(generator, CinderscapesBlocks.LUMINOUS_POD, CinderscapesBlocks.POTTED_LUMINOUS_POD, true);

        // Ghastly Ectoplasm is a multi-part variable length hanging cross block
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(CinderscapesBlocks.GHASTLY_ECTOPLASM)
                        .coordinate(
                                BlockStateVariantMap.create(GhastlyEctoplasmBlock.TYPE)
                                        .register(GhastlyEctoplasmBlock.Type.TOP, BlockStateVariant.create().put(VariantSettings.MODEL,
                                                Models.TINTED_CROSS.upload(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_top",
                                                        TextureMap.cross(TextureMap.getSubId(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_top")),
                                                        generator.modelCollector)))
                                        .register(GhastlyEctoplasmBlock.Type.MIDDLE, BlockStateVariant.create().put(VariantSettings.MODEL,
                                                Models.TINTED_CROSS.upload(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_middle",
                                                        TextureMap.cross(TextureMap.getSubId(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_middle")),
                                                        generator.modelCollector)))
                                        .register(GhastlyEctoplasmBlock.Type.BOTTOM, BlockStateVariant.create().put(VariantSettings.MODEL,
                                                Models.TINTED_CROSS.upload(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_bottom",
                                                        TextureMap.cross(TextureMap.getSubId(CinderscapesBlocks.GHASTLY_ECTOPLASM, "_bottom")),
                                                        generator.modelCollector)))
                        )
        );



        ///////////////////
        // Quartz Cavern //
        ///////////////////

        // Rose Quartz set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.ROSE_QUARTZ_BLOCK.getBaseBlock()).family(CinderscapesBlockFamilies.ROSE_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOOTH_ROSE_QUARTZ.getBaseBlock()).family(CinderscapesBlockFamilies.SMOOTH_ROSE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.ROSE_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_ORE);
        generator.registerSimpleCubeAll(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
        generator.registerAxisRotated(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ);

        // Smoky Quartz set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOKY_QUARTZ_BLOCK.getBaseBlock()).family(CinderscapesBlockFamilies.SMOKY_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOOTH_SMOKY_QUARTZ.getBaseBlock()).family(CinderscapesBlockFamilies.SMOOTH_SMOKY_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_ORE);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
        generator.registerAxisRotated(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ);

        // Sulfur Quartz set
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SULFUR_QUARTZ_BLOCK.getBaseBlock()).family(CinderscapesBlockFamilies.SULFUR_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
        generator.registerCubeAllModelTexturePool(CinderscapesBlockFamilies.SMOOTH_SULFUR_QUARTZ.getBaseBlock()).family(CinderscapesBlockFamilies.SMOOTH_SULFUR_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
        this.registerCubeColumn(generator, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_ORE);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
        generator.registerAxisRotated(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ);

        // Nether Quartz additions
        generator.registerSimpleCubeAll(CinderscapesBlocks.CRYSTALLINE_QUARTZ);
        this.registerBlockItemModel(generator, CinderscapesBlocks.CRYSTALLINE_QUARTZ);

        // Quartz Cavern misc.
        generator.registerFlowerPotPlant(CinderscapesBlocks.CRYSTINIUM, CinderscapesBlocks.POTTED_CRYSTINIUM, BlockStateModelGenerator.CrossType.NOT_TINTED);


        ///////////
        // Other //
        ///////////

        generator.registerNetherrackBottomCustomTop(CinderscapesBlocks.NODZOL);
        this.registerBlockItemModel(generator, CinderscapesBlocks.NODZOL);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_BLOCK);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_BLOCK);
        generator.registerSimpleCubeAll(CinderscapesBlocks.SULFUR_ORE);
        this.registerBlockItemModel(generator, CinderscapesBlocks.SULFUR_ORE);

        // Adapted copy of BlockStateModelGenerator.registerSweetBerryBush for Bramble Berry Bush
        generator.registerItemModel(CinderscapesItems.BRAMBLE_BERRIES);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(CinderscapesBlocks.BRAMBLE_BERRY_BUSH)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_3).register(stage -> BlockStateVariant.create()
                        .put(VariantSettings.MODEL, generator.createSubModel(CinderscapesBlocks.BRAMBLE_BERRY_BUSH,
                                "_stage" + stage, Models.CROSS, TextureMap::cross)))));
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(CinderscapesItems.ASH_PILE, Models.GENERATED);
        generator.register(CinderscapesItems.SULFUR, Models.GENERATED);

        generator.register(CinderscapesItems.ROSE_QUARTZ, Models.GENERATED);
        generator.register(CinderscapesItems.SMOKY_QUARTZ, Models.GENERATED);
        generator.register(CinderscapesItems.SULFUR_QUARTZ, Models.GENERATED);

        // Block items with provided item textures
        generator.register(CinderscapesItems.CRYSTINIUM, Models.GENERATED);
        generator.register(CinderscapesItems.GHASTLY_ECTOPLASM, Models.GENERATED);
        generator.register(CinderscapesItems.LUMINOUS_POD, Models.GENERATED);
        generator.register(CinderscapesItems.PYRACINTH, Models.GENERATED);
        generator.register(CinderscapesItems.PHOTOFERN, Models.GENERATED);
        generator.register(CinderscapesItems.SCORCHED_SPROUTS, Models.GENERATED);
        generator.register(CinderscapesItems.TALL_PHOTOFERN, Models.GENERATED);
        generator.register(CinderscapesItems.TWILIGHT_FESCUES, Models.GENERATED);

        // Armor items with Cinderscapes trim materials
        this.registerArmorTrims(generator, Items.TURTLE_HELMET, EquipmentAssetKeys.TURTLE_SCUTE, "helmet", false);
        this.registerArmorTrims(generator, Items.LEATHER_HELMET, EquipmentAssetKeys.LEATHER, "helmet", true);
        this.registerArmorTrims(generator, Items.LEATHER_CHESTPLATE, EquipmentAssetKeys.LEATHER, "chestplate", true);
        this.registerArmorTrims(generator, Items.LEATHER_LEGGINGS, EquipmentAssetKeys.LEATHER, "leggings", true);
        this.registerArmorTrims(generator, Items.LEATHER_BOOTS, EquipmentAssetKeys.LEATHER, "boots", true);
        this.registerArmorTrims(generator, Items.CHAINMAIL_HELMET, EquipmentAssetKeys.CHAINMAIL, "helmet", false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssetKeys.CHAINMAIL, "chestplate", false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_LEGGINGS, EquipmentAssetKeys.CHAINMAIL, "leggings", false);
        this.registerArmorTrims(generator, Items.CHAINMAIL_BOOTS, EquipmentAssetKeys.CHAINMAIL, "boots", false);
        this.registerArmorTrims(generator, Items.IRON_HELMET, EquipmentAssetKeys.IRON, "helmet", false);
        this.registerArmorTrims(generator, Items.IRON_CHESTPLATE, EquipmentAssetKeys.IRON, "chestplate", false);
        this.registerArmorTrims(generator, Items.IRON_LEGGINGS, EquipmentAssetKeys.IRON, "leggings", false);
        this.registerArmorTrims(generator, Items.IRON_BOOTS, EquipmentAssetKeys.IRON, "boots", false);
        this.registerArmorTrims(generator, Items.DIAMOND_HELMET, EquipmentAssetKeys.DIAMOND, "helmet", false);
        this.registerArmorTrims(generator, Items.DIAMOND_CHESTPLATE, EquipmentAssetKeys.DIAMOND, "chestplate", false);
        this.registerArmorTrims(generator, Items.DIAMOND_LEGGINGS, EquipmentAssetKeys.DIAMOND, "leggings", false);
        this.registerArmorTrims(generator, Items.DIAMOND_BOOTS, EquipmentAssetKeys.DIAMOND, "boots", false);
        this.registerArmorTrims(generator, Items.GOLDEN_HELMET, EquipmentAssetKeys.GOLD, "helmet", false);
        this.registerArmorTrims(generator, Items.GOLDEN_CHESTPLATE, EquipmentAssetKeys.GOLD, "chestplate", false);
        this.registerArmorTrims(generator, Items.GOLDEN_LEGGINGS, EquipmentAssetKeys.GOLD, "leggings", false);
        this.registerArmorTrims(generator, Items.GOLDEN_BOOTS, EquipmentAssetKeys.GOLD, "boots", false);
        this.registerArmorTrims(generator, Items.NETHERITE_HELMET, EquipmentAssetKeys.NETHERITE, "helmet", false);
        this.registerArmorTrims(generator, Items.NETHERITE_CHESTPLATE, EquipmentAssetKeys.NETHERITE, "chestplate", false);
        this.registerArmorTrims(generator, Items.NETHERITE_LEGGINGS, EquipmentAssetKeys.NETHERITE, "leggings", false);
        this.registerArmorTrims(generator, Items.NETHERITE_BOOTS, EquipmentAssetKeys.NETHERITE, "boots", false);
    }


    private void registerPottedPlantOnly(BlockStateModelGenerator generator, Block plant, Block pottedPlant) {
        registerPottedPlantOnly(generator, plant, pottedPlant, false);
    }

    private void registerPottedPlantOnly(BlockStateModelGenerator generator, Block plant, Block pottedPlant, boolean usePottedTexture) {
        TextureMap pottedTextures = usePottedTexture ?
                BlockStateModelGenerator.CrossType.NOT_TINTED.getFlowerPotTextureMap(pottedPlant) :
                BlockStateModelGenerator.CrossType.NOT_TINTED.getFlowerPotTextureMap(plant);
        Identifier pottedModelId = BlockStateModelGenerator.CrossType.NOT_TINTED.getFlowerPotCrossModel()
                .upload(pottedPlant, pottedTextures, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator
                .createSingletonBlockState(pottedPlant, pottedModelId));
    }

    private void registerPolyp(BlockStateModelGenerator generator, Block polyp) {
        // Cribbed somewhat from BlockStateModelGenerator.registerCoralFan(), but with only one Block
        // involved and downward orientation added, the variants are more like a dispenser...
        TexturedModel floorPolypModel = TexturedModel.CORAL_FAN.get(polyp);
        Identifier floorPolypId = floorPolypModel.upload(polyp, "_floor", generator.modelCollector);
//        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(polyp, floorPolypId));
        Identifier wallPolypId = Models.CORAL_WALL_FAN
                .upload(polyp, "_wall", floorPolypModel.getTextures(), generator.modelCollector);

        generator.blockStateCollector
                .accept(
                        VariantsBlockStateSupplier.create(polyp)
                                .coordinate(
                                        BlockStateVariantMap.create(PolypiteQuartzBlock.DIRECTION)
                                                .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.MODEL, floorPolypId))
                                                .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.MODEL, floorPolypId).put(VariantSettings.X, VariantSettings.Rotation.R180))
                                                .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.MODEL, wallPolypId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                                .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.MODEL, wallPolypId).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                                .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.MODEL, wallPolypId))
                                                .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.MODEL, wallPolypId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                )
                );

        generator.registerItemModel(polyp);
    }

    private void registerCubeColumn(BlockStateModelGenerator generator, Block cubeColumn) {
        // Put together from the hard-coded mess in BlockTexturePool that can only handle vanilla blocks
        TexturedModel columnModel = TexturedModel.CUBE_COLUMN.get(cubeColumn)
                .textures(textures -> textures.put(TextureKey.SIDE, TextureMap.getId(cubeColumn)));
        Identifier modelId = columnModel.upload(cubeColumn, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(cubeColumn, modelId));
    }


    /*
     * Shorthand for registering just the item model of a block item which uses its block's model.
     */
    private void registerBlockItemModel(BlockStateModelGenerator generator, Block block) {
        generator.registerParentedItemModel(block, ModelIds.getBlockModelId(block));
    }

    private void uploadArmor(ItemModelGenerator generator, Identifier id, Identifier layer0, Identifier layer1) {
        Models.GENERATED_TWO_LAYERS.upload(id, TextureMap.layered(layer0, layer1), generator.modelCollector);
    }

    private void uploadArmor(ItemModelGenerator generator, Identifier id, Identifier layer0, Identifier layer1, Identifier layer2) {
        Models.GENERATED_THREE_LAYERS.upload(id, TextureMap.layered(layer0, layer1, layer2), generator.modelCollector);
    }

    private void registerArmorTrims(ItemModelGenerator generator, Item armor, RegistryKey<EquipmentAsset> equipmentKey, String armorType, boolean dyeable) {
        Identifier armorModelId = ModelIds.getItemModelId(armor);
        Identifier armorTextures = TextureMap.getId(armor);
        Identifier armorOverlayTextures = TextureMap.getSubId(armor, "_overlay");
        for (ItemModelGenerator.TrimMaterial trimMaterial : TRIM_MATERIALS) {
            Identifier trimmedModelId = Identifier.of(Cinderscapes.MOD_ID,
                    armorModelId.getPath()).withSuffixedPath("_" + trimMaterial.name() + "_trim");
            Identifier trimTextureId = Identifier.ofVanilla(
                    "trims/items/" + armorType + "_trim_" + trimMaterial.texture(equipmentKey));
            if (dyeable) {
                this.uploadArmor(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
            } else {
                this.uploadArmor(generator, trimmedModelId, armorTextures, trimTextureId);
            }
        }
    }
}
