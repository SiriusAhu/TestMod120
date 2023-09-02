package net.siriusahu.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.siriusahu.testmod.block.ModBlocks;
import net.siriusahu.testmod.item.ModItemGroups;
import net.siriusahu.testmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
    // For convinience, we store the mod id and name in variables
    public static final String MOD_ID = "testmod";
    public static final String MOD_NAME = "Test Mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Register items
        ModItems.registerItems();
        // Register item groups
        ModItemGroups.registerItemGroups();
        // Register blocks
        ModBlocks.registerModBlocks();

        FuelRegistry.INSTANCE.add(ModItems.BLACK_BREAD, 100);
    }
}