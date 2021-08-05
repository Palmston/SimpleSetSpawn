package dev.palmston.simplesetspawn.commands;

import dev.palmston.simplesetspawn.file.Config_File;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SetSpawn_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        if(player.hasPermission("simplesetspawn.setspawn")){
            Location location = player.getLocation();
            Config_File.getCfg().set("location.spawn", location);
            Config_File.saveCfg();
            player.sendMessage(Objects.requireNonNull(Config_File.getCfg().getString("prefix")).replace("&", "§") + " " + Objects.requireNonNull(Config_File.getCfg().getString("messages.setSpawnMessage")).replace("&", "§"));
        } else {
            player.sendMessage(Objects.requireNonNull(Config_File.getCfg().getString("prefix")).replace("&", "§") + " " + Objects.requireNonNull(Config_File.getCfg().getString("messages.noperms")).replace("&", "§"));
        }

        return false;
    }
}
