package net.siriusahu.testmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.siriusahu.testmod.TestMod;
import net.siriusahu.testmod.block.custom.MusicBlock;

public class ModBlocks {
    public static final Block RED_FLOWER_BLOCK = registerBlock("red_flower_block",
            /*
            The attribute of the block can be set here
            It can be customized if you want, here we copyOf to get the attribute of the block `Blocks.OAK_LEAVES` for convenience
            Hover the cursor over `Blocks` of `Blocks.OAK_LEAVES` and press `Ctrl` + left click to see the source code of Minecraft vanilla blocks' attributes
            */
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block MUSIC_BLOCK = registerBlock("music_block",
            new MusicBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block RED_FLOWER_STAIRS = registerBlock("red_flower_stairs",
            new StairsBlock(ModBlocks.RED_FLOWER_BLOCK.getDefaultState(), // default block state
                    FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block RED_FLOWER_SLAB = registerBlock("red_flower_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB))); // Slab doesn't need a default block state

    public static final Block RED_FLOWER_BUTTON = registerBlock("red_flower_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON),
                    BlockSetType.IRON, // BlockSetType: define the material, for example, the voice of the button, can be opened with hand or not, etc.
                    10, true)); // wooden: can this button be activated by arrow
    public static final Block RED_FLOWER_PRESSURE_PLATE = registerBlock("red_flower_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, // everything can activate this pressure plate
                    FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE),
                    BlockSetType.IRON));

    // ↓↓↓ Don't edit from the line if not necessary ↓↓↓
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
