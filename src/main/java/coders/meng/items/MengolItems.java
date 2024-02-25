package coders.meng.items;

import coders.meng.Mengol;
import coders.meng.items.item.ItemTreetap;
import coders.meng.items.item.group.MengolGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MengolItems {

    public static final Item TREETAP = registerItems("treetap", new ItemTreetap(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP)));
    public static final Item PANCAKES = registerItems("pancakes", new Item(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP).food(new FoodComponent.Builder().hunger(5).saturationModifier(3).alwaysEdible().build())));
    public static final Item PANCAKES_MAPLE = registerItems("pancakes_maple", new Item(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP).food(new FoodComponent.Builder().hunger(10).saturationModifier(6).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED,2000,2),100).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,2000,2), 100).build())));
    public static final Item TREESAP_BOTTLE = registerItems("sap_bottle", new Item(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP).food(new FoodComponent.Builder().hunger(1).saturationModifier(0).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20,1),100).build())));
    public static final Item MAPLE_BOTTLE = registerItems("maple_bottle", new Item(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP).food(new FoodComponent.Builder().hunger(1).saturationModifier(3).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,1),100).statusEffect(new StatusEffectInstance(StatusEffects.HASTE,200,1), 100).build())));

    public static final Item OBSIDIANHAMMER = registerItems("obsidian_hammer", new ItemObsidianHammer(
            new FabricItemSettings().group(MengolGroup.MENGOLGROUP)));

    private static Item registerItems(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(Mengol.MODID, name), item);

    }



    public static void registerModItems() {



    }
}
