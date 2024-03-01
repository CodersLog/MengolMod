package coders.meng.entity.client.endergolem;

import coders.meng.Mengol;
import coders.meng.entity.client.enderchicken.DragonChickenModel;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GolemDragonRenderer extends GeoEntityRenderer<GolemDragonEntity> {
    public GolemDragonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GolemDragonModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(GolemDragonEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/golemdragon.png");
    }

    @Override
    public RenderLayer getRenderType(GolemDragonEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}