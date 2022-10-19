package net.tntninja2.dontdie.block.entity.client;

import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.entity.EnergyCoreBlockEntity;
import net.tntninja2.dontdie.item.custom.EnergyCoreItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnergyCoreBlockModel extends AnimatedGeoModel<EnergyCoreBlockEntity> {

    @Override
    public Identifier getModelResource(EnergyCoreBlockEntity object) {
        return new Identifier(DontDie.MOD_ID,"geo/energy_core.geo.json");
    }

    @Override
    public Identifier getTextureResource(EnergyCoreBlockEntity object) {
        return new Identifier(DontDie.MOD_ID,"textures/machines/energy_core.png");
    }

    @Override
    public Identifier getAnimationResource(EnergyCoreBlockEntity animatable) {
        return new Identifier(DontDie.MOD_ID,"animations/energy_core.animation.json");
    }
}
