package com.github.hummel.extended.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRock extends Block {
	public BlockRock() {
		super(Material.rock);
		setHardness(1.5f);
		setResistance(10.0f);
		setStepSound(Block.soundTypeStone);
	}
}