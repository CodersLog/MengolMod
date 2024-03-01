package coders.meng.entity.client.enderchicken;

import coders.meng.Mengol;
import coders.meng.entity.custom.dragon.PigDragonEggEntity;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChickenDragonEggModel extends AnimatedGeoModel<ChickenDragonEggEntity> {


    @Override
    public Identifier getModelResource(ChickenDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChickenDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(ChickenDragonEggEntity animatable) {
        return null;
    }
}
