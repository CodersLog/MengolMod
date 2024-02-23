package coders.meng.items.item;

import coders.meng.blocks.MengolBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static coders.meng.blocks.MengolBlocks.DRIED_MAPLE_LOG;
import static coders.meng.items.MengolItems.TREESAP_BOTTLE;

public class ItemTreetap extends Item {


    public ItemTreetap(Settings settings) {
        super(settings);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        Hand hand = context.getHand();
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        ItemStack item = player.getInventory().getMainHandStack();


 //very important comment...



        if (world.getBlockState(blockpos).getBlock() == MengolBlocks.MAPLELOG) {


            if (player != null) {



                if (player.getInventory().getMainHandStack().getItem() == Items.GLASS_BOTTLE) {

                    context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
                    player.swingHand(hand);
                    item.setCount(item.getCount() - 1 );
                    player.giveItemStack(TREESAP_BOTTLE.getDefaultStack());
                    world.setBlockState(blockpos, DRIED_MAPLE_LOG.getDefaultState());

                }






            }





        }
        return super.useOnBlock(context);

    }

}

