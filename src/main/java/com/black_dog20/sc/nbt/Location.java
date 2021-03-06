package com.black_dog20.sc.nbt;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fml.relauncher.Side;

import com.black_dog20.sc.network.PacketHandler;
import com.black_dog20.sc.network.message.MessagePlayerTeleport;

public class Location implements INBTSerializable<NBTTagCompound> {
	
	private int dim;
	public String name;
	private double x,y,z;
	private float yaw, pitch;
	public Location(String name ,int dim, double x, double y, double z,float yaw, float pitch){
		this.dim = dim;
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public Location(){
	}
	
	public void Teleport(){
		if(Side.CLIENT.isClient()){
			System.err.println("tp");
			Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
			Minecraft.getMinecraft().thePlayer.rotationYaw = yaw;
		}
		PacketHandler.network.sendToServer(new MessagePlayerTeleport(dim, x, y, z, yaw));
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("dim", dim);
		nbt.setString("name", name);
		nbt.setDouble("x", x);
		nbt.setDouble("y", y);
		nbt.setDouble("z", z);
		nbt.setFloat("yaw", yaw);
		nbt.setFloat("pitch", pitch);
		return nbt;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.dim = nbt.getInteger("dim");
		this.name = nbt.getString("name");
		this.x = nbt.getDouble("x");
		this.y = nbt.getDouble("y");
		this.z = nbt.getDouble("z");
		this.yaw = nbt.getFloat("yaw");
		this.pitch = nbt.getFloat("pitch");
	}
	
	public static Location GetLocationFromNBT(NBTTagCompound nbt){
		Location l = new Location();
		l.deserializeNBT(nbt);
		return l;
	}
}