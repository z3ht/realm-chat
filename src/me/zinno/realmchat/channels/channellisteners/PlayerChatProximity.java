package me.zinno.realmchat.channels.channellisteners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.Set;

public class PlayerChatProximity implements Listener {
	
	private int maxDistance;
	
	public PlayerChatProximity(int maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Set<Player> farPlayers = new HashSet<>();
		Location sourceLocation = event.getPlayer().getLocation();
		for(Player target : event.getRecipients()) {
			Location targetLocation = target.getLocation();
			if(!isRoughlyInRange(sourceLocation, targetLocation))
				farPlayers.add(target);
		}
		event.getRecipients().removeAll(farPlayers);
	}
	
	private boolean isRoughlyInRange(Location source, Location target) {
		return maxDistance > Math.abs(source.getX() - target.getX())
				&& maxDistance > Math.abs(source.getY() - target.getY())
				&& maxDistance > Math.abs(source.getZ() - target.getZ());
	}
	
}
