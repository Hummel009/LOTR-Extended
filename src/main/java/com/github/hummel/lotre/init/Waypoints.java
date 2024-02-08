package com.github.hummel.lotre.init;

import com.github.hummel.lotre.api.API;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;

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
		Regions.preInit();
		barazimabul = API.addWaypoint("BARAZIMABUL", Regions.darkLand, LOTRFaction.UNALIGNED, 2963.0, 4044.0);
		mabladDum = API.addWaypoint("MABLAD_DUM", Regions.darkLand, LOTRFaction.UNALIGNED, 2824.0, 4470.0);
		naradDum = API.addWaypoint("NARAD_DUM", Regions.darkLand, LOTRFaction.UNALIGNED, 2713.0, 4815.0);
		aldarion = API.addWaypoint("ALDARION", Regions.darkLand, LOTRFaction.UNALIGNED, 1485.0, 4477.0);
		taurethrim = API.addWaypoint("TAURETHRIM", Regions.darkLand, LOTRFaction.UNALIGNED, 1987.0, 4026.0);
	}

	public static class Regions {
		public static LOTRWaypoint.Region darkLand;

		private Regions() {
		}

		public static void preInit() {
			darkLand = API.addWaypointRegion("Darkland");
		}
	}
}