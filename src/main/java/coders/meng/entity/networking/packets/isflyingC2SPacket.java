package coders.meng.entity.networking.packets;

import coders.meng.entity.custom.dragon.DragonEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class isflyingC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {

        Entity e = player.getVehicle();

        assert e != null;
        if(e.world.getBlockState(new BlockPos(e.getX(),e.getY() -1,e.getZ())).getBlock() == Blocks.AIR && player.hasVehicle() && player.getVehicle() instanceof DragonEntity) {

            DragonEntity.WhenFlying(e);
        }

        else if(e.world.getBlockState(new BlockPos(e.getX(),e.getY() -1,e.getZ())).getBlock() != Blocks.AIR && player.hasVehicle() && player.getVehicle() instanceof  DragonEntity) {

            DragonEntity.WhenNotFlying(e);

        }


    }

}
