package holum.extrablocks.datagen;

import holum.extrablocks.Block.BlockBuilder;
import holum.extrablocks.Block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    // private static List<ItemConvertible> = []
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private void genericShapeless(RecipeExporter exporter , ItemConvertible output , ItemConvertible[] ingredients ){
        ShapelessRecipeJsonBuilder builder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, ingredients.length);

        for (int i = 0; i < ingredients.length; i++) {
            ItemConvertible ing = ingredients[i];
            builder.input(ing );
            builder.criterion(hasItem(ing) , conditionsFromItem(ing));
        }
        builder.offerTo(exporter , new Identifier(getRecipeName(output)));

    }

    @Override
    public void generate(RecipeExporter exporter) {
        for (int i = 0; i < BlockBuilder.blockBuilders.size(); i++){
            BlockBuilder bb = BlockBuilder.blockBuilders.get( i );
            for (int x = 0; x < bb.recipes.size(); x++) {
                genericShapeless(
                        exporter,
                        bb.recipes.get(x).block,
                        bb.recipes.get(x).shapelessIngredients
                );
            }
            if( bb.registerWall){
                offerWallRecipe(exporter , RecipeCategory.BUILDING_BLOCKS , bb.getWall() , bb.get() );
            }
        }
        offerStonecuttingRecipe( exporter , RecipeCategory.BUILDING_BLOCKS , ModBlocks.GOLD_TILE , Blocks.GOLD_BLOCK );
        offerWallRecipe(exporter , RecipeCategory.BUILDING_BLOCKS , ModBlocks.SHROOMLIGHT_WALL , Blocks.SHROOMLIGHT );
        /* offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,  ModBlocks.GOLD_WALL , Blocks.GOLD_BLOCK); */

        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,  ModBlocks.NETHER_WART_WALL , Blocks.NETHER_WART_BLOCK);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,  ModBlocks.REDSTONE_WALL , Blocks.REDSTONE_BLOCK);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,  ModBlocks.GOLD_TILE_WALL , ModBlocks.GOLD_TILE);
    }
}
