package com.black_dog20.sc.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.black_dog20.sc.reference.Reference;


public class ConfigurationHandler {

	public static Configuration configuration;
	public static boolean configurationServer = false;

	public static void init(File configFile) {

		// Create configuration object from the given configurations file
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

		if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

	public static void loadConfiguration() {

		if (configuration.hasChanged() && !configurationServer) {
			configuration.save();
		}
	}
}
