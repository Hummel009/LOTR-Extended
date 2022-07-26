package lotre.proxy;

import lotre.LOTRECommander;
import lotre.map.LOTRELabels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;

public class LOTREClientProxy extends LOTREServerProxy implements IResourceManagerReloadListener {
	private LOTREClientProxy mapChanger;

	@Override
	public void onInit() {
		LOTRELabels.registerLabels();
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(mapChanger);
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LOTRECommander.setClientMapImage(new ResourceLocation("lotre:map/map.png"));
	}

	@Override
	public void preInit() {
		mapChanger = new LOTREClientProxy();
	}
}