package me.zinno.realmchat.commands.suppercommands;

import me.zinno.chatmanagerapi.managers.ChatManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import src.me.zinno.chatmanager.commands.SuperCommand;
import src.me.zinno.chatmanager.utils.CommandHelper;

public class RealmChat extends SuperCommand {
	
	private ChatManager chatManager;
	
	public RealmChat(ChatManager chatManager) {
		super("realmchat.chat");
		initialize();
	}
	
	public RealmChat(ChatManager chatManager, CommandHelper commandHelper) {
		super(commandHelper,"realmchat.chat");
		initialize();
	}
	
	
	public void executeBasicCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.DARK_GRAY + "---------------------");
		sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + "Realm Chat");
		sender.sendMessage(ChatColor.GOLD + "Designed By: Zinno");
		sender.sendMessage(ChatColor.DARK_GRAY + "---------------------");
		sender.sendMessage("");
		sender.sendMessage(ChatColor.GRAY.toString() + ChatColor.ITALIC + "Pssst... Type \"/me.zinno.realmchat help\" for a list of commands");
	}
	
	private void initialize() {
		this.chatManager = chatManager;
	}
	
	public ChatManager getChatManager() {
		return chatManager;
	}
}
