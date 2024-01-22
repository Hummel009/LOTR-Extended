package lotre.content;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import lotre.util.LEAPI;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class LEWaypoints {
	public static LOTRWaypoint barazimabul;
	public static LOTRWaypoint mabladDum;
	public static LOTRWaypoint naradDum;
	public static LOTRWaypoint aldarion;
	public static LOTRWaypoint taurethrim;

	private LEWaypoints() {
	}

	public static void preInit() {
		Region.preInit();
		barazimabul = LEAPI.addWaypoint("BARAZIMABUL", Region.darkLand, LOTRFaction.UNALIGNED, 2963.0, 4044.0);
		mabladDum = LEAPI.addWaypoint("MABLAD_DUM", Region.darkLand, LOTRFaction.UNALIGNED, 2824.0, 4470.0);
		naradDum = LEAPI.addWaypoint("NARAD_DUM", Region.darkLand, LOTRFaction.UNALIGNED, 2713.0, 4815.0);
		aldarion = LEAPI.addWaypoint("ALDARION", Region.darkLand, LOTRFaction.UNALIGNED, 1485.0, 4477.0);
		taurethrim = LEAPI.addWaypoint("TAURETHRIM", Region.darkLand, LOTRFaction.UNALIGNED, 1987.0, 4026.0);
	}

	public static class Region {
		public static LOTRWaypoint.Region darkLand;

		private Region() {
		}

		public static void preInit() {
			darkLand = LEAPI.addRegion("Darkland");
		}
	}
}