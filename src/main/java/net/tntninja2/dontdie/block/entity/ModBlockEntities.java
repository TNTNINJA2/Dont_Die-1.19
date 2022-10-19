package net.tntninja2.dontdie.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<EnergyCoreBlockEntity> ENERGY_CORE;

    public static void registerAllBlockEntities() {
        ENERGY_CORE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(DontDie.MOD_ID, "energy_core"),
                FabricBlockEntityTypeBuilder.create(EnergyCoreBlockEntity::new,
                        ModBlocks.ENERGY_CORE).build(null));
    }
}
