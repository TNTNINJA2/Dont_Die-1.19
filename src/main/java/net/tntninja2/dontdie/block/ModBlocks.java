package net.tntninja2.dontdie.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.tntninja2.dontdie.DontDie;
import net.tntninja2.dontdie.block.custom.EggplantCropBlock;
import net.tntninja2.dontdie.block.custom.EnergyCoreBlock;
import net.tntninja2.dontdie.block.custom.MythrilLampBlock;
import net.tntninja2.dontdie.item.ModItemGroup;

public class ModBlocks {

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5).sounds(BlockSoundGroup.METAL)), ModItemGroup.ITEM_GROUP_EXAMPLE);
//    To make a new block, copy the lines above, lines in en_us, and .json files in blockstates, models/block,
//    models/item, and textures/block folders
//    Add things after "of(Material.METAL)" to change the properties of the block.

    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3).sounds(BlockSoundGroup.STONE)), ModItemGroup.ITEM_GROUP_EXAMPLE);

    public static final Block MYTHRIL_LAMP = registerBlock("mythril_lamp",
            new MythrilLampBlock(FabricBlockSettings.of(Material.STONE).luminance(state -> state.get(MythrilLampBlock.LIT)? 15 : 0).requiresTool().strength(3).sounds(BlockSoundGroup.STONE)), ModItemGroup.ITEM_GROUP_EXAMPLE);

    public static final Block EGGPLANT_CROP = registerBlockWithoutItem("eggplant_crop",
            new EggplantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    public static final Block BLAST_SHIELDING = registerBlock("blast_shielding",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(6,12).sounds(BlockSoundGroup.METAL)), ModItemGroup.ITEM_GROUP_EXAMPLE);

    public static final Block ENERGY_CORE = registerBlockWithoutItem("energy_core",
            new EnergyCoreBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2,2).sounds(BlockSoundGroup.METAL).nonOpaque()));


    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(DontDie.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registry.BLOCK, new Identifier(DontDie.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup itemgroup) {
        return Registry.register(Registry.ITEM, new Identifier(DontDie.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(itemgroup)));
    }

    public static void registerModBlocks() {
        DontDie.LOGGER.debug("Registering MobBlocks for " + DontDie.MOD_ID);
    }
}
