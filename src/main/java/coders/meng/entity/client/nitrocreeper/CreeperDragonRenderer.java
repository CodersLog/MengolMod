package coders.meng.entity.client.nitrocreeper;

import coders.meng.Mengol;
import coders.meng.entity.client.enderchicken.DragonChickenModel;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CreeperDragonRenderer extends GeoEntityRenderer<CreeperDragonEntity> {
    public CreeperDragonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CreeperDragonModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(CreeperDragonEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/creeperdragon.png");
    }

    @Override
    public RenderLayer getRenderType(CreeperDragonEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}