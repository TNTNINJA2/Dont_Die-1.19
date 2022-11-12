package net.tntninja2.dontdie.tag;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPointOfInterestTypeTags {
    public static final TagKey<PointOfInterestType> EXAMPLE = of("example");
    public static final TagKey<PointOfInterestType> ENERGY_CORE = of("energy_core");

    private ModPointOfInterestTypeTags() {
    }

    private static TagKey<PointOfInterestType> of(String id) {
        return TagKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(id));
    }
}
