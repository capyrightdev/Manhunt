package com.capy.commands;

import com.capy.events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class manhunt implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if(args.length == 1) {
            if (args[0].equalsIgnoreCase("release")) {
                for (Player runners : team.runnerTeam) {
                    runners.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1));
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Location of " + runners.getName() + " " + ChatColor.GOLD + runners.getLocation().getX() + " | " + runners.getLocation().getY());
                }
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.sendTitle(ChatColor.RED + "RUNNERS LOCATIONS HAVE BEEN REVEALED", "A", 1, 20 ,1);
                }
            } else if (args[0].equalsIgnoreCase("start")) {
                if (team.hunterTeam.contains(p)) {
                    for (Player players : team.hunterTeam) {
                        players.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 900, 223));
                        players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 900, 223));
                        players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 900, 223));
                    }
                    for (Player runners2 : team.runnerTeam) {
                        runners2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 900, 2));
                    }
                }
            }
        } else {
            p.sendMessage(ChatColor.GREEN + "Manhunt is currently working.");
        }


        return false;
    }
}
