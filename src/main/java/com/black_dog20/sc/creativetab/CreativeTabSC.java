package com.black_dog20.sc.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.black_dog20.sc.init.ModItems;
import com.black_dog20.sc.reference.Reference;

public class CreativeTabSC{

	public static final CreativeTabs SC_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {

		@Override
		public Item getTabIconItem() {
			return ModItems.soulcystal;
		}

		@Override
		public String getTranslatedTabLabel() {
			return Reference.MOD_NAME;
		}
	};

}
