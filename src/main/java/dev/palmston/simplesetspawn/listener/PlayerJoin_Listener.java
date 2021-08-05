package dev.palmston.simplesetspawn.listener;

import dev.palmston.simplesetspawn.file.Config_File;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin_Listener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        if(Config_File.getCfg().getBoolean("options.spawn.AutoTeleportByJoin")){
            Location location = Config_File.getCfg().getLocation("location.spawn");
            player.teleport(location);
        }

    }

}
