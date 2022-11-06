package net.tntninja2.dontdie.block.entity;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.command.PlaySoundCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.item.ModItems;
import net.tntninja2.dontdie.screen.EnergyCoreScreenHandler;
import net.tntninja2.dontdie.screen.MythrilFurnaceScreenHandler;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

import java.util.ListIterator;

public class EnergyCoreBlockEntity extends BlockEntity implements IAnimatable, NamedScreenHandlerFactory, ImplementedInventory {
    private final AnimationFactory factory = new AnimationFactory(this);

    protected final PropertyDelegate propertyDelegate;
    private int upgradeTier;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);;

    public EnergyCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENERGY_CORE, pos, state);
        this.upgradeTier = 0;

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> EnergyCoreBlockEntity.this.pos.getX();
                    case 1 -> EnergyCoreBlockEntity.this.pos.getY();
                    case 2 -> EnergyCoreBlockEntity.this.pos.getZ();
                    case 3 -> EnergyCoreBlockEntity.this.upgradeTier;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                DontDie.LOGGER.info("setting tier");

                switch(index) {
                    case 0: EnergyCoreBlockEntity.this.upgradeTier = value;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<EnergyCoreBlockEntity>
                (this, "controller", 0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.getController().getCurrentAnimation() == null) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        }

        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Energy Core");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        DontDie.LOGGER.info("constructing a handler of size: " + this.size());
        return new EnergyCoreScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("energy_core_upgrade_tier", upgradeTier);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        upgradeTier = nbt.getInt("energy_core_upgrade_tier");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, EnergyCoreBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        if (entity.inventory.get(0).getOrCreateNbt().getBoolean("can_upgrade")) {
            entity.inventory.set(0, ItemStack.EMPTY);
            entity.upgradeTier++;
        }



    }

    public void upgrade() {
        this.upgradeTier++;
        this.inventory.set(0, ItemStack.EMPTY);
        DontDie.LOGGER.info("upgrading on client? " + this.getWorld().isClient());

    }
}
