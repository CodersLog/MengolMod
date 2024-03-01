package coders.meng.entity.client.enderchicken;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.Mengol;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DragonChickenModel extends AnimatedGeoModel<ChickenDragonEntity> {

    @Override
    public Identifier getModelResource(ChickenDragonEntity object) {
        return new Identifier(Mengol.MODID, "geo/chickendragon.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChickenDragonEntity object) {
        return new Identifier(Mengol.MODID, "textures/entity/chickendragon.png");
    }

    @Override
    public Identifier getAnimationResource(ChickenDragonEntity animatable) {
        return new Identifier(Mengol.MODID, "animations/chickendragonanimation.json");
    }
}
