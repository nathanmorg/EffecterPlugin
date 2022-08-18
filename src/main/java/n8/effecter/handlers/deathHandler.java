package n8.effecter.handlers;

import n8.effecter.Effecter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class deathHandler implements Listener {
    FileConfiguration config;
    public deathHandler(Effecter plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        config = plugin.getConfig();
    }
    @EventHandler
    public void onPlayerDeath() {

    }
}
