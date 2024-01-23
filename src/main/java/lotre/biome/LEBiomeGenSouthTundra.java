package lotre.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.common.LOTRMod;
import lotr.common.entity.animal.LOTREntityBear;
import lotr.common.entity.animal.LOTREntityDeer;
import lotr.common.entity.animal.LOTREntityElk;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.feature.LOTRWorldGenBoulder;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.structure2.LOTRWorldGenRuinedHouse;
import lotr.common.world.structure2.LOTRWorldGenSmallStoneRuin;
import lotre.content.LEWaypoints;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import java.awt.*;
import java.util.Random;

public class LEBiomeGenSouthTundra extends LOTRBiome {
	private static final NoiseGeneratorPerlin NOISE_DIRT = new NoiseGeneratorPerlin(new Random(47684796930956L), 1);
	private static final NoiseGeneratorPerlin NOISE_STONE = new NoiseGeneratorPerlin(new Random(8894086030764L), 1);
	private static final NoiseGeneratorPerlin NOISE_SNOW = new NoiseGeneratorPerlin(new Random(2490309256000602L), 1);
	private final WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LEBiomeGenSouthTundra(int i, boolean major) {
		super(i, major);
		setEnableSnow();
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 10, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 10, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityElk.class, 10, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 10, 1, 4));
		spawnableLOTRAmbientList.clear();
		npcSpawnList.clear();
		variantChance = 0.2f;
		addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		addBiomeVariant(LOTRBiomeVariant.STEPPE);
		addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		addBiomeVariant(LOTRBiomeVariant.HILLS);
		addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		addBiomeVariant(LOTRBiomeVariant.DEADFOREST_SPRUCE);
		addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK_SPRUCE);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 4;
		decorator.doubleGrassPerChunk = 1;
		decorator.generateOrcDungeon = true;
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 100);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 100);
		decorator.addTree(LOTRTreeType.PINE, 100);
		decorator.addTree(LOTRTreeType.FIR, 100);
		decorator.addTree(LOTRTreeType.MAPLE, 10);
		decorator.addTree(LOTRTreeType.BEECH, 10);
		registerTaigaFlowers();
		decorator.addRandomStructure(new LOTRWorldGenRuinedHouse(false), 1500);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
	}

	public static boolean isTundraSnowy(int i, int k) {
		double d1 = NOISE_SNOW.func_151601_a(i * 0.002, k * 0.002);
		double d2 = NOISE_SNOW.func_151601_a(i * 0.05, k * 0.05);
		double d3 = NOISE_SNOW.func_151601_a(i * 0.3, k * 0.3);
		return d1 + d2 * 0.3 + d3 * 0.3 > 0.8;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(2) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int k1 = k + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1);
			int bushes = 4 + random.nextInt(20);
			for (int l = 0; l < bushes; ++l) {
				int i2 = i1 + MathHelper.getRandomIntegerInRange(random, -4, 4);
				int k2 = k1 + MathHelper.getRandomIntegerInRange(random, -4, 4);
				int j2 = j1 + MathHelper.getRandomIntegerInRange(random, -1, 1);
				Block below = world.getBlock(i2, j2 - 1, k2);
				Block block = world.getBlock(i2, j2, k2);
				if (!below.canSustainPlant(world, i2, j2 - 1, k2, ForgeDirection.UP, (IPlantable) Blocks.sapling) || block.getMaterial().isLiquid() || !block.isReplaceable(world, i2, j2, k2)) {
					continue;
				}
				Block leafBlock = Blocks.leaves;
				int leafMeta = 1;
				if (random.nextInt(3) == 0) {
					leafBlock = LOTRMod.leaves3;
					leafMeta = 0;
				} else if (random.nextInt(3) == 0) {
					leafBlock = LOTRMod.leaves2;
					leafMeta = 1;
				}
				world.setBlock(i2, j2, k2, leafBlock, leafMeta | 4, 2);
			}
		}
		if (random.nextInt(40) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		Block topBlockPre = topBlock;
		int topBlockMetaPre = topBlockMeta;
		Block fillerBlockPre = fillerBlock;
		int fillerBlockMetaPre = fillerBlockMeta;
		double d1 = NOISE_DIRT.func_151601_a(i * 0.07, k * 0.07);
		double d2 = NOISE_DIRT.func_151601_a(i * 0.3, k * 0.3);
		double d3 = NOISE_STONE.func_151601_a(i * 0.07, k * 0.07);
		if (d3 + NOISE_STONE.func_151601_a(i * 0.3, k * 0.3) > 1.2) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.8) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlockPre;
		topBlockMeta = topBlockMetaPre;
		fillerBlock = fillerBlockPre;
		fillerBlockMeta = fillerBlockMetaPre;
	}

	@SideOnly(Side.CLIENT)
	@Override
	@SuppressWarnings("NumericCastThatLosesPrecision")
	public int getBiomeGrassColor(int i, int j, int k) {
		int color1 = 10708034;
		int color2 = 13747522;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.002, k * 0.002);
		double d2 = biomeTerrainNoise.func_151601_a(i * 0.04, k * 0.04);
		float noise = (float) MathHelper.clamp_double(d1 + d2 * 0.4, -2.0, 2.0);
		noise += 2.0f;
		noise /= 4.0f;
		float[] rgb1 = new Color(color1).getColorComponents(null);
		float[] rgb2 = new Color(color2).getColorComponents(null);
		float[] rgbNoise = new float[rgb1.length];
		for (int l = 0; l < rgbNoise.length; ++l) {
			rgbNoise[l] = rgb1[l] + (rgb2[l] - rgb1[l]) * noise;
		}
		return new Color(rgbNoise[0], rgbNoise[1], rgbNoise[2]).getRGB();
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FORODWAITH.getSubregion("tundra");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LEWaypoints.Region.darkLand;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.02f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.04f;
	}
}