package net.tntninja2.dontdie.item.client;

import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.item.custom.EnergyCoreItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EnergyCoreItemModel extends AnimatedGeoModel<EnergyCoreItem> {
    @Override
    public Identifier getModelResource(EnergyCoreItem object) {
        return new Identifier(DontDie.MOD_ID,"geo/energy_core.geo.json");
    }

    @Override
    public Identifier getTextureResource(EnergyCoreItem object) {
        return new Identifier(DontDie.MOD_ID,"textures/machines/energy_core.png");
    }

    @Override
    public Identifier getAnimationResource(EnergyCoreItem animatable) {
        return new Identifier(DontDie.MOD_ID,"animations/energy_core.animation.json");
    }
}
