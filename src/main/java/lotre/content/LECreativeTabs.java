package lotre.content;

import lotr.common.LOTRCreativeTabs;
import lotre.util.LEAPI;

public class LECreativeTabs {
	public static LOTRCreativeTabs tabBlocks;

	public static void preInit() {
		tabBlocks = LEAPI.getLOTRCreativeTab("tabBlock");
	}
}