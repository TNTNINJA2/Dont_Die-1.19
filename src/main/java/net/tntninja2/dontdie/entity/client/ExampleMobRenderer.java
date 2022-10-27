package net.tntninja2.dontdie.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.entity.custom.ExampleMobEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ExampleMobRenderer extends GeoEntityRenderer<ExampleMobEntity>  {
    public ExampleMobRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ExampleMobModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(ExampleMobEntity entity) {
        return new Identifier(DontDie.MOD_ID, "textures/entity/example_mob_texture.png");
    }

    @Override
    public RenderLayer getRenderType(ExampleMobEntity animatable,
                                     float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer,
                                     @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f,0.8f, 0.8f);


        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

