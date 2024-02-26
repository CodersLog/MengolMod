package coders.meng.items;


import coders.meng.entity.custom.DragonEggEntity;
import coders.meng.entity.custom.DragonEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static coders.meng.entity.MengolEntities.DRAGON;
import static coders.meng.entity.MengolEntities.DRAGONEGG;


public class ItemObsidianHammer extends Item {

    DragonEntity entity;
    public ItemObsidianHammer(FabricItemSettings group) {
        super(group);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        Hand hand = context.getHand();
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        ItemStack item = player.getInventory().getMainHandStack();


        if (world.getBlockState(blockpos).getBlock() == Blocks.DRAGON_EGG) {


            if (player != null) {

                DragonEggEntity dragoneggentity = new DragonEggEntity(DRAGONEGG, world);
                dragoneggentity.setPosition(blockpos.getX(),blockpos.getY(),blockpos.getZ());
                    world.spawnEntity(dragoneggentity);

                     world.setBlockState(blockpos, Blocks.AIR.getDefaultState());











            }





        }
        return super.useOnBlock(context);

    }

}
