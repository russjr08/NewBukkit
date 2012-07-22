package me.russjr08.plugins;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class IFail extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static IFail plugin;
	public IFail instance;
	

		
		

	
		@Override
		public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		ConfigFileOptions configOptions = new ConfigFileOptions(this);
		PluginDescriptionFile pdfFile = this.getDescription();

		if(configOptions.isVerboseEnabled() == true){
			
		
		this.logger.info(pdfFile.getName() + " Has Been Enabled!"); //Display in the console that the plugin was enabled
		}
		String[] startingKeywords = {"fail", "fial", "f-a-i-l", "f.a.i.l.", "phail" };
		
		
		pm.registerEvents(new MyPlayerListener(this), this);
		if(configOptions.isVerboseEnabled() == true){
			this.logger.info("Adding Default Configuration settings!");
		}
		/*try {
			AutoUpdate autoUpdate = new AutoUpdate(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			new AutoUpdate(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        getConfig().addDefault("User-Control.Added-Words", Arrays.asList(startingKeywords));
		getConfig().addDefault("Configuration.kickMessage", "For Failing!");
		getConfig().addDefault("Configuration.chatMessage", "I shouldn't say the word for doing something incorrectly!");
		getConfig().addDefault("Configuration.loginMessage", "iFail is running on this server!");
		getConfig().addDefault("Configuration.permMessage", "Ehh... you were close.. lucky you have permission to use that..");
		getConfig().addDefault("Configuration.verboseMessages", false);
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		if(configOptions.isVerboseEnabled() == true){
			
		
		boolean isEnabled = getConfig().getBoolean("Enabled");
		this.logger.info("Warning: You have iFail set to " + isEnabled);
		}
		
		}
		
		
		@Override
		public void onDisable(){
		ConfigFileOptions configOptions = new ConfigFileOptions(this);
		PluginDescriptionFile pdfFile = this.getDescription();
		if(configOptions.isVerboseEnabled() == true){
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Plugin has been disabled!"); //Display in the console that the plugin was disabled
		
		}
		}

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){ //Setup a new command
			Player player = (Player) sender; //Allows you to use the Player
			if(commandLabel.equalsIgnoreCase("sendme")){
				player.sendMessage(ChatColor.DARK_RED + "Sent!"); //Sends the message
			}
		return false;
		}
		
		
		

}