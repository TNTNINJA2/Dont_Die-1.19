package net.tntninja2.dontdie;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.tntninja2.dontdie.block.ModBlocks;
import net.tntninja2.dontdie.block.entity.ModBlockEntities;
import net.tntninja2.dontdie.block.entity.client.EnergyCoreRenderer;
import net.tntninja2.dontdie.item.ModItems;
import net.tntninja2.dontdie.item.client.EnergyCoreItemModel;
import net.tntninja2.dontdie.item.client.EnergyCoreItemRenderer;
import net.tntninja2.dontdie.screen.ModScreenHandlers;
import net.tntninja2.dontdie.screen.MythrilFurnaceScreen;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class DontDieClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());


//        GeoItemRenderer.registerItemRenderer(ModItems.ENERGY_CORE_ITEM, new EnergyCoreItemRenderer());
        BlockEntityRendererRegistry.register(ModBlockEntities.ENERGY_CORE, EnergyCoreRenderer::new);


        HandledScreens.register(ModScreenHandlers.MYTHRIL_FURNACE_SCREEN_HANDLER, MythrilFurnaceScreen::new);
    }
}
