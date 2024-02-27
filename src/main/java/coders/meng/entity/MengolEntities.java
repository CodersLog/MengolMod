package coders.meng.entity;

import coders.meng.Mengol;
import coders.meng.entity.custom.ChickenDragonEntity;
import coders.meng.entity.custom.DragonEntity;
import coders.meng.entity.custom.PigDragonEggEntity;
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

    public static final EntityType<PigDragonEggEntity> PIGDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "dragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PigDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<ChickenDragonEntity> CHICKENDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "chickendragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChickenDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());









}
