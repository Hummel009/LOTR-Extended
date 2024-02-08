package com.github.hummel.lotre.init;

import com.github.hummel.lotre.block.BlockRock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Blocks {
	public static Block rock;

	private Blocks() {
	}

	public static void preInit() {
		rock = new BlockRock().setCreativeTab(CreativeTabs.tabBlocks);
		register(rock, "rock_yellow");
	}

	private static void register(Block block, String codename) {
		block.setBlockName("lotre:" + codename);
		block.setBlockTextureName("lotre:" + codename);
		GameRegistry.registerBlock(block, "tile." + codename);
	}
}