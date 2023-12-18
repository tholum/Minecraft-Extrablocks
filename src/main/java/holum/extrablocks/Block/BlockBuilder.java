package holum.extrablocks.Block;

import holum.extrablocks.ExtraBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockBuilder {
    public static enum builderType {
        BLOCK,
        LOG,
        RAW,
        LEAVES,
        REFERENCE
    }
    public static final Logger LOGGER = LoggerFactory.getLogger(ExtraBlocks.MOD_ID);

    public static ArrayList<BlockBuilder> blockBuilders = new ArrayList<BlockBuilder>();
    public ArrayList<ModBlockRecipe> recipes = new ArrayList<ModBlockRecipe>();
    public ArrayList<TagKey<Block>> blockTags = new ArrayList<TagKey<Block>>();

    /*public static ArrayList<Block> blockStateSimpleCubeAll = new ArrayList<Block>();
    public static ArrayList<ModBlockRecipe> recipes = new ArrayList<ModBlockRecipe>();
    public static ArrayList<Block> blocks = new ArrayList<Block>(); */
    private Boolean blockInitialized = false;
    private Block blk;
    public String displayname;
    public String name;
    public String blockstate = "simple";
    public builderType type;
    public String textureType = "simple_cube_all";
    public Boolean droppable = true;
    private String mod_id;


    

    public Boolean registerWall = false;
    private Boolean wallInitialized = false;
    private Block wall;
    

    private Block initalBlock;

    BlockBuilder(String propname , Block propblock ){
        this( propname , propblock , builderType.BLOCK );
        //blk = registerBlock( name , new Block(FabricBlockSettings.copyOf( block )) );
    }
    BlockBuilder(String propname , Block propblock , builderType inittype ){
        name = propname;
        type = inittype;
        mod_id = ExtraBlocks.MOD_ID;
        displayname = name.replace("_" , " ");
        initalBlock = propblock;
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

    private Block genWall(){
        
        return registerBlock( name + "_wall" , new WallBlock(FabricBlockSettings.copyOf( initalBlock )) ); 
    }


    private Block genBlock(){
        
        switch( type ){
            default:
            case BLOCK:
                // registerWall = true;
                return registerBlock( name , new Block(FabricBlockSettings.copyOf( initalBlock )) );

            case LEAVES:
                return registerBlock( name , new LeavesBlock( FabricBlockSettings.copyOf(initalBlock).nonOpaque() ));
            case LOG:
                return registerBlock( name , new PillarBlock(FabricBlockSettings.copyOf( initalBlock )) );
            
            case RAW:
                return registerBlock( name , initalBlock );
            case REFERENCE:
                // return registerBlock( name , initalBlock , "minecraft");
                return initalBlock;
        }
    }
   
    public void defaultTags(){
        switch( type ){
            default:
            case RAW:
            case BLOCK:
                if( blockTags.size() == 0 ){
                    blockTags.add(BlockTags.PICKAXE_MINEABLE);
                }
                break;
            case LEAVES:
                if( blockTags.size() == 0 ){
                    blockTags.add(BlockTags.HOE_MINEABLE);
                }
                break;
            case LOG:
                if( blockTags.size() == 0 ){
                    blockTags.add(BlockTags.AXE_MINEABLE);
                }
                break;
                
        }
    }
    private void fixRecipes(){
        for (int x = 0; x < this.recipes.size(); x++) {
            recipes.get(x).setBlock(blk);
        }
    }

    public Block get(){
        if( blockInitialized == false ){
            this.blockInitialized = true;
            this.defaultTags();
            this.blk = this.genBlock();
            this.fixRecipes();
            if( registerWall == true ){
                this.getWall();
            }
        }
    
        return this.blk;
    }
    public Block getWall(){
        LOGGER.info("Getting Wall " + name + "_wall");
        if( wallInitialized == false ){
            LOGGER.info("Wall Un Initalized " + name + "_wall");
            this.wallInitialized = true;
            this.wall = this.genWall();
        }
        return this.wall;
    }
    public BlockBuilder withWalls(){
        registerWall = true;
        return this;
    }
     public BlockBuilder withoutWalls(){
        registerWall = false;
        return this;
    }
    public BlockBuilder addTag( TagKey<Block> tag ){
        this.blockTags.add( tag );
        return this;
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
    public Boolean needsPool(){
        return registerWall;
    }

    private Block registerBlock( String name , Block block ){
        return this.registerBlock(name, block , mod_id );
    }

    private  Block registerBlock(String name , Block block , String mod ){
        LOGGER.info("Registering Block " + name);
        registerBlockItem(name , block , mod );
        return Registry.register(Registries.BLOCK , new Identifier(mod, name ) , block );
    }
    private  void registerBlockItem(String name , Block block , String mod  ){
        LOGGER.info("Registering Item " + name);
        
        Registry.register(Registries.ITEM , new Identifier(mod , name ) , new BlockItem( block , new FabricItemSettings()));
    }
}
