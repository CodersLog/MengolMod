package coders.meng.entity.client.enderchicken;

import coders.meng.Mengol;
import coders.meng.entity.client.dragon.PigDragonEggModel;
import coders.meng.entity.custom.dragon.PigDragonEggEntity;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ChickenDragonEggRenderer extends GeoEntityRenderer<ChickenDragonEggEntity> {
    public ChickenDragonEggRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ChickenDragonEggModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(ChickenDragonEggEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public RenderLayer getRenderType(ChickenDragonEggEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}