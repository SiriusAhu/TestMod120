package net.siriusahu.testmod.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.siriusahu.testmod.TestMod;

public class ModTags {
    public static class Blocks {
        // Blocks that are available for Metal Detector
        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
                createTag("metal_detector_detectable_blocks");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TestMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(TestMod.MOD_ID, name));
        }
    }
}
