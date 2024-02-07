package com.github.hummel.extended.init;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import com.github.hummel.extended.api.API;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class Waypoints {
	public static LOTRWaypoint barazimabul;
	public static LOTRWaypoint mabladDum;
	public static LOTRWaypoint naradDum;
	public static LOTRWaypoint aldarion;
	public static LOTRWaypoint taurethrim;

	private Waypoints() {
	}

	public static void preInit() {
		Region.preInit();
		barazimabul = API.addWaypoint("BARAZIMABUL", Region.darkLand, LOTRFaction.UNALIGNED, 2963.0, 4044.0);
		mabladDum = API.addWaypoint("MABLAD_DUM", Region.darkLand, LOTRFaction.UNALIGNED, 2824.0, 4470.0);
		naradDum = API.addWaypoint("NARAD_DUM", Region.darkLand, LOTRFaction.UNALIGNED, 2713.0, 4815.0);
		aldarion = API.addWaypoint("ALDARION", Region.darkLand, LOTRFaction.UNALIGNED, 1485.0, 4477.0);
		taurethrim = API.addWaypoint("TAURETHRIM", Region.darkLand, LOTRFaction.UNALIGNED, 1987.0, 4026.0);
	}

	public static class Region {
		public static LOTRWaypoint.Region darkLand;

		private Region() {
		}

		public static void preInit() {
			darkLand = API.addWaypointRegion("Darkland");
		}
	}
}