package com.black_dog20.sc.handler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.black_dog20.sc.client.settings.Keybindings;
import com.black_dog20.sc.init.ModItems;
import com.black_dog20.sc.network.PacketHandler;
import com.black_dog20.sc.utility.NBTHelper;
import com.jcraft.jorbis.Block;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerEventHandler {

	private double speed = 0;
	private double oldX, oldY;
	private boolean active = false;
	private int ticks = 0;
	NBTTagCompound nbt;
	boolean hasChanged;
	boolean downIsPressed = false;
	boolean upIsPressed = false;
	static final DecimalFormat df = new DecimalFormat("#0.00");
	private BlockPos oldPos;
	private boolean hasOldPos;

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

	
	private void removeLight(EntityPlayer player){
		BlockPos b = new BlockPos(player);
		if(hasOldPos){
			player.worldObj.setLightFor(EnumSkyBlock.BLOCK, oldPos, 0);
			for(int x = -10; x <= 10; x++)
				for(int y = -10; y <= 10; y++)
					for(int z = -10; z <= 10; z++)
						if(x != b.getX() && y != b.getY() && z != b.getZ())
							player.worldObj.checkLightFor(EnumSkyBlock.BLOCK, oldPos.add(x, y, z));
		}
		hasOldPos = false;
	}
	
	private void addLight(EntityPlayer player){
		BlockPos b = new BlockPos(player);
		removeLight(player);
		player.worldObj.setLightFor(EnumSkyBlock.BLOCK, new BlockPos(player), 15);
		for(int x = -10; x <= 10; x++)
			for(int y = -10; y <= 10; y++)
				for(int z = -10; z <= 10; z++)
					if(x != 0 && y != 0 && z != 0)
							player.worldObj.checkLightFor(EnumSkyBlock.BLOCK, b.add(x, y, z));
		oldPos = b;
		hasOldPos = true;
	}


	private int ticksLight = 0;

	/*@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void LightUpAroundPlayer(LivingUpdateEvent event){
		if(event.getEntityLiving() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if(ticksLight%20==0){
//				System.out.println("light");
				ticksLight=0;
				if(player.getHeldItemMainhand()!=null && player.getHeldItemMainhand().getItem() == Item.getItemFromBlock(Blocks.TORCH)){
					addLight(player);
				}
				else if(hasOldPos){
					removeLight(player);
				}
//				else{
//					ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
//					for(Coordinate c : coords){
//						if(c.UUID.equals(player.getUniqueID().toString())){
//							System.out.println("all");
//							removeLight(player, c,true);
//							temp.add(c);
//						}
//					}
//					for(Coordinate c: temp)
//						coords.remove(c);
//				}

			}
			ticksLight++;
		}
	}*/



	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiRender(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.getType() != ElementType.EXPERIENCE) {
			return;
		}
	}


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