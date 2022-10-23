package net.tntninja2.dontdie.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class ModScreenHandlers {
    public static ScreenHandlerType<MythrilFurnaceScreenHandler> MYTHRIL_FURNACE_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        MYTHRIL_FURNACE_SCREEN_HANDLER = new ScreenHandlerType<>(MythrilFurnaceScreenHandler::new);
    }
}
