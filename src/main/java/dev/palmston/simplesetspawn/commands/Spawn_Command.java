package dev.palmston.simplesetspawn.commands;

import dev.palmston.simplesetspawn.file.Config_File;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Spawn_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        Location location = Config_File.getCfg().getLocation("location.spawn");



        if(Config_File.getCfg().getBoolean("options.spawn.enableSpawnCommand") == true){
            if(Config_File.getCfg().getBoolean("options.spawn.needPermissionForSpawnCommand")){
                if(player.hasPermission("simplesetspawn.spawn")){
                    player.teleport(location);
                    if(Config_File.getCfg().getBoolean("options.spawn.OutputMessage")) player.sendMessage(Objects.requireNonNull(Config_File.getCfg().getString("prefix")).replace("&", "§") + " " + Objects.requireNonNull(Config_File.getCfg().getString("messages.spawn.OutputMessage")).replace("&", "§"));
                } else {
                    player.sendMessage(Objects.requireNonNull(Config_File.getCfg().getString("prefix")).replace("&", "§") + " " + Objects.requireNonNull(Config_File.getCfg().getString("messages.noperms")).replace("&", "§"));
                }
            } else {
                player.teleport(location);
                if(Config_File.getCfg().getBoolean("options.spawn.OutputMessage")) player.sendMessage(Objects.requireNonNull(Config_File.getCfg().getString("prefix")).replace("&", "§") + " " + Objects.requireNonNull(Config_File.getCfg().getString("messages.spawn.OutputMessage")).replace("&", "§"));
            }


        } else if(Config_File.getCfg().getBoolean("options.spawn.enableSpawnCommand") == false) {
            player.sendMessage(Objects.requireNonNull(Config_File.getCfg().getString("prefix")).replace("&", "§") + " " + Objects.requireNonNull(Config_File.getCfg().getString("messages.spawn.isFalse")).replace("&", "§"));
        }

        return false;
    }
}
