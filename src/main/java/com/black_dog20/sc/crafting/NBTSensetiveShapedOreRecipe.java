package com.black_dog20.sc.crafting;

import java.util.Iterator;
import java.util.List;

import com.black_dog20.sc.reference.NBTTags;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class NBTSensetiveShapedOreRecipe extends ShapedOreRecipe{

	public NBTSensetiveShapedOreRecipe(Block     result, Object... recipe){
		super(result,recipe);
	}

	public NBTSensetiveShapedOreRecipe(Item      result, Object... recipe){
		super(result,recipe);
	}

	public NBTSensetiveShapedOreRecipe(ItemStack result, Object... recipe){
		super(result,recipe);
	}
	
	@Override
	@SuppressWarnings("unchecked")
    protected boolean checkMatch(InventoryCrafting inv, int startX, int startY, boolean mirror)
    {
        for (int x = 0; x < MAX_CRAFT_GRID_WIDTH; x++)
        {
            for (int y = 0; y < MAX_CRAFT_GRID_HEIGHT; y++)
            {
                int subX = x - startX;
                int subY = y - startY;
                Object target = null;

                if (subX >= 0 && subY >= 0 && subX < width && subY < height)
                {
                    if (mirror)
                    {
                        target = input[width - subX - 1 + subY * width];
                    }
                    else
                    {
                        target = input[subX + subY * width];
                    }
                }

                ItemStack slot = inv.getStackInRowAndColumn(x, y);

                if (target instanceof ItemStack)
                {
                    if (!OreDictionary.itemMatches((ItemStack)target, slot, false))
                    {
                        return false;
                    }
                    
                    if(!CheckNBT(slot, (ItemStack)target))
                    	return false;
                    
                }
                else if (target instanceof List)
                {
                    boolean matched = false;

                    Iterator<ItemStack> itr = ((List<ItemStack>)target).iterator();
                    while (itr.hasNext() && !matched)
                    {
                        matched = OreDictionary.itemMatches(itr.next(), slot, false);
                    }

                    if (!matched)
                    {
                        return false;
                    }
                    if(!CheckNBT(slot, (ItemStack)target))
                    	return false;
                }
                else if (target == null && slot != null)
                {
                    return false;
                }
            }
        }

        return true;
    }
	
	private boolean CheckNBT(ItemStack i1, ItemStack i2){
		if(i1.hasTagCompound())
			if(!i2.hasTagCompound()){
				return false;
			}
			else{
				if(i2.getTagCompound().hasKey(NBTTags.NBT_PROPERTISE) && i1.getTagCompound().hasKey(NBTTags.NBT_PROPERTISE)){
					NBTTagCompound nbt1 = i1.getTagCompound().getCompoundTag(NBTTags.NBT_PROPERTISE);
					NBTTagCompound nbt2 = i2.getTagCompound().getCompoundTag(NBTTags.NBT_PROPERTISE);
					return nbt1.equals(nbt2);
				}
			}
		return false;
	}
}
