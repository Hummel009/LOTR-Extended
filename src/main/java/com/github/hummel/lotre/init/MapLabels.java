package com.github.hummel.lotre.init;

import com.github.hummel.lotre.api.API;
import lotr.client.gui.LOTRMapLabels;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class MapLabels {
	public static LOTRMapLabels darkland;
	public static LOTRMapLabels sunland;

	private MapLabels() {
	}

	public static void onInit() {
		darkland = API.addMapLabel("DARKLAND", "darkland", 2376, 4139, 40.0f, -30, -6.0f, -1.0f);
		sunland = API.addMapLabel("SUNLAND", "sunland", 3686, 2784, 20.0f, 0, -6.0f, -1.0f);
	}
}