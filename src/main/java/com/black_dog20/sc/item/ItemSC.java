package com.black_dog20.sc.item;

import java.util.List;




import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.black_dog20.sc.creativetab.CreativeTabSC;
import com.black_dog20.sc.reference.Reference;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSC extends Item {

	public ItemSC(String unLocalName) {

		this();
		this.setRegistryName(unLocalName);
		this.setUnlocalizedName(unLocalName);
		GameRegistry.register(this);
	}

	public ItemSC() {

		super();
		this.setCreativeTab(CreativeTabSC.SC_TAB);

	}
	
	
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

//	@Override
//	public String getUnlocalizedName() {
//		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
//	}
//
//	@Override
//	public String getUnlocalizedName(ItemStack itemStack) {
//		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
//	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool, String text) {
		super.addInformation(item, player, list, bool);
		list.add(text);
	}

}
