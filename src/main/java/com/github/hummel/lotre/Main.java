package com.github.hummel.lotre;

import com.github.hummel.lotre.api.API;
import com.github.hummel.lotre.init.Biomes;
import com.github.hummel.lotre.init.Blocks;
import com.github.hummel.lotre.init.CreativeTabs;
import com.github.hummel.lotre.init.Waypoints;
import com.github.hummel.lotre.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "lotre", dependencies = "required-after:lotr", useMetadata = true)
public class Main {
	@SidedProxy(clientSide = "com.github.hummel.lotre.proxy.ClientProxy", serverSide = "com.github.hummel.lotre.proxy.ServerProxy")
	private static CommonProxy proxy;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		Biomes.onInit();

		API.setCommonMapImage(new ResourceLocation("lotre:map/map.png"));

		proxy.onInit();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Waypoints.preInit();
		CreativeTabs.preInit();
		Blocks.preInit();
	}
}