package com.black_dog20.sc.block;

import java.util.Random;

import com.black_dog20.sc.init.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockSoulcystalOre extends BlockSC{

	public BlockSoulcystalOre() {
		super("OreSoulcystal", Material.ROCK);
		this.setHardness(2.0F);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.soulcystal;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if (fortune > 0)
		{
			int j = random.nextInt(fortune + 2) - 1;

			if (j < 0)
			{
				j = 0;
			}

			return quantityDropped(random) * (j + 1);
		}
		else
		{
			return quantityDropped(random);
		}
	}


}
