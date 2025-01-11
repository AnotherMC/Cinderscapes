package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Map;

public final class CinderscapesRegistryAliases {
	@SuppressWarnings("UnnecessaryReturnStatement")
	private CinderscapesRegistryAliases() {
		return;
	}

	// Use Fabric registry aliases to repair identifier changes
	public static void init() {
		registerStatic();
		DynamicRegistrySetupCallback.EVENT.register(listener -> listener
				.getOptional(RegistryKeys.TRIM_MATERIAL)
				.ifPresent(CinderscapesRegistryAliases::registerTrimMaterials));
	}

	private static void registerStatic() {
	}

	private static void registerTrimMaterials(Registry<ArmorTrimMaterial> trimMaterialRegistry) {
		// Armor Trims
		Map<Identifier, Identifier> TRIMS = Map.ofEntries(
				entry("rose_quartz",   "cinderscapes_rose_quartz"),
				entry("smoky_quartz",  "cinderscapes_smoky_quartz"),
				entry("sulfur_quartz", "cinderscapes_sulfur_quartz")
		);
		Cinderscapes.LOGGER.warn("Any alias warnings about trim_material which follow this message are harmless.");
		TRIMS.forEach(trimMaterialRegistry::addAlias);
	}

	private static Map.Entry<Identifier, Identifier> entry(String oldName, String newName) {
		return Map.entry(Identifier.of(Cinderscapes.MOD_ID, oldName), Identifier.of(Cinderscapes.MOD_ID, newName));
	}
}
