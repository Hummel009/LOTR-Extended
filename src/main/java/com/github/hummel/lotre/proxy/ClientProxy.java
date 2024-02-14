package com.github.hummel.lotre.proxy;

import com.github.hummel.lotre.init.MapLabels;
import com.github.hummel.lotre.listener.ReloadListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class ClientProxy implements CommonProxy {
	@Override
	public void onInit() {
		IResourceManagerReloadListener reloadListener = new ReloadListener();
		IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();
		reloadListener.onResourceManagerReload(resourceManager);
		((IReloadableResourceManager) resourceManager).registerReloadListener(reloadListener);

		MapLabels.onInit();
	}
}