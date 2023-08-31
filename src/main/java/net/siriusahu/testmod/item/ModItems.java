package net.siriusahu.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.siriusahu.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RED_SQUARE = registerItem("red_square", new Item(new FabricItemSettings()));

    // Add items to the "Ingredients" tab
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RED_SQUARE);
    }

    // ↓↓↓ Don't edit from thie line if not necessary ↓↓↓
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        TestMod.LOGGER.info("Registering items for " + TestMod.MOD_NAME + "(" + TestMod.MOD_ID + ")");

        // Add items to the "Ingredients" tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}