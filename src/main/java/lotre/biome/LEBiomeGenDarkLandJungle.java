package lotre.biome;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenFarHarad;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.feature.LOTRWorldGenObsidianGravel;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRBiomeSpawnList;
import lotr.common.world.spawning.LOTRSpawnList;
import lotre.content.LEWaypoints;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class LEBiomeGenDarkLandJungle extends LOTRBiomeGenFarHarad {
	private final WorldGenerator obsidianGen = new LOTRWorldGenObsidianGravel();

	public LEBiomeGenDarkLandJungle(int i, boolean major) {
		super(i, major);
		if (isMuddy()) {
			topBlock = LOTRMod.mudGrass;
			fillerBlock = LOTRMod.mud;
		}
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityFlamingo.class, 10, 4, 4));
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 15, 4, 4));
		if (isMuddy()) {
			spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityMidges.class, 10, 4, 4));
		}
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LOTREntityJungleScorpion.class, 30, 4, 4));
		npcSpawnList.clear();
		addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		addBiomeVariant(LOTRBiomeVariant.HILLS);
		addBiomeVariant(LOTRBiomeVariant.MOUNTAIN);
		addBiomeVariant(LOTRBiomeVariant.JUNGLE_DENSE);
		if (isMuddy()) {
			decorator.addSoil(new WorldGenMinable(LOTRMod.mud, 32), 80.0f, 0, 256);
			decorator.addSoil(new WorldGenMinable(LOTRMod.mud, 32), 80.0f, 0, 64);
		}
		decorator.addOre(new WorldGenMinable(Blocks.gold_ore, 4), 3.0f, 0, 48);
		decorator.addGem(new WorldGenMinable(LOTRMod.oreGem, 4, 8, Blocks.stone), 3.0f, 0, 48);
		decorator.treesPerChunk = 40;
		decorator.vinesPerChunk = 50;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 4;
		decorator.grassPerChunk = 15;
		decorator.doubleGrassPerChunk = 10;
		decorator.enableFern = true;
		decorator.canePerChunk = 5;
		decorator.cornPerChunk = 10;
		decorator.melonPerChunk = 0.2f;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.JUNGLE, 1000);
		decorator.addTree(LOTRTreeType.JUNGLE_LARGE, 500);
		decorator.addTree(LOTRTreeType.MAHOGANY, 500);
		decorator.addTree(LOTRTreeType.JUNGLE_SHRUB, 1000);
		decorator.addTree(LOTRTreeType.MANGO, 20);
		decorator.addTree(LOTRTreeType.BANANA, 50);
		registerJungleFlowers();
		biomeColors.setGrass(10607421);
		biomeColors.setFoliage(8376636);
		biomeColors.setSky(11977908);
		biomeColors.setFog(11254938);
		biomeColors.setWater(4104311);
		LOTRBiomeSpawnList.SpawnListContainer[] arrspawnListContainer = new LOTRBiomeSpawnList.SpawnListContainer[2];
		arrspawnListContainer[0] = LOTRBiomeSpawnList.entry(LOTRSpawnList.ENTS, 10);
		arrspawnListContainer[1] = LOTRBiomeSpawnList.entry(LOTRSpawnList.HUORNS, 20);
		npcSpawnList.newFactionList(100).add(arrspawnListContainer);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int j1;
		super.decorate(world, random, i, k);
		WorldGenVines vines = new WorldGenVines();
		for (int l = 0; l < 10; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			j1 = 24;
			int k1 = k + random.nextInt(16) + 8;
			vines.generate(world, random, i1, j1, k1);
		}
		int obsidianGravelRarity = 20;
		if (random.nextInt(obsidianGravelRarity) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int k1 = k + random.nextInt(16) + 8;
			j1 = world.getTopSolidOrLiquidBlock(i1, k1);
			obsidianGen.generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FAR_HARAD_JUNGLE.getSubregion("jungle");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LEWaypoints.Region.darkLand;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		if (random.nextInt(4) == 0) {
			return new LOTRBiome.GrassBlockAndMeta(LOTRMod.tallGrass, 5);
		}
		return super.getRandomGrass(random);
	}

	public boolean hasJungleLakes() {
		return false;
	}

	private boolean isMuddy() {
		return true;
	}

	@Override
	protected double modifyStoneNoiseForFiller(double stoneNoise) {
		double stoneNoise1 = stoneNoise;
		if (isMuddy()) {
			stoneNoise1 += 40.0;
		}
		return stoneNoise1;
	}
}
