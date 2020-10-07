package lotr.extended;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.imageio.ImageIO;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.client.LOTRTextures;
import lotr.common.LOTRDimension;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class LOTRECommander {
  
	
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
              biomeImageData[i] = (byte)biomeID.intValue();
              continue;
          }
      }
      ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
  }

  @SideOnly(value=Side.CLIENT)
  public static void setClientMapImage(ResourceLocation res) {
      ResourceLocation sepiaMapTexture;
      ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
      try {
          BufferedImage mapImage = LOTRECommander.getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
          sepiaMapTexture = LOTRECommander.findAndInvokeMethod(new Object[]{mapImage, new ResourceLocation("lotr:map_sepia")}, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
      }
      catch (IOException e) {
          FMLLog.severe("Failed to generate GOT sepia map", new Object[0]);
          e.printStackTrace();
          sepiaMapTexture = res;
      }
      ReflectionHelper.setPrivateValue(LOTRTextures.class, null, sepiaMapTexture, "sepiaMapTexture");
  }
  
  private static BufferedImage getImage(InputStream in) {
      try {
          BufferedImage bufferedImage2 = ImageIO.read(in);
          return bufferedImage2;
      }
      catch (IOException e) {
          e.printStackTrace();
      }
      finally {
          try {
              in.close();
          }
          catch (IOException e) {}
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

  private static ModContainer getContainer(ResourceLocation res) {
      ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
      if (modContainer == null) {
          throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
      }
      return modContainer;
  }
  
  private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
    return LOTRECommander.findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
  }
  
  private static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
    Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
    try {
      return (T)addControlZoneMethod.invoke(instance, args);
    } catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  private static <E> E findAndInvokeConstructor(Object[] args, String className, Class<?>... parameterTypes) {
    try {
      return (E) LOTRECommander.findAndInvokeConstructor(args, Class.forName(className), parameterTypes);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  private static <E> E findAndInvokeConstructor(Object[] args, Class<E> clazz, Class<?>... parameterTypes) {
    Constructor<E> constructor = LOTRECommander.findConstructor(clazz, parameterTypes);
    constructor.setAccessible(true);
    try {
      return constructor.newInstance(args);
    } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  private static <E> Constructor<E> findConstructor(Class<E> clazz, Class<?>... parameterTypes) {
    try {
      return clazz.getDeclaredConstructor(parameterTypes);
    } catch (NoSuchMethodException|SecurityException e) {
      e.printStackTrace();
      return null;
    } 
  }
}