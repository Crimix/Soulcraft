package com.black_dog20.sc.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.black_dog20.sc.network.PacketHandler;
import com.black_dog20.sc.network.message.MessagePlayerAddLocation;
import com.black_dog20.sc.utility.LocationHelper;

public class GuiAddTeleportLocation extends GuiScreen{

    protected int guiWidth = 256;
    protected int guiHeight = 200;
    private EntityPlayer player;
    private GuiTextField textField;
    private GuiButton add;
    private GuiButton cancel;

    public GuiAddTeleportLocation(EntityPlayer player) {
    	super();
    	this.player = player;
    }
    
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
    
    @Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	this.drawDefaultBackground();
    	this.textField.drawTextBox();
    	super.drawScreen(mouseX, mouseY, partialTicks);
    	drawString(fontRendererObj, "Enter name for location", this.width / 2 - 50, this.height / 2 - 80, 0xffffff);
	}

	@Override
	public void initGui() {
		this.textField = new GuiTextField(1,this.fontRendererObj, this.width / 2 - 68, this.height/2-46, 137, 20);
		buttonList.add(add = new GuiButton(-1, this.width/4+20, this.height/4+50,80,20, "Add"));
		buttonList.add(cancel = new GuiButton(-1, this.width/4+120, this.height/4+50,80,20, "Cancel"));
		textField.setMaxStringLength(23);
		textField.setText("");
        this.textField.setFocused(true);
	}
	@Override
	protected void keyTyped(char par1, int par2) throws IOException
	{ 
		if(par2 == Keyboard.KEY_RETURN){
			PacketHandler.network.sendToServer(new MessagePlayerAddLocation(textField.getText()));
			mc.displayGuiScreen((GuiScreen)null);
		}
		this.textField.textboxKeyTyped(par1, par2);         
		if(!( par2== Keyboard.KEY_E  &&  this.textField.isFocused())) 
			super.keyTyped(par1, par2);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == add.id){
			PacketHandler.network.sendToServer(new MessagePlayerAddLocation(textField.getText()));
			mc.displayGuiScreen((GuiScreen)null);
		}
		else if(button.id == cancel.id){
			mc.displayGuiScreen((GuiScreen)null);
		}
	}
	
	@Override
    protected void mouseClicked(int x, int y, int btn) throws IOException {
        super.mouseClicked(x, y, btn);
        this.textField.mouseClicked(x, y, btn);
    }
    
	@Override
    public void updateScreen()
    {
        super.updateScreen();
        this.textField.updateCursorCounter();
    }
	

}
