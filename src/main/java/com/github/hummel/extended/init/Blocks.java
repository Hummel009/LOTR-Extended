package com.github.hummel.extended.init;

import cpw.mods.fml.common.registry.GameRegistry;
import com.github.hummel.extended.block.BlockRock;
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