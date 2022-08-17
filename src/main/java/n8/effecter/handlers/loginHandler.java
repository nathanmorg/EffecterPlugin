package n8.effecter.handlers;

import n8.effecter.Effecter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.Random;

public class loginHandler implements Listener {
    public loginHandler(Effecter plugin) { Bukkit.getPluginManager().registerEvents(this, plugin); }

    //Import list of possible effects
    //Temporary list of string arrays
    String[] effectType = {"Negative", "Positive"};
    String[] posEffects = {"Strength", "Speed", "Regen", "Fire Res"};
    String[] negEffects = {"Damage", "Poison", "Wither", "Blindness"};

    @EventHandler
    private void onPlayerLogin (PlayerLoginEvent event) {
        Player p = event.getPlayer();
        Bukkit.broadcastMessage(p.toString());

        //Need to pick random array either positive or negative
        String type = getRandomEffectType(effectType);

        //Need to pick random effect within array of positive and negative effects
        if (type.equals("Negative")) {
            Bukkit.broadcastMessage(getRandomEffect(negEffects));
        }
        else {
            Bukkit.broadcastMessage(getRandomEffect(posEffects));
        }
    }

    //Randomly decide between positive or negative
    private static String getRandomEffectType(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    //Get random element of effects arrays
    private static String getRandomEffect(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
