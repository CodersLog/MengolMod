package coders.meng.entity.custom.endercow;

import coders.meng.Mengol;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

public class CowDragonEntity extends AnimalEntity implements IAnimatable, Angerable {

    public boolean istame = false;
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);


    public CowDragonEntity(EntityType<? extends AnimalEntity> entityType, World world) {


        super(entityType, world);


    }

    private AnimationFactory factory = new AnimationFactory(this);


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.20f, 45));
        this.goalSelector.add(1, new MeleeAttackGoal(this,3,false));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this,PlayerEntity.class,true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this,HostileEntity.class,true));

        }

    @Override
    public int getAngerTime() {
        return 0;
    }

    @Override
    public void setAngerTime(int angerTime) {

    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return null;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {

    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    public boolean shouldAngerAt(LivingEntity entity) {
        if (!this.canTarget(entity)) {
            return false;
        }
        if (entity.getType() == EntityType.PLAYER && this.isUniversallyAngry(entity.world)) {
            return true;
        }
        return entity.getUuid().equals(this.getAngryAt());
    }

    @Override
    public void tick() {
        super.tick();


    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.getItem() == Items.GOLDEN_APPLE) {

            this.istame = true;
            this.world.sendEntityStatus(this, EntityStatuses.ADD_BREEDING_PARTICLES);
        }

        if(stack.getItem() == Items.DIRT) {

            this.istame = false;
            this.world.sendEntityStatus(this, EntityStatuses.ADD_BREEDING_PARTICLES);
        }

        return super.interactMob(player, hand);
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



    public static DefaultAttributeContainer.Builder createAttributesCowDragon() {



        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f);





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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.endercow.walk", true));
            return PlayState.CONTINUE;
        }

        if(this.handSwinging) {

            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.endercow.attack", false));
            return PlayState.CONTINUE;

        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.endercow.idle", true));
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