package com.github.hummel.extended;

import com.github.hummel.extended.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "lotre", dependencies = "required-after:lotr", useMetadata = true)
public class Main {
	@SidedProxy(clientSide = "com.github.hummel.extended.proxy.ClientProxy", serverSide = "com.github.hummel.extended.proxy.ServerProxy")
	private static CommonProxy proxy;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
	}
}
