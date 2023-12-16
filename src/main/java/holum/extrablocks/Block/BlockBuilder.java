package holum.extrablocks.Block;

import holum.extrablocks.ExtraBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class BlockBuilder {
    public static enum builderType {
        BLOCK,
        LOG,
        RAW,
        LEAVES
    }
    public static ArrayList<BlockBuilder> blockBuilders = new ArrayList<BlockBuilder>();
    public ArrayList<ModBlockRecipe> recipes = new ArrayList<ModBlockRecipe>();
    /*public static ArrayList<Block> blockStateSimpleCubeAll = new ArrayList<Block>();
    public static ArrayList<ModBlockRecipe> recipes = new ArrayList<ModBlockRecipe>();
    public static ArrayList<Block> blocks = new ArrayList<Block>(); */
    private final Block blk;

    public String blockstate = "simple";

    public String textureType = "simple_cube_all";
    public Boolean droppable = true;
    public Boolean pickaxeMinable = true;
    BlockBuilder(String name , Block block ){
        this( name , block , builderType.BLOCK);
        //blk = registerBlock( name , new Block(FabricBlockSettings.copyOf( block )) );
    }
    BlockBuilder(String name , Block block , builderType type  ){
        switch( type ){
            default:
            case BLOCK:
                blk = registerBlock( name , new Block(FabricBlockSettings.copyOf( block )) );
                break;
            case LEAVES:
                blk = registerBlock( name , new LeavesBlock( FabricBlockSettings.copyOf(block).nonOpaque().luminance(10) ));
                break;
            case LOG:
                blk = registerBlock( name , new PillarBlock(FabricBlockSettings.copyOf( block )) );
                break;
            case RAW:
                blk = registerBlock( name , block );
                break;
        }
        blockBuilders.add( this );

    }
    public BlockBuilder changeState( String state ){
        blockstate = state;
        return this;
    }
    public BlockBuilder setDropable( Boolean d ){
        droppable = d;
        return this;
    }
    public Block get(){

        return blk;
    }
    public BlockBuilder setTextureType( String t ){
        this.textureType = t;
        return this;
    }
    public BlockBuilder addRecipe( ModBlockRecipe mbr ){
        mbr.setBlock( blk );
        this.recipes.add( mbr );
        return this;
    }
    public BlockBuilder addRecipe(ItemConvertible[] items ){
        return this.addRecipe(new ModBlockRecipe(
                items
        ));
    }
    private  Block registerBlock(String name , Block block ){
        registerBlockItem(name , block );
        return Registry.register(Registries.BLOCK , new Identifier(ExtraBlocks.MOD_ID , name ) , block );
    }
    private  void registerBlockItem(String name , Block block ){
        Registry.register(Registries.ITEM , new Identifier(ExtraBlocks.MOD_ID , name ) , new BlockItem( block , new FabricItemSettings()));
    }
}
