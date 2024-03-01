package coders.meng.entity.client.dragon;

import coders.meng.Mengol;

import coders.meng.entity.custom.dragon.PigDragonEggEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PigDragonEggModel extends AnimatedGeoModel<PigDragonEggEntity> {


    @Override
    public Identifier getModelResource(PigDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(PigDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(PigDragonEggEntity animatable) {
        return null;
    }
}
