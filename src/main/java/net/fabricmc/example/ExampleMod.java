package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ExampleMod implements ModInitializer {

	public static final Item FABRIC_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Item BANANA_ITEM = new Item(new Item.Settings().group(ItemGroup.MISC));

	public static final Block BANANA_LEAVES = new Block(FabricBlockSettings.of(Material.LEAVES).strength(2.0f));

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
		Registry.register(Registry.BLOCK, new Identifier("andris_mod", "banana_leaves"), BANANA_LEAVES);
	}
	public void registerItems(){
		Registry.register(Registry.ITEM, new Identifier("andris_mod", "fabric_item"), FABRIC_ITEM);
		Registry.register(Registry.ITEM, new Identifier("andris_mod", "banana_item"), BANANA_ITEM);
		Registry.register(Registry.ITEM, new Identifier("andris_mod", "banana_leaves"), new BlockItem(BANANA_LEAVES, new FabricItemSettings().group(ItemGroup.MISC)));
	}
}
