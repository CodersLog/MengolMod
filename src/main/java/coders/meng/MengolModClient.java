package coders.meng;

import coders.meng.entity.MengolEntities;
import coders.meng.entity.client.enderchicken.ChickenDragonEggRenderer;
import coders.meng.entity.client.enderchicken.DragonChickenRenderer;
import coders.meng.entity.client.dragon.DragonRenderer;
import coders.meng.entity.client.dragon.PigDragonEggRenderer;
import coders.meng.entity.client.endercow.CowDragonEggRenderer;
import coders.meng.entity.client.endercow.CowDragonRenderer;
import coders.meng.entity.client.endergolem.GolemDragonEggRenderer;
import coders.meng.entity.client.endergolem.GolemDragonRenderer;
import coders.meng.entity.client.enderskeleton.SkeletonDragonEggRenderer;
import coders.meng.entity.client.enderskeleton.SkeletonDragonRenderer;
import coders.meng.entity.client.nitrocreeper.CreeperDragonEggRenderer;
import coders.meng.entity.client.nitrocreeper.CreeperDragonRenderer;
import coders.meng.entity.client.venom.VenomDragonEggRenderer;
import coders.meng.entity.client.venom.VenomDragonRenderer;
import coders.meng.entity.custom.dragon.DragonEntity;
import coders.meng.entity.networking.ModPackets;
import coders.meng.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import static coders.meng.event.KeyInputHandler.flyUpKey;


public class MengolModClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();

        ModPackets.registerS2CPackets();

        EntityRendererRegistry.register(Mengol.MUTATED_EGG_ENTITY_ENTITY_TYPE, (context) ->
                new FlyingItemEntityRenderer(context));

        //pig
        EntityRendererRegistry.register(MengolEntities.DRAGON, DragonRenderer::new);
        EntityRendererRegistry.register(MengolEntities.PIGDRAGONEGG, PigDragonEggRenderer::new);

        //chicken
        EntityRendererRegistry.register(MengolEntities.CHICKENDRAGON, DragonChickenRenderer::new);
        EntityRendererRegistry.register(MengolEntities.CHICKENDRAGONEGG, ChickenDragonEggRenderer::new);

        //cow
        EntityRendererRegistry.register(MengolEntities.COWDRAGON, CowDragonRenderer::new);
        EntityRendererRegistry.register(MengolEntities.COWDRAGONEGG, CowDragonEggRenderer::new);

        //golem
        EntityRendererRegistry.register(MengolEntities.GOLEMDRAGON, GolemDragonRenderer::new);
        EntityRendererRegistry.register(MengolEntities.GOLEMDRAGONEGG, GolemDragonEggRenderer::new);

        //skeleton
        EntityRendererRegistry.register(MengolEntities.SKELETONDRAGON, SkeletonDragonRenderer::new);
        EntityRendererRegistry.register(MengolEntities.SKELETONDRAGONEGG, SkeletonDragonEggRenderer::new);

        //creeper
        EntityRendererRegistry.register(MengolEntities.CREEPERDRAGON, CreeperDragonRenderer::new);
        EntityRendererRegistry.register(MengolEntities.CREEPERDRAGONEGG, CreeperDragonEggRenderer::new);

        //venom
        EntityRendererRegistry.register(MengolEntities.VENOMDRAGON, VenomDragonRenderer::new);
        EntityRendererRegistry.register(MengolEntities.VENOMDRAGONEGG, VenomDragonEggRenderer::new);




    }
}
