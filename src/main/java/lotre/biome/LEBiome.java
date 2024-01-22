package lotre.biome;

import lotr.common.world.biome.*;

@SuppressWarnings({"WeakerAccess", "PublicField"})
public class LEBiome {
	public static LOTRBiome darkLandYellowMountains;
	public static LOTRBiome darkLandYellowMountainsCold;
	public static LOTRBiome darkLandTaiga;
	public static LOTRBiome darkLandTundra;
	public static LOTRBiome darkLandFrost;
	public static LOTRBiome darkLandNormal;
	public static LOTRBiome darkLandBushland;
	public static LOTRBiome darkLandBushlandHills;
	public static LOTRBiome darkLandJungle;
	public static LOTRBiome darkLandJungleEdge;
	public static LOTRBiome darkLandCloudForest;
	public static LOTRBiome darkLandSwamp;
	public static LOTRBiome darkLandSavannah;
	public static LOTRBiome darkLandKanukaForest;
	public static LOTRBiome sunLandMountains;
	public static LOTRBiome sunLandDesert;

	private static int id = 255;

	private LEBiome() {
	}

	public static void onInit() {
		darkLandYellowMountains = new LEBiomeGenYellowMountains(id--, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(2.0f, 2.0f).setColor(0xEAC643).setBiomeName("yellowMountains");
		darkLandTaiga = new LEBiomeGenSouthTaiga(id--, true).setTemperatureRainfall(0.4f, 0.4f).setMinMaxHeight(0.1f, 0.1f).setColor(0xA5C9AA).setBiomeName("southTaiga");
		darkLandTundra = new LEBiomeGenSouthTundra(id--, true).setTemperatureRainfall(0.4f, 0.4f).setMinMaxHeight(0.1f, 0.1f).setColor(0xA5C681).setBiomeName("southTundra");
		darkLandFrost = new LOTRBiomeGenForodwaith(id--, true).setTemperatureRainfall(0.0f, 0.0f).setMinMaxHeight(0.1f, 0.1f).setColor(0xC9DAE0).setBiomeName("southForod");
		darkLandNormal = new LOTRBiomeGenRhun(id--, true).setTemperatureRainfall(0.4f, 0.4f).setMinMaxHeight(0.1f, 0.1f).setColor(0x9FB251).setBiomeName("southNormal");
		darkLandBushland = new LOTRBiomeGenFarHaradBushland(id--, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.1f).setColor(0x8E863A).setBiomeName("southBush");
		darkLandBushlandHills = new LOTRBiomeGenFarHaradBushland(id--, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.3f, 0.3f).setColor(0x6B652B).setBiomeName("southBushHill");
		darkLandJungle = new LEBiomeGenDarkLandJungle(id--, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x446820).setBiomeName("southJungle");
		darkLandCloudForest = new LOTRBiomeGenFarHaradCloudForest(id--, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x2B6A3C).setBiomeName("southCloud");
		darkLandJungleEdge = new LEBiomeGenDarkLandJungleEdge(id--, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x6C822C).setBiomeName("southJungleEdge");
		darkLandSwamp = new LOTRBiomeGenFarHaradMangrove(id--, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(-0.05f, 0.05f).setColor(0x808E5E).setBiomeName("southMangrove");
		darkLandSavannah = new LEBiomeGenDarkLandSavannah(id--, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x89933C).setBiomeName("southSavannah");
		sunLandMountains = new LOTRBiomeGenWindMountains(id--, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(2.0f, 2.0f).setColor(0xE4E066).setBiomeName("sunMountains");
		sunLandDesert = new LOTRBiomeGenLastDesert(id--, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(0.1f, 0.1f).setColor(0xD1B966).setBiomeName("sunDesert");
		darkLandYellowMountainsCold = new LEBiomeGenYellowMountains(id--, true).setTemperatureRainfall(0.0f, 0.0f).setMinMaxHeight(2.0f, 2.0f).setColor(0xE8CB66).setBiomeName("yellowMountains");
		darkLandJungle = new LOTRBiomeGenKanuka(id--, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x5E911D).setBiomeName("southKanuka");
	}
}
