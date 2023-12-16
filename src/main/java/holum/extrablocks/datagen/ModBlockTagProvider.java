package holum.extrablocks.datagen;

import holum.extrablocks.Block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.AQUA_ZIGZAG)
                .add(ModBlocks.GREEN_STUCCO)
                .add(ModBlocks.PINK_FOREST_FLOOR)
                .add(ModBlocks.PALE_STUCCO)
                .add(ModBlocks.PATH_STONE);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.GOLDEN_BIRCH_PLANKS)
                .add(ModBlocks.GOLDEN_BIRCH );
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.GOLDEN_BIRCH_LEAVES)
                .add(ModBlocks.GREEN_SHROOMLIGHT)
                /* .add(ModBlocks.YELLOW_GLAZED_TERRACATA ) */;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GOLD_WALL)
                .add(ModBlocks.SHROOMLIGHT_WALL)
                .add(ModBlocks.NETHER_WART_WALL)
                .add(ModBlocks.REDSTONE_WALL)
                .add(ModBlocks.GOLD_TILE_WALL);
    }
}
