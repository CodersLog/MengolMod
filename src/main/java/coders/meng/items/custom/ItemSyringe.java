package coders.meng.items.custom;

import coders.meng.items.MengolItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.DonkeyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ItemSyringe extends Item {
    public ItemSyringe(FabricItemSettings settings) {
        super(settings);
    }



    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if(entity.getType() == EntityType.PIG) {

            stack.setCount(stack.getCount() - 1 );
            user.giveItemStack(MengolItems.PIGBLOODSYRINGE.getDefaultStack());

        }




        return super.useOnEntity(stack, user, entity, hand);
    }
}
