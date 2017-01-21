package com.black_dog20.sc.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

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
		this.locationList.add(new GuiLocation(0, "Hej1"));
		this.locationList.add(new GuiLocation(1, "Hej2"));
		this.locationList.add(new GuiLocation(2, "Hej3"));
		this.locationList.add(new GuiLocation(3, "Hej4"));
		this.locationList.add(new GuiLocation(4, "Hej5"));
		this.locationList.add(new GuiLocation(5, "Hej6"));
		this.locationList.add(new GuiLocation(6, "Hej7"));
		this.locationList.add(new GuiLocation(7, "Hej8"));
		this.locationList.add(new GuiLocation(8, "Hej9"));
		this.locationList.add(new GuiLocation(9, "Hej10"));
	}

	@Override
	protected int getSize() {
		return locationList.size();
	}

	@Override
	protected void elementClicked(int index, boolean doubleClick) {	}

	@Override
	protected boolean isSelected(int index) {
		return false;
	}

	@Override
	protected void drawBackground() { }
	
	@Override
	protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {
		GuiLocation entry = locationList.get(slotIdx);
		entry.getButton().visible = false;
		entry.getButton().xPosition = entryRight-200;
		entry.getButton().yPosition = slotTop;
		entry.getButton().visible = (this.top < entry.getButton().yPosition && entry.getButton().yPosition + 20 < this.bottom);
		entry.getButton().enabled = entry.getButton().visible;
	}
	
	public List<GuiLocation> getList(){
		return locationList;
	}
}
