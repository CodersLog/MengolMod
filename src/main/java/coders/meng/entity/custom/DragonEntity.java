package coders.meng.entity.custom;

import coders.meng.entity.MengolEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static coders.meng.event.KeyInputHandler.*;


public class DragonEntity extends AnimalEntity implements IAnimatable, IAnimationTickable {

    private int fireballStrength = 1;


    public DragonEntity(EntityType<? extends AnimalEntity> entityType, World world) {


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



    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.hasPassengers()) {
            player.startRiding(this);
            this.hasPassengers();
            return super.interactMob(player, hand);
        }


        return super.interactMob(player, hand);
    }



    @Override
    public void tickMovement() {
        super.tickMovement();
    }



    private int getFireballStrength() {

        return this.fireballStrength;
    }

    @Override
    public void travel(Vec3d pos) {





        LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();


        if(this.hasPassengers() && flyUpKey.wasPressed()) {

            this.setVelocity(0,1,0);

        }
        if(this.hasPassengers() && !flyUpKey.isPressed() && world.getBlockState(new BlockPos(0,-1,0)).getBlock() == Blocks.AIR) {
            this.setNoGravity(true);
            this.setMovementSpeed((float)this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)*3);
        }

        if (flyDownKey.isPressed()) {
            this.setVelocity(0,-1,0);

        }





        Vec3d rotVec = this.getRotationVec(1.0f);

        double i = this.getX() + rotVec.x * 4.0;
        double g = 0.5 + this.getBodyY(0.5);
        double h = this.getZ() + rotVec.z * 4.0;



        if(this.hasPassengers() && ShootBallKey.isPressed()) {

            FireballEntity fireballEntity = new FireballEntity(world, this, i, g, h, this.getFireballStrength());
            fireballEntity.setPosition(this.getX() + rotVec.x * 4.0, this.getBodyY(0.5) + 0.5, fireballEntity.getZ() + rotVec.z * 4.0);
            world.spawnEntity(fireballEntity);


        }

        if (!this.hasPassengers() || livingentity == null) {
            this.airStrafingSpeed = 0.02f;
            this.setNoGravity(false);
            super.travel(pos);
            return;
            }
            if (this.hasPassengers()) {
                this.setYaw(livingentity.getYaw());
                this.prevYaw = this.getYaw();
                this.setPitch(livingentity.getPitch() * 0.5f);
                this.setRotation(this.getYaw(), this.getPitch());
                this.headYaw = this.bodyYaw = this.getYaw();
                float f = livingentity.sidewaysSpeed * 0.5F;
                float f1 = livingentity.forwardSpeed;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }
                if(Boost.isPressed()) {

                    super.travel(new Vec3d(f, pos.y,f1 * 15));

                }


                super.travel(new Vec3d(f, pos.y , f1));

        }
    }
    @Nullable
    public Entity getControllingPassenger() {
        return this.getPassengerList().isEmpty() ? null : this.getPassengerList().get(0);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {

        if (this.hasPassengers()) {
            for (Entity entity : this.getPassengersDeep()) {
                entity.damage(DamageSource.FALL, 0);
            }
        }


        return false;
    }

    @Override
    public int tickTimer() { return age; }


    public static DefaultAttributeContainer.Builder createAttributesDragon() {



        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20f)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH,2);




    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDER_DRAGON_AMBIENT;
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
    else if(damageSource == DamageSource.explosion(this)) {

        return damageSource == DamageSource.explosion(this) || super.isInvulnerableTo(damageSource);

        }


        return false;

    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDER_DRAGON_DEATH;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return MengolEntities.DRAGON.create(world);
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.isOnGround() && event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dragon.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dragon.idle", true));
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState flyPredicate(AnimationEvent<E> event) {
        if (!this.isOnGround() && event.getController().getAnimationState().equals(AnimationState.Stopped)) {

            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dragon.flyup", true));

        }

        return PlayState.CONTINUE;
    }




    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));

        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::flyPredicate));


    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }




}