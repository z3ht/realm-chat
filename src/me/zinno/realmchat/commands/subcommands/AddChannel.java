package me.zinno.realmchat.commands.subcommands;

import me.zinno.realmchat.commands.suppercommands.RealmChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import src.me.zinno.chatmanager.commands.SubCommand;

import java.util.Arrays;
import java.util.List;

public class AddChannel implements SubCommand {
	
	private final RealmChat realmChat;
	
	public AddChannel(RealmChat realmChat) {
		this.realmChat = realmChat;
	}
	
	@Override
	public void runCommand(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(cmd.getName());
	}
	
	@Override
	public String permissionLabel() {
		return "realmchat.add";
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		return Arrays.asList("<channel name>");
	}
}
