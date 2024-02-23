package coders.meng;

import coders.meng.entity.MengolEntities;
import coders.meng.entity.client.DragonRenderer;
import coders.meng.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MengolModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();
        EntityRendererRegistry.register(MengolEntities.DRAGON, DragonRenderer::new);
    }
}
