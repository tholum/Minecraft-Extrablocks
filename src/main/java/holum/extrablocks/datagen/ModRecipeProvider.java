package holum.extrablocks.datagen;

import holum.extrablocks.Block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    // private static List<ItemConvertible> = []
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AQUA_ZIGZAG, 2)
                .input(Items.CYAN_CONCRETE)
                .input(Items.LIGHT_BLUE_CONCRETE)
                .criterion(hasItem(Items.CYAN_CONCRETE) , conditionsFromItem(Items.CYAN_CONCRETE))
                .criterion(hasItem(Items.LIGHT_BLUE_CONCRETE) , conditionsFromItem(Items.LIGHT_BLUE_CONCRETE))
                .offerTo(exporter , new Identifier(getRecipeName(ModBlocks.AQUA_ZIGZAG)));
    }
}
