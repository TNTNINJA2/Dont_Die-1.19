package net.tntninja2.dontdie.entity.client;

import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.entity.custom.ExampleMobEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ExampleMobModel extends AnimatedGeoModel<ExampleMobEntity> {
    @Override
    public Identifier getModelResource(ExampleMobEntity object) {
        return new Identifier(DontDie.MOD_ID, "geo/example_mob.geo.json");    }

    @Override
    public Identifier getTextureResource(ExampleMobEntity object) {
        return new Identifier(DontDie.MOD_ID, "textures/entity/example_mob_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ExampleMobEntity animatable) {
        return new Identifier(DontDie.MOD_ID, "animations/example_mob.animation.json");
    }
}
