package coders.meng.entity.client;

import coders.meng.Mengol;
import coders.meng.entity.custom.DragonEggEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DragonEggModel extends AnimatedGeoModel<DragonEggEntity> {


    @Override
    public Identifier getModelResource(DragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(DragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(DragonEggEntity animatable) {
        return null;
    }
}
