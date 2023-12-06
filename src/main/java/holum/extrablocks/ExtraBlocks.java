package holum.extrablocks;

import holum.extrablocks.Block.ModBlocks;
import holum.extrablocks.Item.ModItemGroups;
import holum.extrablocks.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraBlocks implements ModInitializer {
	public static final String MOD_ID = "extrablocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}