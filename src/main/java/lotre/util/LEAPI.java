package lotre.util;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.client.LOTRTextures;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.LOTRCreativeTabs;
import lotr.common.LOTRDimension;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LEAPI {
	private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(arg, clazz, instance, new String[]{methodName}, methodTypes);
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
			} catch (IOException ignored) {
			}
		}
		return null;
	}

	private static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	private static InputStream getInputStream(ResourceLocation res) {
		return getInputStream(getContainer(res), getPath(res));
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + '/' + res.getResourcePath();
	}

	@SideOnly(Side.CLIENT)
	public static void setClientMapImage(ResourceLocation res) {
		ResourceLocation sepiaMapTexture;
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
		try {
			BufferedImage mapImage = getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
			sepiaMapTexture = findAndInvokeMethod(new Object[]{mapImage, new ResourceLocation("lotr:map_sepia")}, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
		} catch (IOException e) {
			FMLLog.severe("Failed to generate GOT sepia map");
			e.printStackTrace();
			sepiaMapTexture = res;
		}
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, sepiaMapTexture, "sepiaMapTexture");
	}

	public static LOTRWaypoint.Region addRegion(String name) {
		Class<?>[] classArr = new Class[]{};
		Object[] args = new Object[]{};
		return EnumHelper.addEnum(LOTRWaypoint.Region.class, name, classArr, args);
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z) {
		return addWaypoint(name, region, faction, x, z, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class<?>[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
		Object[] args = new Object[]{region, faction, x, z, hidden};
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	public static LOTRMapLabels addLabel(String enumName, LOTRBiome biomeLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
		return addLabel(enumName, (Object) biomeLabel, x, y, scale, angle, zoomMin, zoomMan);
	}

	private static LOTRMapLabels addLabel(String enumName, Object label, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
		Class<?>[] classArr = new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Float.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE};
		Object[] args = new Object[]{label, x, y, scale, angle, zoomMin, zoomMan};
		return EnumHelper.addEnum(LOTRMapLabels.class, enumName, classArr, args);
	}

	public static LOTRMapLabels addLabel(String enumName, String stringLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
		return addLabel(enumName, (Object) stringLabel, x, y, scale, angle, zoomMin, zoomMan);
	}

	public static LOTRCreativeTabs getLOTRCreativeTab(String name) {
		return ReflectionHelper.getPrivateValue(LOTRCreativeTabs.class, null, name);
	}

	@SuppressWarnings("NumericCastThatLosesPrecision")
	public static void setServerMapImage(ResourceLocation res) {
		BufferedImage img = getImage(getInputStream(res));
		LOTRGenLayerWorld.imageWidth = img.getWidth();
		LOTRGenLayerWorld.imageHeight = img.getHeight();
		int[] colors = img.getRGB(0, 0, LOTRGenLayerWorld.imageWidth, LOTRGenLayerWorld.imageHeight, null, 0, LOTRGenLayerWorld.imageWidth);
		byte[] biomeImageData = new byte[LOTRGenLayerWorld.imageWidth * LOTRGenLayerWorld.imageHeight];
		for (int i = 0; i < colors.length; ++i) {
			int color = colors[i];
			Integer biomeID = LOTRDimension.MIDDLE_EARTH.colorsToBiomeIDs.get(color);
			if (biomeID != null) {
				biomeImageData[i] = (byte) biomeID.intValue();
			}
		}
		ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
	}
}