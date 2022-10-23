package net.tntninja2.dontdie;

import net.fabricmc.api.ModInitializer;
import net.tntninja2.dontdie.block.ModBlocks;
import net.tntninja2.dontdie.block.entity.ModBlockEntities;
import net.tntninja2.dontdie.item.ModItems;
import net.tntninja2.dontdie.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DontDie implements ModInitializer {
	public static final String MOD_ID = "dontdie";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
//		This happens when minecraft starts
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModBlockEntities.registerAllBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();

	}
}
