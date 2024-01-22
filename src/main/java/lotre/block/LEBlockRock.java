package lotre.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LEBlockRock extends Block {
	public LEBlockRock() {
		super(Material.rock);
		setHardness(1.5f);
		setResistance(10.0f);
		setStepSound(Block.soundTypeStone);
	}
}