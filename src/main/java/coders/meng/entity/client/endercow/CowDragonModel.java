package coders.meng.entity.client.endercow;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.endercow.CowDragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CowDragonModel extends AnimatedGeoModel<CowDragonEntity> {

    @Override
    public Identifier getModelResource(CowDragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/cowdragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(CowDragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/cowdragon.png");
    }

    @Override
    public Identifier getAnimationResource(CowDragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/cowdragon.animation.json");
    }
}
