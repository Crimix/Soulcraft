package com.black_dog20.sc.client.gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.black_dog20.sc.sc;
import com.black_dog20.sc.network.PacketHandler;
import com.black_dog20.sc.network.message.MessagePlayerWantsLocations;
import com.black_dog20.sc.reference.Reference;
import com.mojang.realmsclient.gui.ChatFormatting;

import java.io.IOException;
import java.util.ArrayList;

public class GuiTeleportBook extends GuiScreen{

    protected int guiWidth = 256;
    protected int guiHeight = 200;
    private GuiLocationList locationList;
    public EntityPlayer player;
    private GuiButton add;

    public GuiTeleportBook(EntityPlayer player) {
    	super();
    	this.player = player;
    }
    
    
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
    
    @Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	locationList.drawScreen(mouseX, mouseY, partialTicks);
    	super.drawScreen(mouseX, mouseY, partialTicks);
		drawString(fontRendererObj, "Teleportation tome", this.width / 2 - 40, this.height / 2 - 90, 0xffffff);
	}

	@Override
	public void initGui() {
		PacketHandler.network.sendToServer(new MessagePlayerWantsLocations());
		buttonList.add(add = new GuiButton(-1, this.width/4, this.height/4+120,80,20, "Add Location"));
		locationList = new GuiLocationList(mc, width/2, height/2, height/4, 3*height/4, width/4, 25, width, height, this);
		if(locationList.getSize()>0)
			for(GuiLocation entry : locationList.getList())
				buttonList.add(entry.getButton());
		add.enabled = true;
	}

	@Override
    public void handleMouseInput() throws IOException
    {
		super.handleMouseInput();
        int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
		locationList.handleMouseInput(mouseX, mouseY);

    }
	
	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == add.id){
			player.openGui(sc.instance, sc.guiTeleportBookAdd, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);	
		}
	}

}