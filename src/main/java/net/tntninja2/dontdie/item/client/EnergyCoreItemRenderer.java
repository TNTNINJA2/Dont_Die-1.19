package net.tntninja2.dontdie.item.client;

import net.tntninja2.dontdie.item.custom.EnergyCoreItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class EnergyCoreItemRenderer extends GeoItemRenderer<EnergyCoreItem> {
    public EnergyCoreItemRenderer() {
        super(new EnergyCoreItemModel());
    }
}
