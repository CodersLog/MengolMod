package coders.meng.items.custom.itementitys;

import coders.meng.Mengol;
import coders.meng.items.MengolItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class MutatedEggEntity extends ThrownItemEntity {

    public int randomTeleport = this.random.nextInt(500) + 300;
    public MutatedEggEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public MutatedEggEntity(World world, LivingEntity owner) {
        super(Mengol.MUTATED_EGG_ENTITY_ENTITY_TYPE, owner, world);
    }

    public MutatedEggEntity(World world, double x, double y, double z) {
        super(Mengol.MUTATED_EGG_ENTITY_ENTITY_TYPE, x, y, z, world);

    }
    @Override
    protected Item getDefaultItem() {
        return MengolItems.MUTATEDEGG;
    }

    @Override
    public void tick() {

        ++randomTeleport;

        super.tick();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {


        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof AnimalEntity ? 3 : 0;
        entity.teleport(randomTeleport,randomTeleport,randomTeleport);
        super.onEntityHit(entityHitResult);
    }
}
