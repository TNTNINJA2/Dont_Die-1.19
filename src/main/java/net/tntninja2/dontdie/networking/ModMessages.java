package net.tntninja2.dontdie.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.networking.packet.EnergyCoreUpgradeC2SPacket;

public class ModMessages {
    public static final Identifier ENERGY_CORE_UPGRADE_ID = new Identifier(DontDie.MOD_ID, "energy_core_upgrade");


    public static void registerC2SPackets() {

        ServerPlayNetworking.registerGlobalReceiver(ENERGY_CORE_UPGRADE_ID, EnergyCoreUpgradeC2SPacket::receive);
    }

    public static void registerS2CPackets() {

//        ClientPlayNetworking.registerGlobalReceiver(CORE_UPGRADE_ID, SlateCannonLaserS2CPacket::receive);



    }

}