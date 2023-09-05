package net.siriusahu.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.siriusahu.testmod.block.ModBlocks;
import net.siriusahu.testmod.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    // change it to public(protected by default) for the data generator
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // 1. Drop the block itself
        addDrop(ModBlocks.MUSIC_BLOCK);
        addDrop(ModBlocks.RED_FLOWER_BLOCK);

        addDrop(ModBlocks.RED_FLOWER_STAIRS);
        addDrop(ModBlocks.RED_FLOWER_SLAB, slabDrops(ModBlocks.RED_FLOWER_SLAB)); // when 2 slabs are combined, they will drop 2 items

        addDrop(ModBlocks.RED_FLOWER_BUTTON);
        addDrop(ModBlocks.RED_FLOWER_PRESSURE_PLATE);

        // 2. Drop ores
        addDrop(ModBlocks.RED_FLOWER_BLOCK, oreDrops(ModBlocks.RED_FLOWER_BLOCK, ModItems.RED_SQUARE));

    }
}
