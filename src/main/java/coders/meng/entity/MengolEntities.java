package coders.meng.entity;

import coders.meng.Mengol;
import coders.meng.entity.custom.DragonEggEntity;
import coders.meng.entity.custom.DragonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MengolEntities {

    public static final EntityType<DragonEntity> DRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<DragonEggEntity> DRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "dragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());
}
