package holum.extrablocks.datagen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import holum.extrablocks.ExtraBlocks;
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
    public static final Logger LOGGER = LoggerFactory.getLogger(ExtraBlocks.MOD_ID);
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        for (int i = 0; i < BlockBuilder.blockBuilders.size(); i++){
            BlockBuilder block = BlockBuilder.blockBuilders.get(i);
            if( block.needsPool() == false ){
            switch( block.textureType ){
                case "no_registration":
                    LOGGER.info("No Rgistration: " + block.name);
                    break;
                case "simple_cube_all":
                LOGGER.info("Simple Cube ALl: " + block.name);
                    blockStateModelGenerator.registerSimpleCubeAll(block.get());
                    break;
                case "log":
                LOGGER.info("Log: " + block.name);
                    blockStateModelGenerator.registerLog(block.get()).log( block.get() );
                    break;
                case "rotatable":
                LOGGER.info("Rotatable: " + block.name);
                    blockStateModelGenerator.registerBrushableBlock(block.get());
                    break;
            }
            } else { 
                LOGGER.info("Needs Pool: " + block.name);
                BlockStateModelGenerator.BlockTexturePool pool = blockStateModelGenerator.registerCubeAllModelTexturePool(block.get());
                if( block.registerWall ){
                    LOGGER.info("Pool Wall: " + block.name);
                    pool.wall( block.getWall() );
                }
            }
        }
        /* BlockStateModelGenerator.BlockTexturePool goldPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.GOLD_BLOCK);
        goldPool.wall(ModBlocks.GOLD_WALL); */
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY , Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY , Models.GENERATED);

    }
}
