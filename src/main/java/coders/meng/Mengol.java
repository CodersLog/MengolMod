package coders.meng;

import coders.meng.entity.MengolEntities;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.dragon.DragonEntity;
import coders.meng.entity.custom.endercow.CowDragonEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEntity;
import coders.meng.entity.custom.venom.VenomDragonEntity;
import coders.meng.items.MengolItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Mengol implements ModInitializer {

	public static final Identifier CHICKENDRAGONSCREAM = new Identifier("meng:chickendragonscream");
	public static SoundEvent CHICKENDRAGONSCREAMSOUNDEVENT = new SoundEvent(CHICKENDRAGONSCREAM);
	public static final String MODID = "meng";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		Registry.register(Registry.SOUND_EVENT, CHICKENDRAGONSCREAM, CHICKENDRAGONSCREAMSOUNDEVENT);

		MengolItems.registerModItems();
		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(MengolEntities.DRAGON, DragonEntity.createAttributesDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.PIGDRAGONEGG, DragonEntity.createAttributesDragon());

		//chicken
		FabricDefaultAttributeRegistry.register(MengolEntities.CHICKENDRAGON, ChickenDragonEntity.createAttributesChickenDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.CHICKENDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());

		//cow
		FabricDefaultAttributeRegistry.register(MengolEntities.COWDRAGON, CowDragonEntity.createAttributesCowDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.COWDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());

		//golem
		FabricDefaultAttributeRegistry.register(MengolEntities.GOLEMDRAGON, GolemDragonEntity.createAttributesGolemDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.GOLEMDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());

		//skeleton
		FabricDefaultAttributeRegistry.register(MengolEntities.SKELETONDRAGON, SkeletonDragonEntity.createAttributesSkeletonDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.SKELETONDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());

		//creeper
		FabricDefaultAttributeRegistry.register(MengolEntities.CREEPERDRAGON, CreeperDragonEntity.createAttributesCreeperDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.CREEPERDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());

		//venom
		FabricDefaultAttributeRegistry.register(MengolEntities.VENOMDRAGON, VenomDragonEntity.createAttributesVenomDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.VENOMDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());
	}
}