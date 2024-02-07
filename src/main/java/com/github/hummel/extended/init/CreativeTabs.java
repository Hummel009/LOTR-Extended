package com.github.hummel.extended.init;

import lotr.common.LOTRCreativeTabs;
import com.github.hummel.extended.api.API;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class CreativeTabs {
	public static LOTRCreativeTabs tabBlocks;

	private CreativeTabs() {
	}

	public static void preInit() {
		tabBlocks = API.getLOTRCreativeTab("tabBlock");
	}
}