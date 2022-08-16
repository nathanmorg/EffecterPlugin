package n8.effecter;

import n8.effecter.handlers.loginHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Effecter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new loginHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
