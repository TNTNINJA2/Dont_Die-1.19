package net.tntninja2.dontdie.item.custom;

import net.minecraft.item.Item;

public class CoreUpgradeItem extends Item {
    public final int TIER;

    public CoreUpgradeItem(Settings settings, int tier) {
        super(settings);
        TIER = tier;
    }
}
