package com.black_dog20.sc.handler;

import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerEventHandler {

	NBTTagCompound nbt;
	boolean hasChanged;
	boolean downIsPressed = false;
	boolean upIsPressed = false;
	static final DecimalFormat df = new DecimalFormat("#0.00");
	

	//	@SubscribeEvent
	//	public void onEntityDeath(PlayerDropsEvent event) {
	//		EntityPlayer player = event.entityPlayer;
	//		ArrayList<EntityItem> list = event.drops;
	//		NBTTagList nbttaglist = new NBTTagList();
	//		ListIterator<EntityItem> litr = list.listIterator();
	//		nbt = NBTHelper.getPlayerNBT(player);
	//		int i = 0;
	//		while (litr.hasNext()) {
	//
	//			EntityItem item = litr.next();
	//			ItemStack itemstack = item.getEntityItem();
	//
	//			if (item != null) {
	//				if (itemstack.hasTagCompound()) {
	//					NBTTagCompound itemT = itemstack.getTagCompound();
	//					if (itemT.hasKey(NBTTags.SOULBOUND) || itemT.hasKey(NBTTags.SOULBOUND_P)) {
	//						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	//						nbttagcompound1.setByte("Slot", (byte) i);
	//						itemstack.writeToNBT(nbttagcompound1);
	//						nbttaglist.appendTag(nbttagcompound1);
	//						litr.remove();
	//						i++;
	//					}
	//				}
	//			}
	//		}
	//		nbt.setTag("SoulboundItems", nbttaglist);
	//
	//	}

	//	@SubscribeEvent
	//	public void Interact(PlayerInteractEvent event) {
	//		if (event.entityPlayer.ridingEntity instanceof IEntityVehicle) {
	//			event.setCanceled(true);
	//		}
	//	}



	//	@SubscribeEvent
	//	public void onPlayerRespawn(PlayerRespawnEvent event) {
	//		EntityPlayer player = event.player;
	//		nbt = NBTHelper.getPlayerNBT(player);
	//		NBTTagList nbttaglist = nbt.getTagList("SoulboundItems", Constants.NBT.TAG_COMPOUND);
	//		for (int i = 0; i <= nbttaglist.tagCount(); i++) {
	//			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	//			byte b0 = nbttagcompound1.getByte("Slot");
	//			ItemStack item = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	//			if (item != null && item.getItem() instanceof ItemArmor) {
	//				ItemArmor armor = (ItemArmor) item.getItem();
	//				if (player.inventory.armorInventory[InventoryHelper.getArmorPosition(armor)] == null) {
	//					player.inventory.armorInventory[InventoryHelper.getArmorPosition(armor)] = item;
	//				} else {
	//					player.inventory.addItemStackToInventory(item);
	//				}
	//
	//			} else {
	//				player.inventory.addItemStackToInventory(item);
	//			}
	//		}
	//		nbt.removeTag("SoulboundItems");
	//	}

	//	@SubscribeEvent
	//	public void onPlayerLoginEvent(PlayerLoggedInEvent event) {
	//		if (!event.player.worldObj.isRemote) {
	//			if (!MinecraftServer.getServer().isDedicatedServer()) {
	//				ConfigurationHandler.loadConfiguration();
	//				
	//			}
	//			PacketHandler.network.sendTo(new MessageConfigSync(), (EntityPlayerMP) event.player);
	//
	//		}
	//
	//	}

}