package com.github.hummel.lotre.init;

import com.github.hummel.lotre.api.API;
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