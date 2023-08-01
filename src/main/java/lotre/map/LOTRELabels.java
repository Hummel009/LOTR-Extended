package lotre.map;

import lotr.client.gui.LOTRMapLabels;
import lotr.common.world.biome.LOTRBiome;
import net.minecraftforge.common.util.EnumHelper;

public class LOTRELabels {
	public static LOTRMapLabels addLabel(String enumName, LOTRBiome biomeLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
		return addLabel(enumName, (Object) biomeLabel, x, y, scale, angle, zoomMin, zoomMan);
	}

	private static LOTRMapLabels addLabel(String enumName, Object label, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
		Class<?>[] classArr = {Object.class, Integer.TYPE, Integer.TYPE, Float.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE};
		Object[] args = {label, x, y, scale, angle, zoomMin, zoomMan};
		return EnumHelper.addEnum(LOTRMapLabels.class, enumName, classArr, args);
	}

	public static void addLabel(String enumName, String stringLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
		addLabel(enumName, (Object) stringLabel, x, y, scale, angle, zoomMin, zoomMan);
	}

	public static void registerLabels() {
		addLabel("DARKLAND", "darkland", 2376, 4139, 40.0f, -30, -6.0f, -1.0f);
		addLabel("SUNLAND", "sunland", 3686, 2784, 20.0f, 0, -6.0f, -1.0f);
	}
}