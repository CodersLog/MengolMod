package coders.meng.entity.client.endergolem;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEggEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GolemDragonEggModel extends AnimatedGeoModel<GolemDragonEggEntity> {


    @Override
    public Identifier getModelResource(GolemDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(GolemDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(GolemDragonEggEntity animatable) {
        return null;
    }
}
