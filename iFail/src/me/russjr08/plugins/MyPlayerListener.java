package me.russjr08.plugins;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyPlayerListener implements Listener{
	private IFail plugin;
	
	
	
	// Special thanks to nala3, we would have never had config options without this!
	public MyPlayerListener(IFail plugin){
        this.plugin = plugin;
        

    }
	
	

	
	//private static final String[] keywords = {"fail", "fial", "f-a-i-l", "f.a.i.l.", "phail" };
	
	
	
    
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		
		String loginMessage = plugin.getConfig().getString("Configuration.loginMessage");
		Player player = event.getPlayer();
		
	
		player.sendMessage(ChatColor.AQUA + loginMessage);
	}
	
	
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event){
		Player player = event.getPlayer();
		
		/*if(player.isOp() && event.getMessage().toLowerCase().contains("fail") || event.getMessage().toLowerCase().contains("fial") || event.getMessage().toLowerCase().contains("f-a-i-l") || event.getMessage().toLowerCase().contains("f.a.i.l.") || event.getMessage().toLowerCase().contains("phail")){
			player.sendMessage(ChatColor.BLUE + "Ehh, you were close... lucky OPs!");
		}
		else if(event.getMessage().toLowerCase().contains("fail") || event.getMessage().toLowerCase().contains("fial") || event.getMessage().toLowerCase().contains("f-a-i-l") || event.getMessage().toLowerCase().contains("f.a.i.l.") || event.getMessage().toLowerCase().contains("phail") ){
			event.setCancelled(true);
			player.chat(ChatColor.DARK_RED + "I shouldn't say the word for doing something incorrectly!");
			player.kickPlayer("For failing!");
		} This is old very bad code... unorganized. Thanks to Canownueasy for showing me better ways of doing this!! */
                        
		Boolean isEnabled = plugin.getConfig().getBoolean("Enabled", true);
		List<String> configWords = plugin.getConfig().getStringList("User-Control.Added-Words");

		
		String kickMessage = plugin.getConfig().getString("Configuration.kickMessage");
		
		String chatMessage = plugin.getConfig().getString("Configuration.chatMessage");
		
		
		
		String permMessage = plugin.getConfig().getString("Configuration.permMessage");
		
		if (isEnabled == true){
			

		
		if (!player.isOp() || !player.hasPermission("iFail.bypass")) {
                    
                   
			for (String inputWord : configWords) {
				if (event.getMessage().toLowerCase().contains(inputWord)) {
					event.setCancelled(true);
                                        player.chat(ChatColor.DARK_RED + chatMessage);
					player.kickPlayer(kickMessage);
					break;
				
			
                                }
        }
		}
        
	
                if (player.isOp() || player.hasPermission("iFail.bypass")) {
                    
                    
                    for (String inputWord : configWords) {
                        if (event.getMessage().toLowerCase().contains(inputWord)){
                            player.sendMessage(ChatColor.AQUA + permMessage);
                            break;
                        }
                    }
                }

		}
		else{
			plugin.logger.info("Warning: iFail is disabled");
		}
}
}



