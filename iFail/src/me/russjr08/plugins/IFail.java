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
	public final MyPlayerListener pl = new MyPlayerListener(this);
	
		
		
	
	
		@Override
		public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Enabled!"); //Display in the console that the plugin was enabled
		String[] startingKeywords = {"fail", "fial", "f-a-i-l", "f.a.i.l.", "phail" };
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.pl, this);
		getConfig().addDefault("User-Control.Added-Words", Arrays.asList(startingKeywords));
		getConfig().set("Configuration.kickMessage", "For Failing!");
		getConfig().set("Configuration.chatMessage", "I shouldn't say the word for doing something incorrectly!");
		getConfig().set("Configuration.loginMessage", "iFail is running on this server!");
		getConfig().set("Configuration.permMessage", "Ehh... you were close.. lucky you have permission to use that..");
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		boolean isEnabled = getConfig().getBoolean("Enabled");
		this.logger.info("Warning: You have iFail set to " + isEnabled);
		
		
		}
		
		
		@Override
		public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Plugin has been disabled!"); //Display in the console that the plugin was disabled
		
		}

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){ //Setup a new command
			Player player = (Player) sender; //Allows you to use the Player
			if(commandLabel.equalsIgnoreCase("sendme")){
				player.sendMessage(ChatColor.DARK_RED + "Sent!"); //Sends the message
			}
		return false;
		}
		
		
		

}