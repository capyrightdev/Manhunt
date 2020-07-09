package com.capy;

import com.capy.commands.team;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import java.util.ArrayList;
import java.util.List;

public class events implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(team.hunterTeam.contains(p)) {
          team.hunterTeam.remove(p);
        } else if(team.runnerTeam.contains(p)) {
            team.runnerTeam.remove(p);
        }
    }
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if(team.hunterTeam.contains(p)) {
           e.setFormat(ChatColor.RED + "HUNTER > " + ChatColor.GRAY + e.getMessage());
        } else if(team.runnerTeam.contains(p)) {
            e.setFormat(ChatColor.GREEN + "RUNNER > " + ChatColor.GRAY + e.getMessage());
        } else if(team.overseerTeam.contains(p)) {
            e.setFormat(ChatColor.DARK_RED + "OVERSEER > " + ChatColor.RED + e.getMessage());
        }
    }


}
