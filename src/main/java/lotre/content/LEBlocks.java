package lotre.content;

import cpw.mods.fml.common.registry.GameRegistry;
import lotre.block.LEBlockRock;
import net.minecraft.block.Block;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class LEBlocks {
	public static Block rock;

	public static void preInit() {
		rock = new LEBlockRock().setCreativeTab(LECreativeTabs.tabBlocks);
		register(rock, "rock_yellow");
	}

	private static void register(Block block, String codename) {
		block.setBlockName("lotre:" + codename);
		block.setBlockTextureName("lotre:" + codename);
		GameRegistry.registerBlock(block, "tile." + codename);
	}
}