package holum.extrablocks.datagen;

import holum.extrablocks.Block.BlockBuilder;
import holum.extrablocks.Block.ModBlocks;
import holum.extrablocks.Item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        for (int i = 0; i < BlockBuilder.blockBuilders.size(); i++){
            BlockBuilder block = BlockBuilder.blockBuilders.get(i);
            switch( block.textureType ){
                case "simple_cube_all":
                    blockStateModelGenerator.registerSimpleCubeAll(block.get());
                    break;
                case "log":
                    blockStateModelGenerator.registerLog(block.get()).log( block.get() );
                    break;
                case "rotatable":
                    blockStateModelGenerator.registerBrushableBlock(block.get());
                    break;

            }
        }
        BlockStateModelGenerator.BlockTexturePool goldPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GOLD_BLOCK);
        goldPool.wall(ModBlocks.GOLD_WALL);
        BlockStateModelGenerator.BlockTexturePool shroomPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SHROOMLIGHT);
        shroomPool.wall(ModBlocks.SHROOMLIGHT_WALL);
        BlockStateModelGenerator.BlockTexturePool netherwartPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.NETHER_WART_BLOCK);
        netherwartPool.wall(ModBlocks.NETHER_WART_WALL);
        BlockStateModelGenerator.BlockTexturePool redstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.REDSTONE_BLOCK);
        redstonePool.wall(ModBlocks.REDSTONE_WALL);
        BlockStateModelGenerator.BlockTexturePool goldTilePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(
                    ModBlocks.GOLD_TILE
                );
        goldTilePool.wall(ModBlocks.GOLD_TILE_WALL);
        /*blockStateModelGenerator
                .registerLog(ModBlocks.GOLDEN_BIRCH)
                .log(ModBlocks.GOLDEN_BIRCH);*/
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY , Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY , Models.GENERATED);

    }
}
