package com.black_dog20.sc.client.gui;

import com.black_dog20.sc.nbt.Location;

import net.minecraft.client.gui.GuiButton;

public class GuiLocation {
	int index;
	private GuiButton button;
	private Location location;

	public GuiLocation(int index, String text) {
		this.index = index;
		this.button = new GuiButton(index, 0, 0, text);
		this.button.visible = false;
		
	}
	public GuiLocation(int index, Location l) {
		this.index = index;
		this.location = l;
		this.button = new GuiButton(index, 0, 0, l.name);
		this.button.visible = false;
		
	}
	
	public void teleport(){
		if(location != null)
			location.Teleport();
	}

	public GuiButton getButton() {
		return button;
	}

}
