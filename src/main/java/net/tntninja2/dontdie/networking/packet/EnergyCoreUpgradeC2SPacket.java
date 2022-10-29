package net.tntninja2.dontdie.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.entity.EnergyCoreBlockEntity;

public class EnergyCoreUpgradeC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //Everything here ONLY happens on the server
        ServerWorld world = player.getWorld();
        BlockPos pos = buf.readBlockPos();
        DontDie.LOGGER.info("pos is: " + pos.getX() + " " + pos.getY() + " " + pos.getZ());
        DontDie.LOGGER.info("actual pos is: " +  world.getChunk(pos).getBlockEntityPositions());
        BlockEntity blockEntity = world.getChunk(pos).getBlockEntity(pos);

        assert blockEntity != null;
        DontDie.LOGGER.info("the block entity is of class " + blockEntity.getClass());

        if (blockEntity instanceof EnergyCoreBlockEntity energyCore) {
            energyCore.upgrade();
        }

        DontDie.LOGGER.info("packet recieved");


    }


}
