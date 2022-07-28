package lotre.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LOTREBlockRock extends Block {
	public LOTREBlockRock() {
		super(Material.rock);
		setHardness(1.5f);
		setResistance(10.0f);
		setStepSound(Block.soundTypeStone);
	}
}