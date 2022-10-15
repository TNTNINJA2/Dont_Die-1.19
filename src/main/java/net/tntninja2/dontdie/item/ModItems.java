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
            new Item(new FabricItemSettings().group(ModItemGroup.ItemGroupExample)));
//    Add more items by copying ^^ , lines in en_us, models/item/mythril_ingot_from_smelting_mythril_ore.json, mythril_ingot.png
//    and replace all instances of mythril_ingot with new item name
//      Also anything with mythril in the name is meant as an example and is not going to be a part of the final mod

    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.ItemGroupExample)));





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DontDie.MOD_ID, name), item);

    }

    public static void registerModItems() {
        DontDie.LOGGER.info("Registering Mod Items for " + DontDie.MOD_ID);
    }
}