package net.tntninja2.dontdie.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.item.custom.MythrilIngotItem;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new MythrilIngotItem(new FabricItemSettings().group(ItemGroup.MISC)));
//    add more items by copying ^^ , lines in en_us, models/item/mythril_ingot.json, mythril_ingot.png
//    and replace all instances of mythril_ingot with new item name


//    public static final Item MYTHRIL_GOLEM_SPAWN_EGG = registerItem("mythril_golem_spawn_egg",
//            new SpawnEggItem(ModEntities.MYTHRIL_GOLEM, 999999, 000000,
//                    new FabricItemSettings().group(ItemGroup.MISC)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DontDie.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DontDie.LOGGER.info("Registering Mod Items for " + DontDie.MOD_ID);
    }
}