package holum.extrablocks.datagen;

import holum.extrablocks.Block.BlockBuilder;
import holum.extrablocks.Block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        for (int i = 0; i < BlockBuilder.blockBuilders.size(); i++){
            BlockBuilder block = BlockBuilder.blockBuilders.get(i);
             for (int x = 0; x < block.blockTags.size(); x++){
                TagKey<Block> tag = block.blockTags.get( x );
                getOrCreateTagBuilder(tag).add( block.get() );
             }
             if( block.registerWall){
                getOrCreateTagBuilder(BlockTags.WALLS).add(block.getWall());        
             }
        }

        getOrCreateTagBuilder(BlockTags.WALLS)
                /* .add(ModBlocks.GOLD_WALL) */
                .add(ModBlocks.SHROOMLIGHT_WALL)
                .add(ModBlocks.NETHER_WART_WALL)
                .add(ModBlocks.REDSTONE_WALL)
                .add(ModBlocks.GOLD_TILE_WALL);
    }
}
