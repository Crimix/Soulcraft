package com.black_dog20.sc.client.gui;

import java.util.ArrayList;
import java.util.List;

import com.black_dog20.sc.nbt.Location;
import com.black_dog20.sc.utility.LocationHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.fml.client.GuiScrollingList;

public class GuiLocationList extends GuiScrollingList{

	private GuiScreen parent;

	private List<GuiLocation> locationList = new ArrayList<GuiLocation>();
	
	public GuiLocationList(Minecraft client, int width, int height, int top, int bottom, int left, int entryHeight,
			int screenWidth, int screenHeight, GuiScreen parent) {
		super(client, width, height, top, bottom, left, entryHeight, screenWidth, screenHeight);
		this.parent = parent;
		List<Location> locations = LocationHelper.GetLocationNames(((GuiTeleportBook) parent).player);
		int index = 0;
		this.locationList.add(new GuiLocation(-5, "")); //Because else the add button does not work
		for(Location s : locations)
			this.locationList.add(new GuiLocation(index++, s));
	}

	@Override
	protected int getSize() {
		return locationList.size();
	}

	@Override
	protected void elementClicked(int index, boolean doubleClick) {	
		GuiLocation entry = locationList.get(index);
		entry.teleport();
	}

	@Override
	protected boolean isSelected(int index) {
		return false;
	}

	@Override
	protected void drawBackground() { }
	
	@Override
	protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {
		GuiLocation entry = locationList.get(slotIdx);
		if(entry.getButton().id !=-5){
			entry.getButton().visible = false;
			entry.getButton().xPosition = entryRight-200;
			entry.getButton().yPosition = slotTop;
			entry.getButton().visible = (this.top < entry.getButton().yPosition && entry.getButton().yPosition + 20 < this.bottom);
			entry.getButton().enabled = entry.getButton().visible;
		}
		else{
			entry.getButton().enabled = false;
			entry.getButton().visible = false;
		}
	}
	
	public List<GuiLocation> getList(){
		return locationList;
	}
}
