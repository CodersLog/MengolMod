package coders.meng.entity.client.venom;

import coders.meng.Mengol;
import coders.meng.entity.client.enderchicken.DragonChickenModel;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.venom.VenomDragonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class VenomDragonRenderer extends GeoEntityRenderer<VenomDragonEntity> {
    public VenomDragonRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new VenomDragonModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(VenomDragonEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/venomdragon.png");
    }

    @Override
    public RenderLayer getRenderType(VenomDragonEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}