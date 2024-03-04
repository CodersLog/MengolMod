package coders.meng.entity;

import coders.meng.Mengol;
import coders.meng.entity.custom.enderchicken.ChickenDragonEggEntity;
import coders.meng.entity.custom.enderchicken.ChickenDragonEntity;
import coders.meng.entity.custom.dragon.DragonEntity;
import coders.meng.entity.custom.dragon.PigDragonEggEntity;
import coders.meng.entity.custom.endercow.CowDragonEggEntity;
import coders.meng.entity.custom.endercow.CowDragonEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEggEntity;
import coders.meng.entity.custom.endergolem.GolemDragonEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEggEntity;
import coders.meng.entity.custom.enderskeleton.SkeletonDragonEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEggEntity;
import coders.meng.entity.custom.nitrocreeper.CreeperDragonEntity;
import coders.meng.entity.custom.venom.VenomDragonEggEntity;
import coders.meng.entity.custom.venom.VenomDragonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MengolEntities {
//Mobs
    public static final EntityType<DragonEntity> DRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<ChickenDragonEntity> CHICKENDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "chickendragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChickenDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<CowDragonEntity> COWDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "cowdragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CowDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<GolemDragonEntity> GOLEMDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "golemdragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GolemDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<SkeletonDragonEntity> SKELETONDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "skeletondragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SkeletonDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<CreeperDragonEntity> CREEPERDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "creeperdragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CreeperDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<VenomDragonEntity> VENOMDRAGON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "venomdragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, VenomDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());




    //eggs
    public static final EntityType<PigDragonEggEntity> PIGDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "dragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PigDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());


    public static final EntityType<ChickenDragonEggEntity> CHICKENDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "chickendragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChickenDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());

    public static final EntityType<SkeletonDragonEggEntity> SKELETONDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "skeletondragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SkeletonDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());


    public static final EntityType<CowDragonEggEntity> COWDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "cowdragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CowDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());


    public static final EntityType<GolemDragonEggEntity> GOLEMDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "golemdragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GolemDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());


    public static final EntityType<CreeperDragonEggEntity> CREEPERDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "creeperdragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CreeperDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());


    public static final EntityType<VenomDragonEggEntity> VENOMDRAGONEGG = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Mengol.MODID, "venomdragonegg"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, VenomDragonEggEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f)).build());









}
