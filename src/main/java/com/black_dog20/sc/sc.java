package com.black_dog20.sc;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

import com.black_dog20.sc.crafting.NBTSensetiveShapedOreRecipe;
import com.black_dog20.sc.handler.ConfigurationHandler;
import com.black_dog20.sc.handler.EventHandler;
import com.black_dog20.sc.handler.GuiHandler;
import com.black_dog20.sc.handler.PlayerEventHandler;
import com.black_dog20.sc.init.ModBlocks;
import com.black_dog20.sc.init.ModItems;
import com.black_dog20.sc.init.Recipes;
import com.black_dog20.sc.network.PacketHandler;
import com.black_dog20.sc.proxies.IProxy;
import com.black_dog20.sc.reference.Reference;
import com.black_dog20.sc.utility.LogHelper;
import com.black_dog20.sc.worldgen.SCWorldGenerator;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class sc {

	@Mod.Instance(Reference.MOD_ID)
	public static sc instance = new sc();

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy Proxy;

	public static final int guiTeleportBook = 1;
	public static final int guiTeleportBookAdd = 2;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		FMLCommonHandler.instance().bus().register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		FMLCommonHandler.instance().bus().register(new PlayerEventHandler());
		Proxy.registerKeyBindings();
		ModItems.init();
		ModBlocks.init();
		PacketHandler.init();
		Proxy.registerRenders();
		GameRegistry.registerWorldGenerator(new SCWorldGenerator(), 2);
		RecipeSorter.register("soulcraft:nbt_shaped", NBTSensetiveShapedOreRecipe.class, Category.SHAPED, "after:minecraft:shaped before:minecraft:shapeless");
		FMLInterModComms.sendMessage("Waila", "register", "com.black_dog20.vut.waila.Waila.onCall");

		LogHelper.info("Pre Initialization Complete!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		LogHelper.info("Initialization Complete!");
		Proxy.keyinput();
		Recipes.init();
}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		LogHelper.info("Post Initialization Complete!");
	}

	public void reloadRecipes() {
		Recipes.init();
	}
}
