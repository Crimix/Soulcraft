package com.black_dog20.sc.client.gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.GuiScrollingList;

import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class GuiSlotLocation extends GuiScrollingList {

    private ArrayList<String> achievements;
    private TeleportBookGui parent;
    

    public GuiSlotLocation(TeleportBookGui parent, ArrayList<String> achievements) {
        super(
                parent.getMinecraftInstance(),
                240,
                140,
                (parent.height - parent.guiHeight) / 2 + 8,
                (parent.height - parent.guiHeight) / 2 + 190,
                (parent.width - parent.guiWidth) / 2 + 7,
                50,
                50,
                50
        );
        this.func_27259_a(true, -22);
        this.parent = parent;
        this.achievements = achievements;
    }

    @Override
    protected int getSize() {
        return achievements.size();
    }

    @Override
    protected void elementClicked(int index, boolean doubleClick) {

    }

    @Override
    protected boolean isSelected(int index) {
        return false;
    }

    @Override
    protected void drawBackground() {
        //this.parent.drawDefaultBackground();
    }
/*
    @Override
    protected int getContentHeight() {
        return this.getSize() * 30;
    }
*/
    @Override
    protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5) {
        int guiX = (this.parent.width - this.parent.guiWidth) / 2;
        int guiY = (this.parent.height - this.parent.guiHeight) / 2;

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glColor4f(1,1,1,1);
        

        //this.parent.mc.renderEngine.bindTexture(new ResourceLocation(GMAchievements.MOD_ID, "textures/gui/achievements.png"));
        this.parent.drawTexturedModalRect(guiX + 15, guiY + var3, 0, 200, 200, 30);

        this.parent.getFontRenderer().drawString("Achievement name", guiX + 20, guiY + var3 + 5, 0x000000);
    }
}