package coders.meng.entity.custom.enderchicken;

import coders.meng.Mengol;
import coders.meng.items.MengolItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Objects;
import java.util.UUID;

public class ChickenDragonEntity extends AnimalEntity implements IAnimatable{

    public float flapProgress;
    public float maxWingDeviation;
    public float prevMaxWingDeviation;
    public float prevFlapProgress;
    public float flapSpeed = 1.0f;
    public int eggLayTime = this.random.nextInt(6000) + 6000;

    public int cooldown = 50;

    public boolean istame = false;
    



    public ChickenDragonEntity(EntityType<? extends AnimalEntity> entityType, World world) {


        super(entityType, world);


    }







    private AnimationFactory factory = new AnimationFactory(this);


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(1, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));

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
        this.prevFlapProgress = this.flapProgress;
        this.prevMaxWingDeviation = this.maxWingDeviation;
        this.maxWingDeviation += (this.onGround ? -1.0f : 4.0f) * 0.3f;
        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0f, 1.0f);
        if (!this.onGround && this.flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        this.flapSpeed *= 0.9f;
        Vec3d vec3d = this.getVelocity();
        if (!this.onGround && vec3d.y < 0.0) {
            this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
        }
        this.flapProgress += this.flapSpeed * 2.0f;
        if (!this.world.isClient && this.isAlive() && !this.isBaby()  && --this.eggLayTime <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(MengolItems.MUTATEDEGG);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.eggLayTime = this.random.nextInt(6000) + 6000;
        }
    }


    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.getItem() == Items.GOLDEN_APPLE) {

            this.istame = true;
            this.world.sendEntityStatus(this, EntityStatuses.ADD_BREEDING_PARTICLES);
        }

        if(this.istame && stack.isEmpty()) {

            this.dropItem(Items.AMETHYST_SHARD);
            this.kill();

        }




        return super.interactMob(player, hand);
    }

    @Override
    public void tick() {
        super.tick();
        if (MinecraftClient.getInstance().player != null) {



        PlayerEntity player = world.getClosestPlayer(this, 120);

        if(player != null) {
            if (!player.isCreative()) {

                if (player.squaredDistanceTo(this) < 120 && !this.istame) {

                    --this.cooldown;

                    if (this.cooldown <= 0) {

                        World world = this.getWorld();

                        this.lookAtEntity(player, 1, 1);

                        Vec3d vec3d = this.getRotationVec(1.0f);
                        double f = player.getX() - (this.getX() + vec3d.x * 1.2);
                        double g = player.getBodyY(0.5) - (0.2 + this.getBodyY(0.2));
                        double h = player.getZ() - (this.getZ() + vec3d.z * 1.2);

                        DragonFireballEntity fireballEntity = new DragonFireballEntity(this.world,this,f,g,h );
                        fireballEntity.setPosition(this.getX() + vec3d.x * 1.2, this.getBodyY(0.2) + 0.2, fireballEntity.getZ() + vec3d.z * 1.2);
                        world.spawnEntity(fireballEntity);

                        this.cooldown = 50;

                    }

                }

            }
        }

        }

    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("EggLayTime")) {
            this.eggLayTime = nbt.getInt("EggLayTime");
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("EggLayTime", this.eggLayTime);
    }







    public static DefaultAttributeContainer.Builder createAttributesChickenDragon() {



        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1f);

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

        if(damageSource == DamageSource.DRAGON_BREATH) {

            return damageSource == DamageSource.DRAGON_BREATH || super.isInvulnerableTo(damageSource);

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
    protected SoundEvent getHurtSound(DamageSource source) {
        return Mengol.CHICKENDRAGONHURTEVENT;
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

        if(!this.onGround) {

            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chickendragon.flapping", true));
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