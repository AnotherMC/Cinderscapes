package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class CinderscapesSoundEvents {
	// Acts as a kind of local registry for sound events added by Cinderscapes
	private static final Map<Identifier, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

	public static final SoundEvent ASHY_SHOALS_MUSIC = add("music.nether.ashy_shoals");
	public static final SoundEvent BLACKSTONE_SHALES_MUSIC = add("music.nether.blackstone_shales");
	public static final SoundEvent LUMINOUS_GROVE_MUSIC = add("music.nether.luminous_grove");
	public static final SoundEvent QUARTZ_CAVERN_MUSIC = add("music.nether.quartz_cavern");

	public static final SoundEvent MENU_MUSIC = add("music.menu");

	public static final SoundEvent MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc.luminous_plantation");
	public static final SoundEvent MUSIC_DISC_CHILLING_IN_HELL = add("music_disc.chilling_in_hell");

	private static SoundEvent add(String path) {
		Identifier id = Identifier.of(Cinderscapes.MOD_ID, path);
		SoundEvent event = SoundEvent.of(id);

		SOUND_EVENTS.put(id, event);

		return event;
	}

	public static void init() {
		for (Identifier id : SOUND_EVENTS.keySet()) {
			Registry.register(Registries.SOUND_EVENT, id, SOUND_EVENTS.get(id));
		}
	}
}
