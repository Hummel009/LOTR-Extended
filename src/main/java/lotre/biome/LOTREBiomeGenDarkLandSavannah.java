package lotre.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTRBiomeSpawnList;
import lotre.map.LOTREWaypoint;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

public class LOTREBiomeGenDarkLandSavannah extends LOTRBiomeGenFarHarad {
	protected LOTRBiomeSpawnList populatedSpawnList = new LOTRBiomeSpawnList(this);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTREBiomeGenDarkLandSavannah(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();

		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SAVANNAH_BAOBAB, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND);
		decorator.addSoil(new WorldGenMinable(LOTRMod.redClay, 32, Blocks.dirt), 40.0f, 0, 80);
		decorator.setTreeCluster(3, 60);
		decorator.clayPerChunk = 4;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 12;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.melonPerChunk = 0.01f;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(32) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(6) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenYams().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FAR_HARAD.getSubregion("savannah");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTREWaypoint.Region.Darkland;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.75f;
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		if (random.nextInt(6) == 0) {
			WorldGenDoublePlant gen = new WorldGenDoublePlant();
			gen.func_150548_a(0);
			return gen;
		}
		return super.getRandomWorldGenForDoubleFlower(random);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
