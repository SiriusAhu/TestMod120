package net.siriusahu.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.siriusahu.testmod.block.ModBlocks;
import net.siriusahu.testmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // 1. Shaped recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, // the type(category) of the recipe
                        Items.ENCHANTED_GOLDEN_APPLE) // the output of the recipe

                // the pattern of the recipe
                .pattern("###")
                .pattern("#A#")
                .pattern("###")

                // the input of the recipe
                .input('#', Blocks.GOLD_BLOCK)
                .input('A', Items.APPLE)

                // in what condition the recipe can be unlocked
                // e.g. unlock when the player got any gold block or apple
                .criterion(hasItem(Items.GOLD_BLOCK), conditionsFromItem(Items.GOLD_BLOCK))
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))

                // build the recipe
                .offerTo(exporter, new Identifier(getRecipeName(Items.ENCHANTED_GOLDEN_APPLE) + "_"));

        // 2. Reverse recipe (9 red dye <-> 1 red flower block)
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.MISC, ModItems.RED_SQUARE, // recipe 1
                RecipeCategory.MISC, ModBlocks.RED_FLOWER_BLOCK // recipe 2
        );

        // 3. Smelting recipe
        offerSmelting(exporter, List.of(ModBlocks.RED_FLOWER_BLOCK),
                RecipeCategory.MISC,
                Blocks.DIRT,
                0.5f,
                200,
                "red_flower_block"
        );

        // Other stuff
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_FLOWER_BLOCK)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.RED_SQUARE)
                .criterion(hasItem(ModItems.RED_SQUARE), conditionsFromItem(ModItems.RED_SQUARE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RED_FLOWER_BLOCK) + "_"));

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Items.RED_DYE, ModItems.RED_SQUARE);

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, Items.RED_DYE, ModItems.RED_SQUARE, 4);
    }
}
