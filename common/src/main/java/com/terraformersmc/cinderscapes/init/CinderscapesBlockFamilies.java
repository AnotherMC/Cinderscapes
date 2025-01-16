package com.terraformersmc.cinderscapes.init;

import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class CinderscapesBlockFamilies {
	// Wood
	public static final BlockFamily SCORCHED = null;/*BlockFamilies.register(CinderscapesBlocks.SCORCHED_PLANKS)
			.button(CinderscapesBlocks.SCORCHED_BUTTON)
			.fence(CinderscapesBlocks.SCORCHED_FENCE)
			.fenceGate(CinderscapesBlocks.SCORCHED_FENCE_GATE)
			.pressurePlate(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE)
			.sign(CinderscapesBlocks.SCORCHED_SIGN, CinderscapesBlocks.SCORCHED_WALL_SIGN)
			.slab(CinderscapesBlocks.SCORCHED_SLAB)
			.stairs(CinderscapesBlocks.SCORCHED_STAIRS)
			.door(CinderscapesBlocks.SCORCHED_DOOR)
			.trapdoor(CinderscapesBlocks.SCORCHED_TRAPDOOR)
			.group("wooden")
			.unlockCriterionName("has_planks")
			.build();*/
	public static final BlockFamily UMBRAL = null;/*BlockFamilies.register(CinderscapesBlocks.UMBRAL_PLANKS)
			.button(CinderscapesBlocks.UMBRAL_BUTTON)
			.fence(CinderscapesBlocks.UMBRAL_FENCE)
			.fenceGate(CinderscapesBlocks.UMBRAL_FENCE_GATE)
			.pressurePlate(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE)
			.sign(CinderscapesBlocks.UMBRAL_SIGN, CinderscapesBlocks.UMBRAL_WALL_SIGN)
			.slab(CinderscapesBlocks.UMBRAL_SLAB)
			.stairs(CinderscapesBlocks.UMBRAL_STAIRS)
			.door(CinderscapesBlocks.UMBRAL_DOOR)
			.trapdoor(CinderscapesBlocks.UMBRAL_TRAPDOOR)
			.group("wooden")
			.unlockCriterionName("has_planks")
			.build();*/

	// Quartz
	public static final BlockFamily ROSE_QUARTZ_BLOCK = BlockFamilies.register(CinderscapesBlocks.ROSE_QUARTZ_BLOCK)
			//.stairs(CinderscapesBlocks.ROSE_QUARTZ_STAIRS)
			//.slab(CinderscapesBlocks.ROSE_QUARTZ_SLAB)
			// breaks model gen
			//.chiseled(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK)
			.noGenerateRecipes()
			.build();
	public static final BlockFamily SMOOTH_ROSE_QUARTZ = BlockFamilies.register(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ)
			//.stairs(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS)
			//.slab(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB)
			.build();
	public static final BlockFamily SMOKY_QUARTZ_BLOCK = BlockFamilies.register(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK)
			//.stairs(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS)
			//.slab(CinderscapesBlocks.SMOKY_QUARTZ_SLAB)
			// breaks model gen
			//.chiseled(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK)
			.noGenerateRecipes()
			.build();
	public static final BlockFamily SMOOTH_SMOKY_QUARTZ = BlockFamilies.register(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ)
			//.stairs(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS)
			//.slab(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB)
			.build();
	public static final BlockFamily SULFUR_QUARTZ_BLOCK = BlockFamilies.register(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK)
			//.stairs(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS)
			//.slab(CinderscapesBlocks.SULFUR_QUARTZ_SLAB)
			// breaks model gen
			//.chiseled(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK)
			.noGenerateRecipes()
			.build();
	public static final BlockFamily SMOOTH_SULFUR_QUARTZ = BlockFamilies.register(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ)
			//.stairs(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS)
			//.slab(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB)
			.build();
}
