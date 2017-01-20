package com.black_dog20.sc.handler;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;


import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.black_dog20.sc.network.PacketHandler;


public class EventHandler {
	
	@SubscribeEvent
	public void Tool(ItemTooltipEvent event) {
		ItemStack item = event.getItemStack();
		List list = event.getToolTip();
		if (item.hasTagCompound()) {
			NBTTagCompound nbtTagCompound = item.getTagCompound();
			if (nbtTagCompound.hasKey("Owner")) {
				list.add(TextFormatting.LIGHT_PURPLE + I18n.format("Owner") + ": " + nbtTagCompound.getString("Owner"));
			}
		}
	}
}