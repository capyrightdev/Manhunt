package com.capy.commands;

import com.capy.events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class team implements CommandExecutor {
    public static List<Player> hunterTeam = new ArrayList<>();
    public static List<Player> runnerTeam = new ArrayList<>();
    public static List<Player> overseerTeam = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("runner")) {
                if(hunterTeam.contains(p)) {
                    hunterTeam.remove(p);
                    runnerTeam.add(p);
                }
                runnerTeam.add(p);
                Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + " has joined the runner team!");
            } else if(args[0].equalsIgnoreCase("hunter")) {
                if(runnerTeam.contains(p)) {
                    runnerTeam.remove(p);
                    hunterTeam.add(p);
                }
                hunterTeam.add(p);
                Bukkit.broadcastMessage(ChatColor.RED + p.getName() + " has joined the hunter team!");
            } else if(args[0].equalsIgnoreCase("overseer")) {
                if(p.getName().equalsIgnoreCase("IAmCopyrighted")) {
                    if (runnerTeam.contains(p) || hunterTeam.contains(p)) {
                        runnerTeam.remove(p);
                        hunterTeam.remove(p);
                    }
                        p.setGameMode(GameMode.SPECTATOR);
                        overseerTeam.add(p);
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + "IAMCOPYRIGHTED HAS BECOME THE OVERSEER");
                    }
            }
        }


        return false;
    }
}
