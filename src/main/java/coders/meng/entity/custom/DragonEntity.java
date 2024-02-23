package coders.meng.entity.custom;

import coders.meng.entity.MengolEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.example.entity.BikeEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static coders.meng.event.KeyInputHandler.flyDownKey;
import static coders.meng.event.KeyInputHandler.flyUpKey;



public class DragonEntity extends BikeEntity implements IAnimatable {
    public DragonEntity(EntityType<? extends BikeEntity> entityType, World world) {


        super(entityType, world);


    }

    private AnimationFactory factory = new AnimationFactory(this);


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.enableControl(Goal.Control.MOVE);
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.20f, 45));
    }


    @Override
    public void tick() {

        if (this.isAlive() && this.hasPassengers()) {

            if(this.hasPassengers() && flyUpKey.wasPressed()) {
                this.setPos(getX(),getY() +0.35,getZ());
                this.setVelocity(0,1,0);

            }
            if(this.hasPassengers() && !flyUpKey.isPressed() && world.getBlockState(new BlockPos(0,-1,0)).getBlock() == Blocks.AIR) {
                this.setNoGravity(true);
                this.setMovementSpeed(0.75f);
            }

            if (flyDownKey.isPressed()) {
                this.setVelocity(0,-1,0);
            }



        }



        super.tick();
    }



    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.hasPassengers()) {
            player.startRiding(this);
            return super.interactMob(player, hand);
        }


        return super.interactMob(player, hand);
    }






    public static DefaultAttributeContainer.Builder createAttributesDragon() {



        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20f);




    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDER_DRAGON_AMBIENT;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return damageSource == DamageSource.FALL || super.isInvulnerableTo(damageSource);
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
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("dragon.walk", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dragon.idle", true));
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
