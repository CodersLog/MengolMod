package coders.meng.entity.client.enderskeleton;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SkeletonDragonModel extends AnimatedGeoModel<SkeletonDragonEntity> {

    @Override
    public Identifier getModelResource(SkeletonDragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/skeletondragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(SkeletonDragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/skeletondragon.png");
    }

    @Override
    public Identifier getAnimationResource(SkeletonDragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/skeletondragon.animation.json");
    }
}
