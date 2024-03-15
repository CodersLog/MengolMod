package coders.meng.entity.client.nitrocreeper;

import coders.meng.Mengol;
import coders.meng.entity.client.enderchicken.ChickenDragonEggModel;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEggEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CreeperDragonEggRenderer extends GeoEntityRenderer<CreeperDragonEggEntity> {
    public CreeperDragonEggRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CreeperDragonEggModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(CreeperDragonEggEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public RenderLayer getRenderType(CreeperDragonEggEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}