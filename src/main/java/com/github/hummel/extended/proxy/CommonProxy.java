package com.github.hummel.extended.proxy;

import com.github.hummel.extended.api.API;
import net.minecraft.util.ResourceLocation;

public interface CommonProxy {
	default void onInit() {
		API.setCommonMapImage(new ResourceLocation("lotre:map/map.png"));
	}
}