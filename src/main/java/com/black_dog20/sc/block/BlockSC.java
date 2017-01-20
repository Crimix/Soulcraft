package com.black_dog20.sc.block;

import com.black_dog20.sc.creativetab.CreativeTabSC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockSC extends Block{

	
	public BlockSC(String unLocalName,Material materialIn) {
		super(materialIn);
		this.setRegistryName(unLocalName);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(CreativeTabSC.SC_TAB);
		GameRegistry.register(this);
	}
}
