package com.capy.overseer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if(args.length == 1) {
            Player r = Bukkit.getPlayerExact(args[0]);
            if(r != null) {
                p.teleport(r);
                p.sendMessage(ChatColor.GREEN + "You have been teleported to " + r.getName() + " anonymously.");
            } else {
                p.sendMessage(ChatColor.RED + "Invalid.");
            }
        } else {
            p.sendMessage(ChatColor.RED + "Invalid args!");
        }

        return false;
    }

}
