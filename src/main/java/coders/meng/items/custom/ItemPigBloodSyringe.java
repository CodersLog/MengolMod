package coders.meng.items.custom;

import coders.meng.entity.custom.PigDragonEggEntity;
import coders.meng.items.MengolItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static coders.meng.entity.MengolEntities.PIGDRAGONEGG;

public class ItemPigBloodSyringe extends Item {
    public ItemPigBloodSyringe(FabricItemSettings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack item = player.getInventory().getMainHandStack();


        if (world.getBlockState(blockpos).getBlock() == Blocks.DRAGON_EGG) {


            if (player != null) {

                PigDragonEggEntity dragoneggentity = new PigDragonEggEntity(PIGDRAGONEGG, world);
                dragoneggentity.setPosition(blockpos.getX(),blockpos.getY(),blockpos.getZ());
                world.spawnEntity(dragoneggentity);
                item.setCount(item.getCount() - 1 );
                player.giveItemStack(MengolItems.SYRINGE.getDefaultStack());

                world.setBlockState(blockpos, Blocks.AIR.getDefaultState());











            }





        }
        return super.useOnBlock(context);

    }

}

