package coders.meng.items.item.group;

import coders.meng.Mengol;
import coders.meng.items.MengolItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MengolGroup {

    public static final ItemGroup MENGOLGROUP = FabricItemGroupBuilder.build(new Identifier
            (Mengol.MODID, "mengolgroup"), () -> new ItemStack(MengolItems.SYRINGE));
}
