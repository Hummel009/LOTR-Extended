package lotre;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.*;

import javax.imageio.ImageIO;

import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;
import lotr.client.LOTRTextures;
import lotr.common.LOTRDimension;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class LOTRECommander {

	private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return LOTRECommander.findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}

	private static BufferedImage getImage(InputStream in) {
		try {
			return ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	private static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	private static InputStream getInputStream(ResourceLocation res) {
		return LOTRECommander.getInputStream(LOTRECommander.getContainer(res), LOTRECommander.getPath(res));
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + "/" + res.getResourcePath();
	}

	@SideOnly(value = Side.CLIENT)
	public static void setClientMapImage(ResourceLocation res) {
		ResourceLocation sepiaMapTexture;
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
		try {
			BufferedImage mapImage = LOTRECommander.getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
			sepiaMapTexture = LOTRECommander.findAndInvokeMethod(new Object[] { mapImage, new ResourceLocation("lotr:map_sepia") }, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
		} catch (IOException e) {
			FMLLog.severe("Failed to generate GOT sepia map");
			e.printStackTrace();
			sepiaMapTexture = res;
		}
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, sepiaMapTexture, "sepiaMapTexture");
	}

	public static void setServerMapImage(ResourceLocation res) {
		BufferedImage img = LOTRECommander.getImage(LOTRECommander.getInputStream(res));
		LOTRGenLayerWorld.imageWidth = img.getWidth();
		LOTRGenLayerWorld.imageHeight = img.getHeight();
		int[] colors = img.getRGB(0, 0, LOTRGenLayerWorld.imageWidth, LOTRGenLayerWorld.imageHeight, null, 0, LOTRGenLayerWorld.imageWidth);
		byte[] biomeImageData = new byte[LOTRGenLayerWorld.imageWidth * LOTRGenLayerWorld.imageHeight];
		for (int i = 0; i < colors.length; ++i) {
			int color = colors[i];
			Integer biomeID = LOTRDimension.MIDDLE_EARTH.colorsToBiomeIDs.get(color);
			if (biomeID != null) {
				biomeImageData[i] = (byte) biomeID.intValue();
				continue;
			}
		}
		ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
	}
}