package lotr.extended.biome;

import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenFarHaradBushland;
import lotr.common.world.biome.LOTRBiomeGenFarHaradCloudForest;
import lotr.common.world.biome.LOTRBiomeGenFarHaradMangrove;
import lotr.common.world.biome.LOTRBiomeGenForodwaith;
import lotr.common.world.biome.LOTRBiomeGenKanuka;
import lotr.common.world.biome.LOTRBiomeGenLastDesert;
import lotr.common.world.biome.LOTRBiomeGenRhun;
import lotr.common.world.biome.LOTRBiomeGenWindMountains;

public class LOTREBiome {
    public static LOTRBiome dl_yellow;
    public static LOTRBiome dl_yellow_cold;
    public static LOTRBiome dl_taiga;
    public static LOTRBiome dl_tundra;
    public static LOTRBiome dl_forod;
    public static LOTRBiome dl_normal;
    public static LOTRBiome dl_bush;
    public static LOTRBiome dl_bush_hill;
    public static LOTRBiome dl_jungle;
    public static LOTRBiome dl_jungle_edge;
    public static LOTRBiome dl_cloud;
    public static LOTRBiome dl_swamp;
    public static LOTRBiome dl_savann;
    public static LOTRBiome dl_kanuka;
    public static LOTRBiome sl_mountain;
    public static LOTRBiome sl_desert;
    
    public static void onInit() {
    	dl_yellow = new LOTREBiomeGenYellowMountains(255, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(2f, 2f).setColor(0xEAC643).setBiomeName("yellowMountains");
    	dl_taiga = new LOTREBiomeGenSouthTaiga(254, true).setTemperatureRainfall(0.4f, 0.4f).setMinMaxHeight(0.1f, 0.1f).setColor(0xA5C9AA).setBiomeName("southTaiga");
    	dl_tundra = new LOTREBiomeGenSouthTundra(253, true).setTemperatureRainfall(0.4f, 0.4f).setMinMaxHeight(0.1f, 0.1f).setColor(0xA5C681).setBiomeName("southTundra");
    	dl_forod = new LOTRBiomeGenForodwaith(252, true).setTemperatureRainfall(0.0f, 0.0f).setMinMaxHeight(0.1f, 0.1f).setColor(0xC9DAE0).setBiomeName("southForod");
    	dl_normal = new LOTRBiomeGenRhun(251, true).setTemperatureRainfall(0.4f, 0.4f).setMinMaxHeight(0.1f, 0.1f).setColor(0x9FB251).setBiomeName("southNormal");
    	dl_bush = new LOTRBiomeGenFarHaradBushland(250, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.1f).setColor(0x8E863A).setBiomeName("southBush");
    	dl_bush_hill = new LOTRBiomeGenFarHaradBushland(249, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.3f, 0.3f).setColor(0x6B652B).setBiomeName("southBushHill");
    	dl_jungle = new LOTREBiomeGenDarkLandJungle(248, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x446820).setBiomeName("southJungle");
    	dl_cloud = new LOTRBiomeGenFarHaradCloudForest(247, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x2B6A3C).setBiomeName("southCloud");
    	dl_jungle_edge = new LOTREBiomeGenDarkLandJungleEdge(246, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x6C822C).setBiomeName("southJungleEdge");
    	dl_swamp = new LOTRBiomeGenFarHaradMangrove(245, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(-0.05f, 0.05f).setColor(0x808E5E).setBiomeName("southMangrove");
    	dl_savann = new LOTREBiomeGenDarkLandSavannah(244, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x89933C).setBiomeName("southSavannah");
    	sl_mountain = new LOTRBiomeGenWindMountains(243, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(2f, 2f).setColor(0xE4E066).setBiomeName("sunMountains");
    	sl_desert = new LOTRBiomeGenLastDesert(242, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(0.1f, 0.1f).setColor(0xD1B966).setBiomeName("sunDesert");
    	dl_yellow_cold = new LOTREBiomeGenYellowMountains(241, true).setTemperatureRainfall(0.0f, 0.0f).setMinMaxHeight(2f, 2f).setColor(0xE8CB66).setBiomeName("yellowMountains");
    	dl_jungle = new LOTRBiomeGenKanuka(240, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.1f, 0.1f).setColor(0x5E911D).setBiomeName("southKanuka");
    }
}

