package lotr.extended.map;

import lotr.client.gui.LOTRMapLabels;
import lotr.common.world.biome.LOTRBiome;
import net.minecraftforge.common.util.EnumHelper;

public class LOTRELabels {
    public static void registerLabels() {
        LOTRELabels.addLabel("DARKLAND", "darkland", 2376, 4139, 40.0f, -30, -6.0f, -1.0f);
        LOTRELabels.addLabel("SUNLAND", "sunland", 3686, 2784, 20.0f, 0, -6.0f, -1.0f);
    }
    
    public static LOTRMapLabels addLabel(String enumName, LOTRBiome biomeLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
        return LOTRELabels.addLabel(enumName, (Object)biomeLabel, x, y, scale, angle, zoomMin, zoomMan);
    }

    public static LOTRMapLabels addLabel(String enumName, String stringLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
        return LOTRELabels.addLabel(enumName, (Object)stringLabel, x, y, scale, angle, zoomMin, zoomMan);
    }

    private static LOTRMapLabels addLabel(String enumName, Object label, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
        Class[] classArr = new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Float.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE};
        Object[] args = new Object[]{label, x, y, Float.valueOf(scale), angle, Float.valueOf(zoomMin), Float.valueOf(zoomMan)};
        return EnumHelper.addEnum(LOTRMapLabels.class, enumName, classArr, args);
    }
}

