package coders.meng.entity.client.endercow;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import coders.meng.entity.custom.endercow.CowDragonEggEntity;
import coders.meng.entity.custom.endercow.CowDragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CowDragonEggModel extends AnimatedGeoModel<CowDragonEggEntity> {


    @Override
    public Identifier getModelResource(CowDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(CowDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(CowDragonEggEntity animatable) {
        return null;
    }
}
