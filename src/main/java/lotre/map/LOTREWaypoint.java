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
		Class<?>[] classArr = {};
		Object[] args = {};
		return EnumHelper.addEnum(LOTRWaypoint.Region.class, name, classArr, args);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z) {
		return addWaypoint(name, region, faction, x, z, false);
	}

	private static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class<?>[] classArr = {LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
		Object[] args = {region, faction, x, z, hidden};
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

	public static void preInit() {
		Region.preInit();
		Barazimabul = addWaypoint("Barazimabul", Region.darkLand, LOTRFaction.UNALIGNED, 2963.0, 4044.0);
		MabladDum = addWaypoint("MabladDum", Region.darkLand, LOTRFaction.UNALIGNED, 2824.0, 4470.0);
		NaradDum = addWaypoint("NaradDum", Region.darkLand, LOTRFaction.UNALIGNED, 2713.0, 4815.0);
		Aldarion = addWaypoint("Aldarion", Region.darkLand, LOTRFaction.UNALIGNED, 1485.0, 4477.0);
		Taurethrim = addWaypoint("Taurethrim", Region.darkLand, LOTRFaction.UNALIGNED, 1987.0, 4026.0);
	}

	public static class Region {
		public static LOTRWaypoint.Region darkLand;

		public static void preInit() {
			darkLand = addRegion("Darkland");
		}
	}
}