package coders.meng.entity.client.enderskeleton;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEggEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SkeletonDragonEggModel extends AnimatedGeoModel<SkeletonDragonEggEntity> {


    @Override
    public Identifier getModelResource(SkeletonDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(SkeletonDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(SkeletonDragonEggEntity animatable) {
        return null;
    }
}
