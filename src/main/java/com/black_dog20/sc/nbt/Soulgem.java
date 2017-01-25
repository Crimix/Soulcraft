package com.black_dog20.sc.nbt;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public class Soulgem implements INBTSerializable<NBTTagCompound>{
	
	private String type;
	private int fullness;
	
	public Soulgem(String type , int fullness){
		this.type = type;
		this.fullness = fullness;
	}
	
	public Soulgem(){
		
	}
	
	public void AddSoul(String type, int amount){
		if(this.type == null){
			this.type = type;
		}
		else if(!type.equals(this.type)){
			this.type = "Mixed";
		}
		fullness+=amount;
		if(fullness >100)
			fullness = 100;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("type", type);
		nbt.setInteger("fullness", fullness);
		return nbt;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.type = nbt.getString("type");
		this.fullness = nbt.getInteger("fullness");
	}
	
	public static Soulgem GetLocationFromNBT(NBTTagCompound nbt){
		Soulgem l = new Soulgem();
		l.deserializeNBT(nbt);
		return l;
	}

}
