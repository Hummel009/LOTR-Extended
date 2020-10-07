package lotr.extended;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.LOTRCreativeTabs;
import lotr.common.LOTRMod;
import lotr.extended.biome.LOTREBiome;
import lotr.extended.map.LOTRELabels;
import lotr.extended.map.LOTREWaypoint;
import lotr.extended.proxy.LOTREServerProxy;
import net.minecraft.util.ResourceLocation;

public class LOTRECreativeTabs {
	public static LOTRCreativeTabs tabBlocks;

	public static void onInit() {
		tabBlocks = getLOTRCreativeTab("tabBlock");
		LOTRMod.rock.setCreativeTab(tabBlocks);
	}
	 
	private static LOTRCreativeTabs getLOTRCreativeTab(String name) {
		return ReflectionHelper.getPrivateValue(LOTRCreativeTabs.class, null, name);
	}
}