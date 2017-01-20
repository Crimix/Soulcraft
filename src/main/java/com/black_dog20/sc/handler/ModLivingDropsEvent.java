package com.black_dog20.sc.handler;

import java.util.Random;

import com.black_dog20.sc.init.ModItems;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModLivingDropsEvent {
	NBTTagCompound nbt;
	Random r = new Random();

	// Event for dropping items when a entity dies
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		boolean isPlayerCaused = event.getSource().getEntity() instanceof EntityPlayer; 
		if (isPlayerCaused == true) {

			if (event.getEntityLiving() instanceof EntityCreeper) {
				double rand = Math.random();
				EntityCreeper creeper = (EntityCreeper) event.getEntityLiving();
				if (rand <= 0.40D) {
					//creeper.entityDropItem(new ItemStack(ModItems.DustBlackIron,1), 1);
				}
			}

		}
	}
}