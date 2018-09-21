package me.zinno.realmchat.channels;

import me.zinno.chatmanagerapi.channels.Channel;
import me.zinno.realmchat.channels.channellisteners.FireParticlesOnChat;
import me.zinno.realmchat.channels.channellisteners.PlayerChatProximity;
import me.zinno.realmchat.channels.channellisteners.WordFilter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class BasicChannel extends Channel {
	
	public BasicChannel(Plugin plugin, String channelName, Listener... channelListeners) {
		super(plugin, channelName, channelListeners);
	}
	
	public void enableFireParticlesOnKeyword(boolean allow) {
		enableFireParticlesOnKeyword(allow, Arrays.asList("fire"));
	}
	
	public void enableFireParticlesOnKeyword(boolean allow, List<String> keywords) {
		if (!allow)
			return;
		addChannelListener(new FireParticlesOnChat(keywords));
	}
	
	public void enablePlayerChatProximity(boolean allow) {
		enablePlayerChatProximity(allow, 30);
	}
	
	public void enablePlayerChatProximity(boolean allow, int distance) {
		if (!allow)
			return;
		addChannelListener(new PlayerChatProximity(distance));
	}
	
	public void enableWordFilter(boolean allow, List<String> filteredWords) {
		if (!allow)
			return;
		addChannelListener(new WordFilter(filteredWords));
	}
	
}
