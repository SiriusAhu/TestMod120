package net.siriusahu.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.siriusahu.testmod.block.ModBlocks;
import net.siriusahu.testmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool redFlowerTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_FLOWER_BLOCK);
//        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_FLOWER_BLOCK);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MUSIC_BLOCK);

        redFlowerTexturePool.stairs(ModBlocks.RED_FLOWER_STAIRS);
        redFlowerTexturePool.slab(ModBlocks.RED_FLOWER_SLAB);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RED_SQUARE,
                Models.GENERATED); // Here "Models.GENERATED" is same as the "parent" in the json file "parent": "item/generated"

        itemModelGenerator.register(ModItems.BLACK_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALING_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
    }
}
