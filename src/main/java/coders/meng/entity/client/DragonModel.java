package coders.meng.entity.client;

import coders.meng.Mengol;
import coders.meng.entity.custom.DragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DragonModel extends AnimatedGeoModel<DragonEntity> {

    @Override
    public Identifier getModelResource(DragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(DragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragon.png");
    }

    @Override
    public Identifier getAnimationResource(DragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/dragon.animation.json");
    }
}