package n8.effecter.handlers;

import n8.effecter.Effecter;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;

public class loginHandler implements Listener {
    public loginHandler(Effecter plugin) { Bukkit.getPluginManager().registerEvents(this, plugin); }
    //Need list of possible effects

    private void onPlayerLogin (PlayerLoginEvent event) {
    //Need to pick random array either positive or negative

    // Need to pick random effect within array of positive and negative effects

    }
}
