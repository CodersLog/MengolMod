package coders.meng.entity.client.nitrocreeper;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CreeperDragonModel extends AnimatedGeoModel<CreeperDragonEntity> {

    @Override
    public Identifier getModelResource(CreeperDragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/creeperdragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(CreeperDragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/creeperdragon.png");
    }

    @Override
    public Identifier getAnimationResource(CreeperDragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/creeperdragon.animation.json");
    }
}
