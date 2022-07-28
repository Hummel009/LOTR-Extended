package lotre;

import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.LOTRCreativeTabs;

public class LOTRECreativeTabs {
	public static LOTRCreativeTabs tabBlocks;

	private static LOTRCreativeTabs getLOTRCreativeTab(String name) {
		return ReflectionHelper.getPrivateValue(LOTRCreativeTabs.class, null, name);
	}

	public static void onInit() {
		tabBlocks = getLOTRCreativeTab("tabBlock");
		LOTRExtended.rock.setCreativeTab(tabBlocks);
	}
}