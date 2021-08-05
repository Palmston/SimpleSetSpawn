package dev.palmston.simplesetspawn;

import dev.palmston.simplesetspawn.commands.SetSpawn_Command;
import dev.palmston.simplesetspawn.commands.Spawn_Command;
import dev.palmston.simplesetspawn.file.Config_File;
import dev.palmston.simplesetspawn.listener.PlayerJoin_Listener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SimpleSetSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Config_File.loadCfg();
        Objects.requireNonNull(getCommand("setspawn")).setExecutor(new SetSpawn_Command());
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new Spawn_Command());
        Bukkit.getPluginManager().registerEvents(new PlayerJoin_Listener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
