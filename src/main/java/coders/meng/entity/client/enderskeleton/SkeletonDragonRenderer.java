package coders.meng.entity.client.enderskeleton;

import coders.meng.Mengol;
import coders.meng.entity.client.enderchicken.DragonChickenModel;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SkeletonDragonRenderer extends GeoEntityRenderer<SkeletonDragonEntity> {
    public SkeletonDragonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SkeletonDragonModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(SkeletonDragonEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/skeletondragon.png");
    }

    @Override
    public RenderLayer getRenderType(SkeletonDragonEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}