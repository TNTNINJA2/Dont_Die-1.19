package net.tntninja2.dontdie.screen;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.MinecraftVersion;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.WorldChunk;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.entity.EnergyCoreBlockEntity;
import net.tntninja2.dontdie.block.entity.MythrilFurnaceBlockEntity;
import net.tntninja2.dontdie.item.ModItems;
import net.tntninja2.dontdie.item.custom.CoreUpgradeItem;
import net.tntninja2.dontdie.networking.ModMessages;
import org.apache.logging.log4j.core.jmx.Server;

public class EnergyCoreScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public EnergyCoreScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(3), new ArrayPropertyDelegate(4));

    }

    public EnergyCoreScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.ENERGY_CORE_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        this.addSlot(new Slot(inventory, 0, 80, 7));

        for (int i = 1; i < inventory.size(); i++) {
            this.addSlot(new Slot(inventory, i, -10 + 18 * i, 53));
        }
        DontDie.LOGGER.info("creating a handler with inventory of size: " + inventory.size());
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }



    public void upgrade() {
        DontDie.LOGGER.info("trying to upgrade");
        if (this.inventory.getStack(0).getItem() instanceof CoreUpgradeItem) {
            DontDie.LOGGER.info("item is an upgrade item");

            ItemStack upgradeItemStack = this.inventory.getStack(0);
            CoreUpgradeItem upgradeItem = ((CoreUpgradeItem) upgradeItemStack.getItem());
            if (upgradeItem.TIER == this.propertyDelegate.get(3) + 1) {
                DontDie.LOGGER.info("item is correct tier");

                PacketByteBuf buf = PacketByteBufs.create();
                BlockPos blockPos = new BlockPos(this.propertyDelegate.get(0), this.propertyDelegate.get(1), this.propertyDelegate.get(2));
                buf.writeBlockPos(blockPos);
                ClientPlayNetworking.send(ModMessages.ENERGY_CORE_UPGRADE_ID, buf);
                ClientWorld clientWorld = MinecraftClient.getInstance().world;
                if (clientWorld != null) {
                    BlockEntity blockEntity = clientWorld.getChunk(blockPos).getBlockEntity(blockPos);
                    if (blockEntity instanceof EnergyCoreBlockEntity energyCoreBlockEntity) {
                        energyCoreBlockEntity.upgrade();
                        DontDie.LOGGER.info("found core on client");

                    }
                }

            }

        }

    }




    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }


    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public void setProperty(int id, int value) {
        super.setProperty(id, value);
        this.sendContentUpdates();
    }

}
