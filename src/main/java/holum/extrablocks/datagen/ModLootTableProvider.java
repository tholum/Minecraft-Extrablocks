package holum.extrablocks.datagen;

import holum.extrablocks.Block.BlockBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (int i = 0; i < BlockBuilder.blockBuilders.size(); i++){
            BlockBuilder block = BlockBuilder.blockBuilders.get(i);
            if( block.droppable){
                addDrop(block.get());
            }
            if( block.registerWall){
                addDrop(block.getWall());
            }
        }
    }
}
