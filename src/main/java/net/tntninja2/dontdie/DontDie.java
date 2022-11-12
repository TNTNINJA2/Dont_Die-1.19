package net.tntninja2.dontdie;

import com.mojang.datafixers.types.templates.Tag;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.data.server.PointOfInterestTypeTagProvider;
import net.minecraft.tag.TagBuilder;
import net.minecraft.tag.TagGroupLoader;
import net.minecraft.tag.TagManagerLoader;
import net.tntninja2.dontdie.block.ModBlocks;
import net.tntninja2.dontdie.block.entity.ModBlockEntities;
import net.tntninja2.dontdie.entity.ModEntities;
import net.tntninja2.dontdie.entity.custom.ExampleMobEntity;
import net.tntninja2.dontdie.item.ModItems;
import net.tntninja2.dontdie.networking.ModMessages;
import net.tntninja2.dontdie.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

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


		ModScreenHandlers.registerAllScreenHandlers();

		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(ModEntities.EXAMPLE_MOB, ExampleMobEntity.setAttributes());


		ModBlockEntities.registerAllBlockEntities();

		ModMessages.registerC2SPackets();
		ModMessages.registerS2CPackets();

	}
}
