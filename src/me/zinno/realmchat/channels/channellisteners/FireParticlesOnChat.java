package me.zinno.realmchat.channels.channellisteners;

import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class FireParticlesOnChat implements Listener {
	
	List<String> keywords;
	
	public FireParticlesOnChat(List<String> keywords) {
		this.keywords = keywords;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		for (String keyWord : keywords) {
			if (message.toLowerCase().contains(keyWord)) {
				event.getPlayer().spawnParticle(Particle.FLAME, event.getPlayer().getLocation(), 400);
			}
		}
	}
	
	
}
