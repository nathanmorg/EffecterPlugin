package n8.effecter.handlers;

import n8.effecter.Effecter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class deathHandler implements Listener {
    FileConfiguration config;
    public deathHandler(Effecter plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        config = plugin.getConfig();
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        //Store the dead player and it's killer
        Player deadPlayer = event.getEntity().getPlayer();
        Player killPlayer = event.getEntity().getKiller();

        //Store the dead player's effects
        Collection<PotionEffect> deadEffects = deadPlayer.getActivePotionEffects();

        //Add the dead player's effects to the killer's effects
        killPlayer.addPotionEffects(deadEffects);
    }
}
