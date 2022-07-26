package lotre.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.*;
import lotr.common.world.biome.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import lotre.LOTRExtended;
import lotre.map.LOTREWaypoint;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTREBiomeGenYellowMountains extends LOTRBiome {
	public LOTREBiomeGenYellowMountains(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
		decorator.biomeOreFactor = 2.0f;
		decorator.biomeGemFactor = 1.5f;
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 6, 60, Blocks.stone), 12.0f, 0, 96);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
		decorator.treesPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.LARCH, 300);
		decorator.addTree(LOTRTreeType.MAPLE, 300);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 50);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerMountainsFlowers();
		addFlower(LOTRMod.dwarfHerb, 0, 1);
		biomeColors.setSky(0xfff075);
		registerTravellingTrader(LOTREntityIronHillsMerchant.class);
		registerTravellingTrader(LOTREntityScrapTrader.class);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int stoneHeight = 110 - rockDepth;
		int sandHeight = stoneHeight - 6;
		for (int j = ySize - 1; j >= sandHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (block != topBlock && block != fillerBlock) {
				continue;
			}
			if (j >= stoneHeight) {
				blocks[index] = LOTRExtended.rock;
				meta[index] = 0;
				continue;
			}
			blocks[index] = Blocks.sand;
			meta[index] = 1;
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DWARVEN.getSubregion("redMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTREWaypoint.Region.Darkland;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.2f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}
