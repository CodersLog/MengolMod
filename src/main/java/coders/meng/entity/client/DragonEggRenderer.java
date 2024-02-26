package coders.meng.entity.client;

import coders.meng.Mengol;
import coders.meng.entity.custom.DragonEggEntity;
import coders.meng.entity.custom.DragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DragonEggRenderer   extends GeoEntityRenderer<DragonEggEntity> {
    public DragonEggRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DragonEggModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(DragonEggEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public RenderLayer getRenderType(DragonEggEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}