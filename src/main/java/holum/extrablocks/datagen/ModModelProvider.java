package holum.extrablocks.datagen;

import holum.extrablocks.Block.ModBlocks;
import holum.extrablocks.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_FOREST_FLOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AQUA_ZIGZAG);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALE_STUCCO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_FOREST_FLOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_STUCCO);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY , Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY , Models.GENERATED);

    }
}
