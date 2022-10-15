package net.tntninja2.dontdie.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.DontDie;

public class ModItemGroup {

    public static final ItemGroup ItemGroupExample = FabricItemGroupBuilder.build(
            new Identifier(DontDie.MOD_ID, "item_group_example"), () -> new ItemStack(ModItems.MYTHRIL_INGOT));
//    Copy and paste the lines above and replace all instances of ItemGroupExample with name and add translation in lang.
//    The itemstack that it takes in is the item that is displayed on the group.
}
