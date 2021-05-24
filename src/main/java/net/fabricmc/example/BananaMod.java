package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class BananaMod implements ModInitializer {

	public static final String MOD_NAME = "banana-mod";

	public static final Item BANANA_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

	public static final Block BANANA_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(2.0f));
	public static final Block BANANA_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//blocks
		registerBlocks();
		//items
		registerItems();
	}

	public void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(MOD_NAME, "banana_leaves"), BANANA_LEAVES);
		Registry.register(Registry.BLOCK, new Identifier(MOD_NAME, "banana_log"), BANANA_LOG);
	}

	public void registerItems(){
		Registry.register(Registry.ITEM, new Identifier(MOD_NAME, "banana_item"), BANANA_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_NAME, "banana_leaves"), new BlockItem(BANANA_LEAVES, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier(MOD_NAME, "banana_log"), new BlockItem(BANANA_LOG, new FabricItemSettings().group(ItemGroup.MISC)));
	}
}
