package coders.meng.blocks;

import coders.meng.Mengol;
import coders.meng.blocks.block.BLOCKMAPLELEAVES;
import coders.meng.blocks.block.BLOCKMAPLELOG;
import coders.meng.items.item.group.MengolGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MengolBlocks {

    public static final Block MAPLELOG = registerBlocks("maple_log",
            new BLOCKMAPLELOG(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool()), MengolGroup.MENGOLGROUP);
    public static final Block DRIED_MAPLE_LOG = registerBlocks("dried_maple_log",
            new BLOCKMAPLELOG(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool()), MengolGroup.MENGOLGROUP);
    public static final Block MAPLE_LEAVES = registerBlocks("maple_leaves",
            new BLOCKMAPLELEAVES(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()), MengolGroup.MENGOLGROUP);

    private static Block registerBlocks(String name, Block block, ItemGroup tab) {

        registerBlockItems(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Mengol.MODID, name), block);

    }

    private static Item registerBlockItems(String name, Block block, ItemGroup tab) {

        return Registry.register(Registry.ITEM, new Identifier(Mengol.MODID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));

    }

    public static void registerModBlocks() {



    }
}
