package net.siriusahu.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.siriusahu.testmod.TestMod;
import net.siriusahu.testmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup BASIC_ITEMS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "basic_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.basic_items")) // A translatable name of group when the cursor is hovered over the tab
                    .icon(() -> new ItemStack(ModItems.RED_SQUARE)).entries(((displayContext, entries) -> { // The icon of the tab
                        // Add items to the tab here
                        entries.add(ModItems.RED_SQUARE);
                        entries.add(ModBlocks.RED_FLOWER_BLOCK);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModBlocks.MUSIC_BLOCK);
                        entries.add(ModItems.BLACK_BREAD);
                    })).build());

    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering item groups for " + TestMod.MOD_NAME + "(" + TestMod.MOD_ID + ")");
    }
}