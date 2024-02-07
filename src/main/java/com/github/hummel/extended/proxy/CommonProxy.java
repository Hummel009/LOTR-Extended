package com.github.hummel.extended.proxy;

import com.github.hummel.extended.api.API;
import com.github.hummel.extended.init.Biomes;
import com.github.hummel.extended.init.Blocks;
import com.github.hummel.extended.init.CreativeTabs;
import com.github.hummel.extended.init.Waypoints;
import net.minecraft.util.ResourceLocation;

public interface CommonProxy {
	default void onInit() {
		Biomes.onInit();

		API.setCommonMapImage(new ResourceLocation("lotre:map/map.png"));
	}

	default void preInit() {
		Waypoints.preInit();
		CreativeTabs.preInit();
		Blocks.preInit();
	}
}