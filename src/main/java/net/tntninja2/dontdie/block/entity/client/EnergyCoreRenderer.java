package net.tntninja2.dontdie.block.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.block.entity.EnergyCoreBlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class EnergyCoreRenderer extends GeoBlockRenderer<EnergyCoreBlockEntity> {
    public EnergyCoreRenderer(BlockEntityRendererFactory.Context context) {
        super(new EnergyCoreBlockModel());
    }

    @Override
    public RenderLayer getRenderType(EnergyCoreBlockEntity animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer,
                                     @Nullable VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {

        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
