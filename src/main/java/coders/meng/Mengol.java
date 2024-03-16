package coders.meng;

import coders.meng.entity.MengolEntities;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.dragon.DragonEntity;
import coders.meng.entity.custom.endercow.CowDragonEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEntity;

import coders.meng.entity.custom.nitrocreeper.CreeperDragonEntity;
import coders.meng.entity.custom.venom.VenomDragonEntity;
import coders.meng.entity.networking.ModPackets;
import coders.meng.items.MengolItems;
import coders.meng.items.custom.itementitys.MutatedEggEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Mengol implements ModInitializer {

	public static final Identifier CHICKENDRAGONSCREAM = new Identifier("meng:chickendragonscream");
	public static final Identifier CHICKENDRAGONHURT = new Identifier("meng:chickendragonhurt");



	public static SoundEvent CHICKENDRAGONSCREAMSOUNDEVENT = new SoundEvent(CHICKENDRAGONSCREAM);
	public static SoundEvent CHICKENDRAGONHURTEVENT = new SoundEvent(CHICKENDRAGONHURT);



	public static final String MODID = "meng";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final EntityType<MutatedEggEntity> MUTATED_EGG_ENTITY_ENTITY_TYPE = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(MODID, "mutatedegg"),
			FabricEntityTypeBuilder.<MutatedEggEntity>create(SpawnGroup.MISC, MutatedEggEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F))
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build());


	@Override
	public void onInitialize() {

		ModPackets.registerC2SPackets();



		Registry.register(Registry.SOUND_EVENT, CHICKENDRAGONSCREAM, CHICKENDRAGONSCREAMSOUNDEVENT);
		Registry.register(Registry.SOUND_EVENT, CHICKENDRAGONHURT, CHICKENDRAGONHURTEVENT);

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
		FabricDefaultAttributeRegistry.register(MengolEntities.CREEPERDRAGON, CreeperDragonEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(MengolEntities.CREEPERDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());

		//venom
		FabricDefaultAttributeRegistry.register(MengolEntities.VENOMDRAGON, VenomDragonEntity.createAttributesVenomDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.VENOMDRAGONEGG, ChickenDragonEntity.createAttributesChickenDragon());
	}
}