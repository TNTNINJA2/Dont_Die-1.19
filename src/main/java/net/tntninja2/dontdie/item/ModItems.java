package net.tntninja2.dontdie.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.ModBlocks;

public class ModItems {
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ItemGroupExample)));
//    Add more items by copying ^^ , lines in en_us, models/item/mythril_ingot_from_smelting_mythril_ore.json, mythril_ingot.png
//    and replace all instances of mythril_ingot with new item name
//      Also anything with mythril in the name is meant as an example and is not going to be a part of the final mod

    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.ItemGroupExample)));

    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                    new FabricItemSettings().group(ModItemGroup.ItemGroupExample)));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().group(ModItemGroup.ItemGroupExample)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(4f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200)
                                    , 1).build())));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DontDie.MOD_ID, name), item);

    }

    public static void registerModItems() {
        DontDie.LOGGER.info("Registering Mod Items for " + DontDie.MOD_ID);
    }
}