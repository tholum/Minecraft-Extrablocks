package holum.extrablocks.Block;

import holum.extrablocks.ExtraBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GREEN_STUCCO = registerBlock(  "green_stucco",
        new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE )));
    public static final Block PINK_FOREST_FLOOR = registerBlock(  "pink_forest_floor",
            new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK )));
    public static final Block AQUA_ZIGZAG = registerBlock(  "aqua_zigzag",
            new Block(FabricBlockSettings.copyOf(Blocks.TERRACOTTA )));
    public static final Block PALE_STUCCO = registerBlock(  "pale_stucco",
            new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE )));

    public static final Block PATH_STONE = registerBlock(  "path_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE )));

    private static Block registerBlock(String name , Block block ){
        registerBlockItem(name , block );
        return Registry.register(Registries.BLOCK , new Identifier(ExtraBlocks.MOD_ID , name ) , block );
    }
    private static Item registerBlockItem( String name , Block block ){
        return Registry.register(Registries.ITEM , new Identifier(ExtraBlocks.MOD_ID , name ) , new BlockItem( block , new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        ExtraBlocks.LOGGER.info("Register Modblocks");

    }
}
