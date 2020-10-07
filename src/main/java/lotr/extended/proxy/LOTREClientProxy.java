package lotr.extended.proxy;

import lotr.extended.LOTRECommander;
import lotr.extended.map.LOTRELabels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;

public class LOTREClientProxy extends LOTREServerProxy implements IResourceManagerReloadListener {
	private LOTREClientProxy mapChanger;

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LOTRECommander.setClientMapImage(new ResourceLocation("lotre:map/map.png"));
	}  
	
	public void preInit() {
		this.mapChanger = new LOTREClientProxy();
	}
	
	public void onInit() {
        LOTRELabels.registerLabels();
		((IReloadableResourceManager)Minecraft.getMinecraft().getResourceManager()).registerReloadListener((IResourceManagerReloadListener)this.mapChanger);
	}
}