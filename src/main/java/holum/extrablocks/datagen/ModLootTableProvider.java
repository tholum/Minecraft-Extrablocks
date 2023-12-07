package holum.extrablocks.datagen;

import holum.extrablocks.Block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.AQUA_ZIGZAG);
        addDrop(ModBlocks.GREEN_STUCCO);
        addDrop(ModBlocks.PALE_STUCCO);
        addDrop(ModBlocks.PATH_STONE);
        addDrop(ModBlocks.PINK_FOREST_FLOOR);
    }
}
