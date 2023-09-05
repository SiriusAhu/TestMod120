package net.siriusahu.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.siriusahu.testmod.block.ModBlocks;
import net.siriusahu.testmod.utils.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // 1. Adding blocks to mod tags
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS) // this is a tag defined in ModTags.Blocks
                // Add the following blocks to the tag
                // adding a mod block to this tag by using "add" method
                .add(ModBlocks.MUSIC_BLOCK)

                // for vanilla blocks, we should use "forceAddTag" instead of "add"
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.COAL_ORES);

        // 2. Adding blocks to vanilla tags
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MUSIC_BLOCK);

        // 3. More example: NEEDS_DIAMOND_TOOL(only mineable with iron or higher tier tools)
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MUSIC_BLOCK);
    }
}
