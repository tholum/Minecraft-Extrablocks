package holum.extrablocks.Block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;

public class ModBlockRecipe {
    public ItemConvertible[] shapelessIngredients;
    public String recipeType;
    public Block block;
    public ModBlockRecipe( ItemConvertible[] ing ){
        shapelessIngredients = ing;
        recipeType = "shapeless";
    }
    public void setBlock( Block blk ){
        block = blk;
    }
}
