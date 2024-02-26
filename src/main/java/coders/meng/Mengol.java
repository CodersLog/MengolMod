package coders.meng;

import coders.meng.entity.MengolEntities;
import coders.meng.entity.custom.DragonEntity;
import coders.meng.items.MengolItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Mengol implements ModInitializer {
	public static final String MODID = "meng";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		MengolItems.registerModItems();
		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(MengolEntities.DRAGON, DragonEntity.createAttributesDragon());
		FabricDefaultAttributeRegistry.register(MengolEntities.DRAGONEGG, DragonEntity.createAttributesDragon());

	}
}