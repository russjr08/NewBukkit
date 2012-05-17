package me.russjr08.plugins;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFileOptions {

	private IFail plugin;
	
	public ConfigFileOptions(IFail plugin) {
		this.plugin = plugin;
	}
	
	
	
	
	//This method will accept TnT's request at a option for verbose messages.
	public boolean isVerboseEnabled(){
		final FileConfiguration config = plugin.getConfig();
		if(!config.getBoolean("Configuration.verboseMessages")){
			return false;
		}
		
		return true;
	}
	


}
