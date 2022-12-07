package n8.effecter.handlers;

import n8.effecter.Effecter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;
import java.util.Random;

public class loginHandler implements Listener {
    FileConfiguration config;

    public loginHandler(Effecter plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        config = plugin.getConfig();
    }
    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event) {
        int numPos = config.getConfigurationSection("positive").getKeys(false).size();
        int numNeg = config.getConfigurationSection("negative").getKeys(false).size();

        //Randomly select either positive(0) or negative(1) and store it
        int effectType = getRandomInt(2);

        //Create variables to store necessary data to retrieve from config.yml
        int index;
        PotionEffectType name;
        int duration;
        int amplifier;

        //Import effect from config
        if (effectType == 0) {
            //Positive effect at random index
            index = getRandomInt(numPos);
            if (config.getString("positive." + index + ".name") == null) {
                Bukkit.broadcastMessage("The config value was null positive");
                return;
            }
            name = PotionEffectType.getByName(Objects.requireNonNull(config.getString("positive." + index + ".name")));
            duration = config.getInt("positive." + index + ".duration");
            amplifier = config.getInt("positive." + index + ".amplifier");
        } else {
            //Negative effect at random index
            index = getRandomInt(numNeg);
            if (config.getString("negative." + index + ".name") == null) {
                return;
            }
            name = PotionEffectType.getByName(Objects.requireNonNull(config.getString("negative." + index + ".name")));
            duration = config.getInt("negative." + index + ".duration");
            amplifier = config.getInt("negative." + index + ".amplifier");
        }

        //Construct the effect and assign it to the player
        assert name != null;
        PotionEffect randomEffect = new PotionEffect(name, duration, amplifier);
        Player p = event.getPlayer();
        p.addPotionEffect(randomEffect);
    }

    //Get a random integer
    public static int getRandomInt(int n) {
        return new Random().nextInt(n);
    }
}