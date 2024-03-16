package coders.meng.entity.networking;

import coders.meng.Mengol;
import coders.meng.entity.networking.packets.*;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {

    public static final Identifier FLYUP_ID = new Identifier(Mengol.MODID, "flyup");
    public static final Identifier FLYDOWN_ID = new Identifier(Mengol.MODID, "flydown");
    public static final Identifier SHOOTBALL_ID = new Identifier(Mengol.MODID, "shootball");
    public static final Identifier BOOST_ID = new Identifier(Mengol.MODID, "boost");

    public static final Identifier ISFLYING_ID = new Identifier(Mengol.MODID, "isflying");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(FLYUP_ID, flyupC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(FLYDOWN_ID, flydownC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(SHOOTBALL_ID, shootC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(BOOST_ID, boostC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(ISFLYING_ID, isflyingC2SPacket::receive);



    }

    public static void registerS2CPackets() {




    }

}
