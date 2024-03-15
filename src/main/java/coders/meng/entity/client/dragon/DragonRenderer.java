package coders.meng.entity.client.dragon;

import coders.meng.Mengol;
import coders.meng.entity.custom.dragon.DragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DragonRenderer extends GeoEntityRenderer<DragonEntity> {
    public DragonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DragonModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureLocation(DragonEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/dragon.png");
    }

    @Override
    public RenderLayer getRenderType(DragonEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}