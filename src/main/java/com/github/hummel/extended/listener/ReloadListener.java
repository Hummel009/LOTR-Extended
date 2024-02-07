package com.github.hummel.extended.listener;

import com.github.hummel.extended.api.API;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;

public class ReloadListener {
	public static class Map implements IResourceManagerReloadListener {
		@Override
		public void onResourceManagerReload(IResourceManager resourceManager) {
			API.setClientMapImage(new ResourceLocation("lotre:map/map.png"));
		}
	}
}