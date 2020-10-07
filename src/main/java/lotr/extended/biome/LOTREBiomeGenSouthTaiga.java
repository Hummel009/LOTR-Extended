package lotr.extended.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.extended.map.LOTREWaypoint;

public class LOTREBiomeGenSouthTaiga
extends LOTREBiomeGenSouthTundra {
    public LOTREBiomeGenSouthTaiga(int i, boolean major) {
        super(i, major);
        clearBiomeVariants();
        variantChance = 0.75f;
        addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
        this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_SPRUCE);
        this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE);
        decorator.treesPerChunk = 2;
        decorator.flowersPerChunk = 2;
        decorator.grassPerChunk = 8;
        decorator.doubleGrassPerChunk = 2;
        decorator.clearTrees();
        decorator.addTree(LOTRTreeType.SPRUCE, 200);
        decorator.addTree(LOTRTreeType.SPRUCE_THIN, 100);
        decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 50);
        decorator.addTree(LOTRTreeType.FIR, 200);
        decorator.addTree(LOTRTreeType.PINE, 200);
        registerTaigaFlowers();
    }

    @Override
    public LOTRWaypoint.Region getBiomeWaypoints() {
        return LOTREWaypoint.Region.Darkland;
    }

    @Override
    public float getChanceToSpawnAnimals() {
        return 0.5f;
    }
}

