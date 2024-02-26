package coders.meng.items;

import coders.meng.Mengol;
import coders.meng.items.custom.ItemBloodSyringe;
import coders.meng.items.custom.ItemSyringe;
import coders.meng.items.item.group.MengolGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MengolItems {

    public static final Item BLOODSYRINGE = registerItems("bloodsyringe", new ItemBloodSyringe(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP)));

    public static final Item SYRINGE = registerItems("syringe", new ItemSyringe(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP)));


    private static Item registerItems(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(Mengol.MODID, name), item);

    }



    public static void registerModItems() {



    }
}
