package lotre.proxy;

import lotre.content.LELabels;
import lotre.util.LEAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;

public class LEClientProxy extends LEServerProxy implements IResourceManagerReloadListener {
	@Override
	public void onInit() {
		LELabels.onInit();
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new LEClientProxy());
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LEAPI.setClientMapImage(new ResourceLocation("lotre:map/map.png"));
	}
}