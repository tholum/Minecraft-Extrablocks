package holum.extrablocks.datagen;

import holum.extrablocks.Block.BlockBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModBlockLangProvider extends FabricLanguageProvider {
	public ModBlockLangProvider(FabricDataOutput dataGenerator) {
                // Specifying en_us is optional, by default is is en_us.
		super(dataGenerator, "en_us");
        
	}
 
	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
        for (int i = 0; i < BlockBuilder.blockBuilders.size(); i++){
            BlockBuilder block = BlockBuilder.blockBuilders.get(i);
            translationBuilder.add(block.get(), block.displayname );
        }
        
	}
}