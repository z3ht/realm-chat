package me.zinno.realmchat.channels.channellisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class WordFilter implements Listener {
	
	List<String> filteredWords;
	
	public WordFilter(List<String> filteredWords) {
		this.filteredWords = filteredWords;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String[] messageArray = event.getMessage().split(" ");
		for(String filteredWord : filteredWords) {
			int c = 0;
			for(String messageWord : messageArray) {
				String replacementWord = new String(new char[messageWord.length()]).replace("\0", "*");
				String strippedMessageWord = messageWord.replaceAll("\\W", "");
				if(strippedMessageWord.toLowerCase().contains(filteredWord.toLowerCase()))
					messageArray[c] = replacementWord;
				c++;
			}
		}
		
		StringBuilder finalMessage = new StringBuilder();
		for(String word : messageArray)
			finalMessage.append(word + " ");
		
		event.setMessage(finalMessage.toString());
	}
	
}
