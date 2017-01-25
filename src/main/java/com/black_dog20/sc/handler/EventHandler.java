package com.black_dog20.sc.handler;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;


import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.black_dog20.sc.block.BlockSoulBarrier;
import com.black_dog20.sc.block.BlockSoulBarrierFloor;
import com.black_dog20.sc.init.ModItems;
import com.black_dog20.sc.item.ItemTeleport;
import com.black_dog20.sc.reference.NBTTags;


public class EventHandler {
	
	static final DecimalFormat df = new DecimalFormat("#0.00");

	@SubscribeEvent
	public void Tool(ItemTooltipEvent event) {
		ItemStack item = event.getItemStack();
		List<String> list = event.getToolTip();
		if (item.hasTagCompound()) {
			NBTTagCompound nbtTagCompound = item.getTagCompound();
			if (nbtTagCompound.hasKey(NBTTags.SOULBOUND)) {
				list.add(TextFormatting.LIGHT_PURPLE + I18n.format("sc.tips.soulbound"));
			} else {
				list.remove(I18n.format("sc.tips.soulbound"));
			}

		}
	}
	
	@SubscribeEvent
	public void onBlockBroken(BlockEvent.BreakEvent event)
	{
		event.getState().getBlock();
	    if(event.getState().getBlock() instanceof BlockSoulBarrier  && !event.getPlayer().isCreative() && (event.getPlayer().inventory.getCurrentItem()!=null && !(event.getPlayer().inventory.getCurrentItem().getItem() == ModItems.soulManipulator)))
	    {
	        event.setCanceled(true);
	    }
	    else if(event.getState().getBlock() instanceof BlockSoulBarrierFloor && !event.getPlayer().isCreative() &&(event.getPlayer().inventory.getCurrentItem()!=null && !(event.getPlayer().inventory.getCurrentItem().getItem() == ModItems.soulManipulator)))
	    {
	        event.setCanceled(true);
	    }
	}
}