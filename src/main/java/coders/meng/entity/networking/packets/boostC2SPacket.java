package coders.meng.entity.networking.packets;

import coders.meng.entity.custom.dragon.DragonEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class boostC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        Entity e = player.getVehicle();

        if(player.hasVehicle() && player.getVehicle() instanceof DragonEntity) {

            assert e != null;
            DragonEntity.BoostPressed(player,e);
        }


    }

}
