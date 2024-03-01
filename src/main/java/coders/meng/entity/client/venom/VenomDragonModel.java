package coders.meng.entity.client.venom;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.venom.VenomDragonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VenomDragonModel extends AnimatedGeoModel<VenomDragonEntity> {

    @Override
    public Identifier getModelResource(VenomDragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/venomdragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(VenomDragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/venomdragon.png");
    }

    @Override
    public Identifier getAnimationResource(VenomDragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/venomdragon.animation.json");
    }
}
