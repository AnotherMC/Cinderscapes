package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;

public class CinderscapesBlockLootTableProvider extends FabricBlockLootTableProvider {
	protected CinderscapesBlockLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		// simple blocks
		addDrop(CinderscapesBlocks.ASH_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CRYSTALLINE_QUARTZ, block -> oreDrops(block, Items.QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ, block -> oreDrops(block, CinderscapesItems.ROSE_QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ, block -> oreDrops(block, CinderscapesItems.SMOKY_QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ, block -> oreDrops(block, CinderscapesItems.SULFUR_QUARTZ));
		addDrop(CinderscapesBlocks.CRYSTINIUM);
		addDrop(CinderscapesBlocks.GHASTLY_ECTOPLASM, VanillaBlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.PHOTOFERN, VanillaBlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.PYRACINTH);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_ORE, block -> oreDrops(block, CinderscapesItems.ROSE_QUARTZ));
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
		addDrop(CinderscapesBlocks.SCORCHED_SHRUB, VanillaBlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.SCORCHED_SPROUTS, VanillaBlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.SCORCHED_TENDRILS);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_ORE, block -> oreDrops(block, CinderscapesItems.SMOKY_QUARTZ));
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
		addDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
		addDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
		addDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
		addDrop(CinderscapesBlocks.SULFUR_BLOCK);
		addDrop(CinderscapesBlocks.SULFUR_ORE, block -> oreDrops(block, CinderscapesItems.SULFUR));
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_ORE, block -> oreDrops(block, CinderscapesItems.SULFUR_QUARTZ));
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
		addDrop(CinderscapesBlocks.TWILIGHT_FESCUES, VanillaBlockLootTableGenerator::dropsWithShears);
		addDrop(CinderscapesBlocks.TWILIGHT_TENDRILS);
		addDrop(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
		addDrop(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
		addDropWithSilkTouch(CinderscapesBlocks.UMBRAL_NYLIUM, Blocks.NETHERRACK);
		addDrop(CinderscapesBlocks.UMBRAL_NYLIUM, block -> drops(block, Items.NETHERRACK));
		addDrop(CinderscapesBlocks.UMBRAL_WART_BLOCK);


		// wood building blocks
		// TODO: Consider bringing over the WoodBlocks interface from Terrestria
		addDrop(CinderscapesBlocks.SCORCHED_HYPHAE);
		addDrop(CinderscapesBlocks.SCORCHED_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);

		addDrop(CinderscapesBlocks.UMBRAL_FUNGUS);
		addDrop(CinderscapesBlocks.UMBRAL_HYPHAE);
		addDrop(CinderscapesBlocks.UMBRAL_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);


		// potted things
		addPottedPlantDrops(CinderscapesBlocks.POTTED_CRYSTINIUM);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_LUMINOUS_POD);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_PHOTOFERN);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_PYRACINTH);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_SCORCHED_SHRUB);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_SCORCHED_TENDRILS);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS);
		addPottedPlantDrops(CinderscapesBlocks.POTTED_UMBRAL_FUNGUS);


		// tall plant drops
		addDrop(CinderscapesBlocks.LUMINOUS_POD, block -> dropsWithShears(block).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))));
		addDrop(CinderscapesBlocks.TALL_PHOTOFERN, dropsWithShears(CinderscapesBlocks.PHOTOFERN).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))));


		// berry drops
		addDrop(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, block -> applyExplosionDecay(block, LootTable.builder()
			.pool(
				LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BrambleBerryBushBlock.AGE, 3)))
					.with(ItemEntry.builder(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)))
					.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
			)
			.pool(
				LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BrambleBerryBushBlock.AGE, 2)))
					.with(ItemEntry.builder(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
					.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
			)
		));

		addDrop(CinderscapesBlocks.ASH);
	}
}
