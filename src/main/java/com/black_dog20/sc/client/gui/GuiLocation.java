package com.black_dog20.sc.client.gui;

import net.minecraft.client.gui.GuiButton;

public class GuiLocation {
	int index;
	private GuiButton button;

	public GuiLocation(int index, String text) {
		this.index = index;
		this.button = new GuiButton(index, 0, 0, text);
		this.button.visible = false;
		
	}

	public GuiButton getButton() {
		return button;
	}

}
