package holum.extrablocks.Block;

import holum.extrablocks.ExtraBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

public class ModBlocks {
    public static final Block GOLDEN_BIRCH = registerBlock(
            "golden_birch" , Blocks.BIRCH_LOG , BlockBuilder.builderType.LOG)
            .setTextureType("log")
            .addRecipe(new ItemConvertible[]{
                    Items.BIRCH_LOG ,
                    Items.GOLD_NUGGET})
            .get();
    public static final Block GOLDEN_BIRCH_PLANKS = registerBlock(
            "golden_birch_planks" ,
            Blocks.BIRCH_PLANKS
    ).addRecipe(new ItemConvertible[]{
            Items.BIRCH_PLANKS ,
            Items.GOLD_NUGGET}).get();

    public static final Block GREEN_SHROOMLIGHT = registerBlock(
            "green_shroomlight" ,
            Blocks.SHROOMLIGHT
    ).addRecipe(new ItemConvertible[]{
            Items.SHROOMLIGHT ,
            Items.GREEN_DYE }).get();
    public static final Block GOLDEN_BIRCH_LEAVES = registerBlock(
            "golden_birch_leaves" ,
            Blocks.BIRCH_PLANKS
    ).addRecipe(new ItemConvertible[]{
            Items.BIRCH_LEAVES ,
            Items.GOLD_NUGGET}).get();
    public static final Block GOLD_BLOCK = registerBlock("gold_block", Blocks.GOLD_BLOCK , BlockBuilder.builderType.REFERENCE)
    .withWalls()
    .get();


    public static final Block GOLD_TILE_WALL = registerBlock("gold_tile_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)) , BlockBuilder.builderType.RAW)
            .setTextureType("custom").get();

    public static final Block GOLD_TILE = registerBlock(
            "gold_tile",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)) ,
            BlockBuilder.builderType.RAW
    ).setTextureType("cube_pool").get();
    public static final Block SHROOMLIGHT_WALL = registerBlock("shroomlight_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.SHROOMLIGHT)) , BlockBuilder.builderType.RAW)
            .setTextureType("custom").get();
    public static final Block REDSTONE_WALL = registerBlock("redstone_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK)) , BlockBuilder.builderType.RAW)
            .setTextureType("custom").get();
    public static final Block NETHER_WART_WALL = registerBlock("nether_wart_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK)) , BlockBuilder.builderType.RAW)
            .setTextureType("custom").get();
    public static final Block GREEN_STUCCO = registerBlock(  "green_stucco",Blocks.BLACK_CONCRETE )
            .addRecipe(new ItemConvertible[]{
                Items.GREEN_CONCRETE ,
                Items.SAND ,
                Items.SAND ,
                Items.SAND ,
                Items.SAND}
        ).get();
    /*public static final Block YELLOW_GLAZED_TERRACATA = registerBlock(
            "yellow_glazed_terracotta_center" ,
            new GlazedTerracottaBlock( FabricBlockSettings.copyOf(Blocks.GREEN_GLAZED_TERRACOTTA) ),
            BlockBuilder.builderType.RAW
    ).setTextureType("rotatable").get(); */
    public static final Block PINK_FOREST_FLOOR = registerBlock(  "pink_forest_floor", Blocks.GRASS_BLOCK )
            .addRecipe(new ItemConvertible[]{
                    Items.PINK_PETALS ,
                    Items.MOSS_BLOCK}
            ).get();
    public static final Block AQUA_ZIGZAG = registerBlock(  "aqua_zigzag", Blocks.TERRACOTTA )
            .addRecipe(new ItemConvertible[]{
                    Items.LIGHT_BLUE_CONCRETE ,
                    Items.CYAN_CONCRETE}
            ).get();
    public static final Block PALE_STUCCO = new BlockBuilder(
                "pale_stucco", Blocks.BLACK_CONCRETE
            )
            .addRecipe(new ItemConvertible[]{
                    Items.WHITE_CONCRETE ,
                    Items.SAND ,
                    Items.SAND ,
                    Items.SAND ,
                    Items.SAND}
            ).get();


    public static final Block PATH_STONE = new BlockBuilder(
            "path_stone",
            Blocks.STONE
        )
        .addRecipe(new ItemConvertible[]{
                    Items.ANDESITE,
                    Items.GRANITE ,
                    Items.DRIPSTONE_BLOCK ,
                    Items.COBBLESTONE}
        ).get();

    public static final Block LAPIS_TILE = registerBlock("lapis_tile", Blocks.LAPIS_BLOCK )
        .withWalls()
        .get();

    private static BlockBuilder registerBlock(String name , Block block ){
        return new BlockBuilder(name , block );
    }

    private static BlockBuilder registerBlock(String name , Block block , BlockBuilder.builderType type ){
        return new BlockBuilder(name , block , type  );
    }
    
    
    public static void registerModBlocks(){
        ExtraBlocks.LOGGER.info("Register Modblocks");
    }
    

}
