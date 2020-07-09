package com.capy;

import com.capy.commands.manhunt;
import com.capy.commands.team;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
        Bukkit.getPluginManager().registerEvents(new events(), this);
        getCommand("manhunt").setExecutor(new manhunt());
        getCommand("team").setExecutor(new team());
    }

}
