package mal.lootbags.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import mal.lootbags.LootBags;
import mal.lootbags.handler.BagHandler;
import mal.lootbags.tileentity.TileEntityRecycler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class RecyclerGui extends GuiContainer{

	private TileEntityRecycler bench;
	
	public RecyclerGui(InventoryPlayer player, TileEntityRecycler te) {
		super(new RecyclerContainer(player, te));
		
		bench = te;
		ySize = 186;
	}

	/**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	this.fontRendererObj.drawString("Loot Recycler", 54, 5, 4210752);
    	
    	this.fontRendererObj.drawString("Stored Bags: " + bench.getTotalBags(), 48, 35, 4210752);
    }
    
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(new ResourceLocation("lootbags", "textures/gui/recyclerGui.png"));
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		super.drawScreen(par1, par2, par3);
		
		//see if the mouse is over the fuel bar
		//TODO: fix
		if(isPointInRegion(48, 35, 80, 8, par1, par2, guiLeft, guiTop))
		{
			ArrayList list = new ArrayList();
			
			list.add("\u00A73" + "Stored Loot Value:");
			list.add("\u00A78" + bench.getValue() + "/" + LootBags.TOTALVALUE);
			
	        this.drawHoveringText(list, par1, par2, fontRendererObj);
		}
	}
	
	public static boolean isPointInRegion(int left, int top, int width, int height, int pointx,
			int pointy, int guiLeft, int guiTop) {
        pointx -= guiLeft;
        pointy -= guiTop;
        return pointx >= left - 1 && pointx < left + width + 1 && pointy >= top - 1 && pointy < top + height + 1;
	}
}
/*******************************************************************************
 * Copyright (c) 2016 Malorolam.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the included license.
 * 
 *********************************************************************************/