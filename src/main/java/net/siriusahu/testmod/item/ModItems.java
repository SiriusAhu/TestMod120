package net.siriusahu.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.siriusahu.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.siriusahu.testmod.item.custom.MetalDetectorItem;
import net.siriusahu.testmod.item.custom.ModFoodComponents;
import net.siriusahu.testmod.item.item4fun.HealingHeart;

public class ModItems {

    public static final Item RED_SQUARE = registerItem("red_square", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings()
                    .maxDamage(64) // Durability
            ));

    public static final Item BLACK_BREAD = registerItem("black_bread",
            new Item(new FabricItemSettings()
                    .food(ModFoodComponents.BLACK_BREAD) // Food component
            ));

    public static final Item HEALING_HEART = registerItem("healing_heart",
            new HealingHeart(new FabricItemSettings()
                    .maxCount(1) // Max stack size
                    .maxDamage(32) // Durability
            ));

    public static final Item GREEN_APPLE = registerItem("green_apple",
            new Item(new FabricItemSettings()
                    .food(ModFoodComponents.GREEN_APPLE) // Food component
            ));


    // Add items to the "Ingredients" tab
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RED_SQUARE);
    }

    // ↓↓↓ Don't edit from the line if not necessary ↓↓↓
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        TestMod.LOGGER.info("Registering items for " + TestMod.MOD_NAME + "(" + TestMod.MOD_ID + ")");

        // Add items to the "Ingredients" tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}