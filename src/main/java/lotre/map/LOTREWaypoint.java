package lotre.map;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraftforge.common.util.EnumHelper;

public class LOTREWaypoint {
	public static LOTRWaypoint Barazimabul;
	public static LOTRWaypoint MabladDum;
	public static LOTRWaypoint NaradDum;
	public static LOTRWaypoint Aldarion;
	public static LOTRWaypoint Taurethrim;

	private static LOTRWaypoint.Region addRegion(String name) {
		Class[] classArr = {};
		Object[] args = {};
		return EnumHelper.addEnum(LOTRWaypoint.Region.class, name, classArr, args);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z) {
		return LOTREWaypoint.addWaypoint(name, region, faction, x, z, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class[] classArr = { LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE };
		Object[] args = { region, faction, x, z, hidden };
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	public static void preInit() {
		Region.preInit();
		Barazimabul = LOTREWaypoint.addWaypoint("Barazimabul", Region.Darkland, LOTRFaction.UNALIGNED, 2963.0, 4044.0);
		MabladDum = LOTREWaypoint.addWaypoint("MabladDum", Region.Darkland, LOTRFaction.UNALIGNED, 2824.0, 4470.0);
		NaradDum = LOTREWaypoint.addWaypoint("NaradDum", Region.Darkland, LOTRFaction.UNALIGNED, 2713.0, 4815.0);
		Aldarion = LOTREWaypoint.addWaypoint("Aldarion", Region.Darkland, LOTRFaction.UNALIGNED, 1485.0, 4477.0);
		Taurethrim = LOTREWaypoint.addWaypoint("Taurethrim", Region.Darkland, LOTRFaction.UNALIGNED, 1987.0, 4026.0);
	}

	public static class Region {
		public static LOTRWaypoint.Region Darkland;

		public static void preInit() {
			Darkland = LOTREWaypoint.addRegion("Darkland");
		}
	}

}
