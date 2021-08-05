package dev.palmston.simplesetspawn.file;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config_File {

    private static final File file = new File("plugins/SimpleSetSpawn/config.yml");
    private static final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void loadCfg(){

        cfg.addDefault("prefix", "&7[&bSimpleSetSpawn&7]");
        cfg.addDefault("options.spawn.enableSpawnCommand", true);
        cfg.addDefault("options.spawn.needPermissionForSpawnCommand", true);
        cfg.addDefault("options.spawn.OutputMessage", true);
        cfg.addDefault("options.spawn.AutoTeleportByJoin", true);
        cfg.addDefault("messages.noperms", "&4You don't have the permission to this.");
        cfg.addDefault("messages.setSpawnMessage", "&aYou set the Spawn.");
        cfg.addDefault("messages.spawn.isFalse", "&cThe Command for Spawn is deactivated.");
        cfg.addDefault("messages.spawn.OutputMessage", "&aYou are Teleportet!");

        cfg.options().copyDefaults(true);

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveCfg(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static YamlConfiguration getCfg() {
        return cfg;
    }
}
