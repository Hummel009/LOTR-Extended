package com.github.hummel.extended.init;

import com.github.hummel.extended.api.API;
import lotr.common.LOTRCreativeTabs;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class CreativeTabs {
	public static LOTRCreativeTabs tabBlocks;

	private CreativeTabs() {
	}

	public static void preInit() {
		tabBlocks = API.getLOTRCreativeTab("tabBlock");
	}
}