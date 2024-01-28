package lotre;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lotre.biome.LEBiome;
import lotre.content.LEBlocks;
import lotre.content.LECreativeTabs;
import lotre.content.LEWaypoints;
import lotre.proxy.LEServerProxy;
import lotre.util.LEAPI;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "lotre", dependencies = "required-after:lotr", useMetadata = true)
public class LOTRExtended {
	@SidedProxy(clientSide = "lotre.proxy.LEClientProxy", serverSide = "lotre.proxy.LEServerProxy")
	private static LEServerProxy proxy;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		LEBiome.onInit();
		LEAPI.setServerMapImage(new ResourceLocation("lotre:map/map.png"));
		proxy.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LEWaypoints.preInit();
		LECreativeTabs.preInit();
		LEBlocks.preInit();
	}
}
