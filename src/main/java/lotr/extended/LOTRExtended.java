package lotr.extended;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lotr.extended.biome.LOTREBiome;
import lotr.extended.map.LOTREWaypoint;
import lotr.extended.proxy.LOTREServerProxy;
import net.minecraft.util.ResourceLocation;

@Mod(modid="lotre", version=LOTRExtended.UPDATE, name=LOTRExtended.NAME, dependencies="required-after:lotr")

public class LOTRExtended {
	public static final String UPDATE = "Version 2.0";
	public static final String NAME = "LOTR: Extended";
	@SidedProxy(clientSide="lotr.extended.proxy.LOTREClientProxy", serverSide="lotr.extended.proxy.LOTREServerProxy")
	public static LOTREServerProxy proxy;
	 
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOTREWaypoint.preInit();
		proxy.preInit();
	}
	    
	@EventHandler
	public void onInit(FMLInitializationEvent event) {   
		LOTRECreativeTabs.onInit();
		LOTREBiome.onInit();
		LOTRECommander.setServerMapImage(new ResourceLocation("lotre:map/map.png"));
		proxy.onInit();
	}
}