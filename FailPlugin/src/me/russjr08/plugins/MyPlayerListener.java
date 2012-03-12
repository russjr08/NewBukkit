package me.russjr08.plugins;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
public class MyPlayerListener implements Listener{
	public static IFail plugin;
	
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event){
		Player player = event.getPlayer();
		
		if(event.getMessage().toLowerCase().contains("fail") || event.getMessage().toLowerCase().contains("failed")){
			event.setCancelled(true);
			player.chat(ChatColor.DARK_RED + "I shouldn't say the word for doing something incorrectly!");
			player.kickPlayer("For failing!");
		}
	}
	

}
