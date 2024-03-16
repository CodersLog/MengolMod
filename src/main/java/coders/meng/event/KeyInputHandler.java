package coders.meng.event;

import coders.meng.entity.networking.ModPackets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(value= EnvType.CLIENT)
public class KeyInputHandler {
    public static final String KEY_CATEGORY_MENGOL = "key.category.meng.Mengol";
    public static final String KEY_DRAGON_UP = "key.meng.flyUp";
    public static final String KEY_DRAGON_DOWN = "key.meng.flyDown";
    public static final String KEY_DRAGON_SHOOT = "key.meng.dragonshoot";
    public static final String KEY_DRAGON_BOOST = "key.meng.dragonboost";

    public static KeyBinding flyUpKey;
    public static KeyBinding flyDownKey;
    public static KeyBinding ShootBallKey;
    public static KeyBinding Boost;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(flyUpKey.isPressed()) {
                ClientPlayNetworking.send(ModPackets.FLYUP_ID, PacketByteBufs.create());
            }
            if(flyDownKey.wasPressed()) {

                ClientPlayNetworking.send(ModPackets.ISFLYING_ID, PacketByteBufs.create());

            }
            if(flyUpKey.wasPressed()) {

                ClientPlayNetworking.send(ModPackets.ISFLYING_ID, PacketByteBufs.create());

            }

            if(flyDownKey.isPressed()) {

                ClientPlayNetworking.send(ModPackets.FLYDOWN_ID, PacketByteBufs.create());

            }

            if(ShootBallKey.isPressed()) {

                ClientPlayNetworking.send(ModPackets.SHOOTBALL_ID, PacketByteBufs.create());

            }

            if(Boost.isPressed()) {

                ClientPlayNetworking.send(ModPackets.BOOST_ID, PacketByteBufs.create());

            }


        });
    }

    public static void register() {
        flyUpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DRAGON_UP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_SPACE,
                KEY_CATEGORY_MENGOL
        ));

        flyDownKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DRAGON_DOWN,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_CONTROL,
                KEY_CATEGORY_MENGOL
        ));

        Boost = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DRAGON_BOOST,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                KEY_CATEGORY_MENGOL
        ));

        ShootBallKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DRAGON_SHOOT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                KEY_CATEGORY_MENGOL
        ));

        registerKeyInputs();
    }
}