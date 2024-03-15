package coders.meng.entity.client.dragon;



import coders.meng.Mengol;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import coders.meng.entity.custom.dragon.PigDragonEggEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PigDragonEggRenderer extends GeoEntityRenderer<PigDragonEggEntity> {
    public PigDragonEggRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PigDragonEggModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureLocation(PigDragonEggEntity instance) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }


    @Override
    public RenderLayer getRenderType(PigDragonEggEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
       stack.scale(1f,1f,1f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}