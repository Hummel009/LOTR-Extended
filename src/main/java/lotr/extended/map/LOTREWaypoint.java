package lotr.extended.map;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraftforge.common.util.EnumHelper;

public class LOTREWaypoint {
    public static LOTRWaypoint Barazimabul;
    public static LOTRWaypoint MabladDum;
    public static LOTRWaypoint NaradDum;
    public static LOTRWaypoint Aldarion;
    public static LOTRWaypoint Taurethrim;

    public static void preInit() {
        Region.init();
        LOTREWaypoint.addWaypoints();
    }

    public static void addWaypoints() {
    	Barazimabul = LOTREWaypoint.addWaypoint("Barazimabul", Region.Darkland, LOTRFaction.UNALIGNED, 2963, 4044);
    	MabladDum = LOTREWaypoint.addWaypoint("MabladDum", Region.Darkland, LOTRFaction.UNALIGNED, 2824, 4470);
    	NaradDum = LOTREWaypoint.addWaypoint("NaradDum", Region.Darkland, LOTRFaction.UNALIGNED, 2713, 4815); //tur-betark
    	Aldarion = LOTREWaypoint.addWaypoint("Aldarion", Region.Darkland, LOTRFaction.UNALIGNED, 1485, 4477);
    	Taurethrim = LOTREWaypoint.addWaypoint("Taurethrim", Region.Darkland, LOTRFaction.UNALIGNED, 1987, 4026);
    }

    public static class Region {
        public static LOTRWaypoint.Region Darkland;

        public static void init() {
        	Darkland = LOTREWaypoint.addRegion("Darkland");
        }
    }
    
    private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, int x, int z) {
        return LOTREWaypoint.addWaypoint(name, region, faction, x, z, false);
    }

    private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, int x, int z, boolean hidden) {
        Class[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Integer.TYPE, Integer.TYPE, Boolean.TYPE};
        Object[] args = new Object[]{region, faction, x, z, hidden};
        return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
    }

    private static LOTRWaypoint.Region addRegion(String name) {
        Class[] classArr = new Class[]{};
        Object[] args = new Object[]{};
        return EnumHelper.addEnum(LOTRWaypoint.Region.class, name, classArr, args);
    }

}

