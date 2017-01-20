package com.black_dog20.sc.client.gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.black_dog20.sc.reference.Reference;

import java.io.IOException;
import java.util.ArrayList;

public class TeleportBookGui extends GuiScreen{

    protected int guiWidth = 256;
    protected int guiHeight = 200;

    private ArrayList<String> achievements;
    private GuiSlotLocation achievementsList;

    private EntityPlayer player;

    public TeleportBookGui(EntityPlayer player) {
        this.player = player;

        achievements = new ArrayList<String>();
        for(int i=0; i<10; i++) {
            achievements.add("Achv " + i);
        }
    }

    @Override
    public void initGui() {
        super.initGui();

        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;

        this.buttonList.add( new GuiButton(1, guiX + 9, guiY + 148, 50, 15, "Close"));

        this.achievementsList=new GuiSlotLocation(this, achievements);
        this.achievementsList.registerScrollButtons(this.buttonList, 7, 8);
    }

    @Override
    protected void keyTyped(char p_73869_1_, int p_73869_2_) {
        player.closeScreen();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.enabled)
        {
            switch (button.id) {
                case 1:
                    this.player.closeScreen();
                    return;
            }
        }
        try {
			super.actionPerformed(button);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void drawScreen(int x, int y, float ticks) {
        super.drawScreen(x, y, ticks);
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();

        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;


        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/guiTeleportBook.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, 256, 200);
        //drawTexturedModalRect(guiX + 18, guiY + 18, 0, 200, 200, 30);

        this.achievementsList.drawScreen(x, y, ticks);

    }

    Minecraft getMinecraftInstance() {
        /** Reference to the Minecraft object. */
        return mc;
    }

    FontRenderer getFontRenderer() {
        /** The FontRenderer used by GuiScreen */
        return fontRendererObj;
    }

}