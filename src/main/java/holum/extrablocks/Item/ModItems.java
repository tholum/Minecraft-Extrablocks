package holum.extrablocks.Item;

import holum.extrablocks.ExtraBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby" , new Item( new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby" , new Item( new FabricItemSettings()));

    private static Item registerItem(String name , Item item ){
        return Registry.register(Registries.ITEM , new Identifier(ExtraBlocks.MOD_ID , name) , item);
    }
    private  static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }
    public static void registerModItems(){
        ExtraBlocks.LOGGER.info("Registering ModItems");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
