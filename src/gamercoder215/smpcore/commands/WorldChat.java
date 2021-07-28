package gamercoder215.smpcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import gamercoder215.smpcore.Main;

public class WorldChat implements CommandExecutor {
	
	public Main plugin;
	
	public WorldChat(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("worldchat").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) return false;
		
		Player p = (Player) sender;
		
		if (args.length < 1) p.sendMessage(ChatColor.RED + "You need to provide something to say!");
		else {
			String msg = "";
			for (int i = 0; i < args.length; i++) {
				msg = msg + args[i] + " ";
			}
			
			for (Player pl : p.getWorld().getPlayers()) {
				pl.sendMessage(ChatColor.WHITE + "<" + ChatColor.DARK_GREEN + p.getName() + " | WorldChat" + ChatColor.WHITE + "> " + msg);
			}
		}
		return false;
	}

}
