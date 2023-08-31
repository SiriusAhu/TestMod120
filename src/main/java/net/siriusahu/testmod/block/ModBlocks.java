package net.siriusahu.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.siriusahu.testmod.TestMod;

public class ModBlocks {
    public static final Block RED_FLOWER_BLOCK = registerBlock("red_flower_block",
            /*
             The attribute of the block can be set here
             It can be customized if you want, here we copyOf to get the attribute of the block `Blocks.OAK_LEAVES` for convenience
             Hover the cursor over `Blocks` of `Blocks.OAK_LEAVES` and press `Ctrl` + left click to see the source code of Minecraft vanilla blocks' attributes
             */
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

    // ↓↓↓ Don't edit from thie line if not necessary ↓↓↓
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    // A part of a block is an item. This method registers the item of a block.(called by `registerBlock`)
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering blocks for " + TestMod.MOD_NAME + "(" + TestMod.MOD_ID + ")");
    }
}