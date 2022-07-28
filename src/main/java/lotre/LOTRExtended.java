package lotre;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import lotre.biome.LOTREBiome;
import lotre.block.LOTREBlockRock;
import lotre.map.LOTREWaypoint;
import lotre.proxy.LOTREServerProxy;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "lotre", dependencies = "required-after:lotr")
public class LOTRExtended {
	@SidedProxy(clientSide = "lotre.proxy.LOTREClientProxy", serverSide = "lotre.proxy.LOTREServerProxy")
	public static LOTREServerProxy proxy;
	public static Block rock;

	@EventHandler
	public void onInit(FMLInitializationEvent event) {
		LOTRECreativeTabs.onInit();
		LOTREBiome.onInit();
		LOTRECommander.setServerMapImage(new ResourceLocation("lotre:map/map.png"));
		proxy.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOTREWaypoint.preInit();
		proxy.preInit();
		rock = new LOTREBlockRock();
		register(rock, "rock_yellow");
	}

	public static void register(Block block, String codename) {
		block.setBlockName("lotre:" + codename);
		block.setBlockTextureName("lotre:" + codename);
		GameRegistry.registerBlock(block, "tile." + codename);
	}
}
