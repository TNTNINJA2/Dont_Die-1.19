package net.tntninja2.dontdie.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.ModBlocks;
import net.tntninja2.dontdie.item.custom.CoreUpgradeItem;
import net.tntninja2.dontdie.item.custom.EnergyCoreItem;
import net.tntninja2.dontdie.item.custom.crystal.*;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE)));
//    Add more items by copying ^^ , lines in en_us, models/item/mythril_ingot_from_smelting_mythril_ore.json, mythril_ingot.png
//    and replace all instances of mythril_ingot with new item name
//      Also anything with mythril in the name is meant as an example and is not going to be a part of the final mod

    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE)));

    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                    new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE)));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(4f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200),
                                    1).build())));

    public static final Item ENERGY_CORE_ITEM = registerItem("energy_core",
            new EnergyCoreItem(ModBlocks.ENERGY_CORE,
                    new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE)));

    public static final Item ENERGY_CORE_UPGRADE_1 = registerItem("energy_core_upgrade_1",
            new CoreUpgradeItem(
                    new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE), 1));

    public static final Item ENERGY_CORE_UPGRADE_2 = registerItem("energy_core_upgrade_2",
            new CoreUpgradeItem(
                    new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE), 2));

    public static final Item ENERGY_CORE_UPGRADE_3 = registerItem("energy_core_upgrade_3",
            new CoreUpgradeItem(
                    new FabricItemSettings().group(ModItemGroup.ITEM_GROUP_EXAMPLE), 3));

    public static final Item LARGE_CELERITAS_CRYSTAL = registerItem("large_celeritas_crystal",
            new LargeCaeruleusCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_SANITAS_CRYSTAL = registerItem("large_sanitas_crystal",
            new LargeFlavasCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_FULVAS_CRYSTAL = registerItem("large_fulvas_crystal",
            new LargeFulvasCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_LIVIDUS_CRYSTAL = registerItem("large_lividus_crystal",
            new LargeLividusCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_PRASINUS_CRYSTAL = registerItem("large_prasinus_crystal",
            new LargePrasinusCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_PURPUREAS_CRYSTAL = registerItem("large_purpureas_crystal",
            new LargePurpureasCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_RUBER_CRYSTAL = registerItem("large_ruber_crystal",
            new LargeRuberCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item LARGE_VIRBUS_CRYSTAL = registerItem("large_viribus_crystal",
            new LargeTrandafirCrystalItem(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));

    public static final Item MEDIUM_RUBER_CRYSTAL = registerItem("medium_ruber_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.CRYSTAL_ITEM_GROUP)));



    private static Item registerItem(String name, Item item) {
        DontDie.LOGGER.info("Registering: " + name);
        return Registry.register(Registry.ITEM, new Identifier(DontDie.MOD_ID, name), item);

    }

    public static void registerModItems() {
        DontDie.LOGGER.info("Registering Mod Items for " + DontDie.MOD_ID);
    }
}