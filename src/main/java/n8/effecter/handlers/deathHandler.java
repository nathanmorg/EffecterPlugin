package n8.effecter.handlers;

import n8.effecter.Effecter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class deathHandler implements Listener {
    FileConfiguration config;
    public deathHandler(Effecter plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        config = plugin.getConfig();
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player deadPlayer = event.getEntity().getPlayer();
        //get effects of killPlayer
        Player killPlayer = event.getEntity().getKiller();
        //add effect of dead player to kill player
    }
}
