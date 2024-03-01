package coders.meng.entity.client.nitrocreeper;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEggEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CreeperDragonEggModel extends AnimatedGeoModel<CreeperDragonEggEntity> {


    @Override
    public Identifier getModelResource(CreeperDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "geo/dragonegg.geo.json");
    }

    @Override
    public Identifier getTextureResource(CreeperDragonEggEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/dragonegg.png");
    }

    @Override
    public Identifier getAnimationResource(CreeperDragonEggEntity animatable) {
        return null;
    }
}
