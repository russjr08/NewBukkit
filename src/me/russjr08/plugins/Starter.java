package me.russjr08.plugins;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Starter extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Starter plugin;
	
	
		
		
	
	
		@Override
		public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Enabled!"); //Display in the console that the plugin was enabled
		}
		
		
		@Override
		public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Plugin has been disabled!"); //Display in the console that the plugin was disabled
		}

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
			Player player = (Player) sender;
			if(commandLabel.equalsIgnoreCase("sendme")){
				player.chat("iFail!");
				player.sendMessage(ChatColor.DARK_RED + "Sent!");
			}
		return false;
		}

}
