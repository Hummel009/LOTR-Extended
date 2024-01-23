package lotre.biome;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityIronHillsMerchant;
import lotr.common.entity.npc.LOTREntityScrapTrader;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import lotre.content.LEBlocks;
import lotre.content.LEWaypoints;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class LEBiomeGenYellowMountains extends LOTRBiome {
	public LEBiomeGenYellowMountains(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
		addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
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
			if (block == topBlock || block == fillerBlock) {
				if (j >= stoneHeight) {
					blocks[index] = LEBlocks.rock;
					meta[index] = 0;
				} else {
					blocks[index] = Blocks.sand;
					meta[index] = 1;
				}
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DWARVEN.getSubregion("redMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LEWaypoints.Region.darkLand;
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