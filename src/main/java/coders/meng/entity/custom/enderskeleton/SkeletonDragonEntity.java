package coders.meng.entity.custom.enderskeleton;

import coders.meng.Mengol;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SkeletonDragonEntity extends AnimalEntity implements IAnimatable {

    private int fireballStrength = 1;


    public SkeletonDragonEntity(EntityType<? extends AnimalEntity> entityType, World world) {


        super(entityType, world);


    }

    private AnimationFactory factory = new AnimationFactory(this);


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.20f, 45));
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
    }



    @Override
    public void travel(Vec3d pos) {


            super.travel(pos);


    }



    public static DefaultAttributeContainer.Builder createAttributesSkeletonDragon() {



        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1f)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH,2);




    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return Mengol.CHICKENDRAGONSCREAMSOUNDEVENT;
    }



    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        if(damageSource == DamageSource.FALL) {

            return damageSource == DamageSource.FALL || super.isInvulnerableTo(damageSource);

        }
        else if(damageSource == DamageSource.ON_FIRE) {

            return damageSource == DamageSource.ON_FIRE || super.isInvulnerableTo(damageSource);

        }
        else if(damageSource == DamageSource.IN_FIRE) {

            return damageSource == DamageSource.IN_FIRE || super.isInvulnerableTo(damageSource);

        }



        return false;

    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDER_DRAGON_DEATH;
    }


    @Override
    public boolean cannotDespawn() {
        return true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chickendragon.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chickendragon.idle", true));
        return PlayState.CONTINUE;
    }






    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));




    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }




}