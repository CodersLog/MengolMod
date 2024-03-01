package coders.meng.entity.custom.endergolem;

import coders.meng.entity.custom.dragon.DragonEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static coders.meng.entity.MengolEntities.DRAGON;

public class GolemDragonEggEntity extends AnimalEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    public int hatchingTime = this.random.nextInt(6000) + 6000;
    public GolemDragonEggEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {


    }

    @Override
    public void tick() {


        if (!world.isClient && this.isAlive() && --this.hatchingTime <= 0) {


            DragonEntity dragonentity = new DragonEntity(DRAGON, world);
            dragonentity.setPosition(this.getX(),this.getY(),this.getZ());
            world.spawnEntity(dragonentity);
            this.kill();
            this.hatchingTime = this.random.nextInt(6000) + 6000;

        }


        super.tick();
}

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);
    nbt.putInt("HatchTime", this.hatchingTime);

}

@Override
public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);
    if (nbt.contains("HatchTime")) {
        this.hatchingTime = nbt.getInt("HatchTime");
    }

}

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}