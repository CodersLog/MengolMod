package coders.meng.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MENGOL = "key.category.meng.Mengol";
    public static final String KEY_DRAGON_UP = "key.meng.flyUp";
    public static final String KEY_DRAGON_DOWN = "key.meng.flyDown";
    public static final String KEY_DRAGON_SHOOT = "key.meng.dragonshoot";

    public static KeyBinding flyUpKey;
    public static KeyBinding flyDownKey;
    public static KeyBinding ShootBallKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {




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

        ShootBallKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DRAGON_SHOOT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                KEY_CATEGORY_MENGOL
        ));

        registerKeyInputs();
    }
}