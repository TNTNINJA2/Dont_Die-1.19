package net.tntninja2.dontdie.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.entity.custom.ExampleMobEntity;



public class ModEntities {
    public static final EntityType<ExampleMobEntity> ExampleMob = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(DontDie.MOD_ID, "ExampleMob"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ExampleMobEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 1.5f)).build());
}
