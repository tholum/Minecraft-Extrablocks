package holum.extrablocks.Item;

import holum.extrablocks.Block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import holum.extrablocks.ExtraBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExtraBlocks.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("extrablocks.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        entries.add(ModBlocks.GREEN_STUCCO);
                        entries.add(ModBlocks.PINK_FOREST_FLOOR);
                        entries.add(ModBlocks.AQUA_ZIGZAG);
                        entries.add(ModBlocks.PALE_STUCCO);
                        entries.add(ModBlocks.PATH_STONE );


                    }).build());
    public static void registerItemGroups(){
        ExtraBlocks.LOGGER.info("Registering Item Groups");

    }
}
