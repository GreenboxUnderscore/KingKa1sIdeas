package net.kingka1sideas;

import net.fabricmc.api.ModInitializer;
import net.kingka1sideas.registry.*;
import net.kingka1sideas.world.gen.KingKa1sOreGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KingKa1sIdeasMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final String MODID = "kingka1sideas";

	@Override
	public void onInitialize() {
		KingKa1sOreGenerate.load();
		KingKa1sItems.load();
		KingKa1sWeapons.load();
		KingKa1sTools.load();
		KingKa1sArmor.load();
		KingKa1sBlocks.load();
	}
}
