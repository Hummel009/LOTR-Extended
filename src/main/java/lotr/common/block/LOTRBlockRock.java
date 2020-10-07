package lotr.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class LOTRBlockRock
extends Block {
    @SideOnly(value=Side.CLIENT)
    private IIcon[] rockIcons;
    private String[] rockNames = new String[]{"mordor", "gondor", "rohan", "blue", "red", "chalk", "yellow"};

    public LOTRBlockRock() {
        super(Material.rock);
        setHardness(1.5f);
        setResistance(10.0f);
        setStepSound(Block.soundTypeStone);
    }

    @Override
	public boolean isReplaceableOreGen(World world, int i, int j, int k, Block target) {
        if (target == this) {
            return world.getBlockMetadata(i, j, k) == 0;
        }
        return false;
    }

    @Override
	@SideOnly(value=Side.CLIENT)
    public IIcon getIcon(int i, int j) {
        if (j >= rockNames.length) {
            j = 0;
        }
        return rockIcons[j];
    }

    @Override
	@SideOnly(value=Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
        rockIcons = new IIcon[rockNames.length];
        for (int i = 0; i < rockNames.length; ++i) {
            rockIcons[i] = iconregister.registerIcon(getTextureName() + "_" + rockNames[i]);
        }
    }

    @Override
	public int damageDropped(int i) {
        return i;
    }

    @Override
	@SideOnly(value=Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < rockNames.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
	@SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int i, int j, int k, Random random) {
        if (world.getBlock(i, j, k) == this && world.getBlockMetadata(i, j, k) == 0 && random.nextInt(10) == 0) {
            world.spawnParticle("smoke", i + random.nextFloat(), j + 1.1f, k + random.nextFloat(), 0.0, 0.0, 0.0);
        }
    }
}

