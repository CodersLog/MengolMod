package coders.meng.entity.client.endergolem;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GolemDragonModel extends AnimatedGeoModel<GolemDragonEntity> {

    @Override
    public Identifier getModelResource(GolemDragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/golemdragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(GolemDragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/golemdragon.png");
    }

    @Override
    public Identifier getAnimationResource(GolemDragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/golemdragon.animation.json");
    }
}
