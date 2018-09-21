package me.zinno.realmchat;

import me.zinno.chatmanagerapi.managers.ChatManager;
import me.zinno.realmchat.channels.BasicChannel;
import me.zinno.realmchat.commands.subcommands.AddChannel;
import me.zinno.realmchat.commands.subcommands.ChangeChannel;
import me.zinno.realmchat.commands.subcommands.DelChannel;
import me.zinno.realmchat.commands.subcommands.RealmChatHelp;
import me.zinno.realmchat.commands.suppercommands.RealmChat;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import src.me.zinno.chatmanager.utils.ConfigFile;

import java.util.Arrays;

public class App extends JavaPlugin {
	
	private ChatManager chatManager;
	private ConfigFile realmConfig;
	
	@Override
	public void onEnable() {
		initializeConfig();
		
		initializeChatManager();
		
		initializeRealmChat();
	}
	
	@Override
	public void onDisable() {
	
	}
	
	private void initializeConfig() {
		realmConfig = new ConfigFile(this, "", "config.yml");
		FileConfiguration yamlConfig = realmConfig.getConfigYaml();
		if (!yamlConfig.isSet("fire keywords"))
			yamlConfig.set("fire keywords", Arrays.asList("fire", "flame"));
		if (!yamlConfig.isSet("filtered words"))
			yamlConfig.set("filtered words", Arrays.asList("cupcake", "nugget"));
		if (!yamlConfig.isSet("chat proximity"))
			yamlConfig.set("chat proximity", 30);
		realmConfig.saveConfig();
	}
	
	private void initializeChatManager() {
		chatManager = new ChatManager();
		BasicChannel channel = new BasicChannel(this, "global channel");
		FileConfiguration yamlConfig = realmConfig.getConfigYaml();
		channel.enableWordFilter(true, yamlConfig.getStringList("filtered words"));
		channel.enableFireParticlesOnKeyword(true, yamlConfig.getStringList("fire keywords"));
		channel.enablePlayerChatProximity(true, yamlConfig.getInt("chat proximity"));
		chatManager.addChannel(channel);
	}
	
	private void initializeRealmChat() {
		RealmChat realmChat = new RealmChat(chatManager);
		this.getCommand("realmchat").setExecutor(realmChat);
		
		realmChat.addCommand(Arrays.asList("AddChannel"), new AddChannel(realmChat));
		realmChat.addCommand(Arrays.asList("ChangeChannel", "SwapChannel"), new ChangeChannel(realmChat));
		realmChat.addCommand(Arrays.asList("DeleteChannel"), new DelChannel(realmChat));
		realmChat.addCommand(Arrays.asList("Help"), new RealmChatHelp(realmChat));
		
	}
	
}
