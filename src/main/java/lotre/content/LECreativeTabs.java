package lotre.content;

import lotr.common.LOTRCreativeTabs;
import lotre.util.LEAPI;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class LECreativeTabs {
	public static LOTRCreativeTabs tabBlocks;

	private LECreativeTabs() {
	}

	public static void preInit() {
		tabBlocks = LEAPI.getLOTRCreativeTab("tabBlock");
	}
}