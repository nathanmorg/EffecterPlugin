package n8.effecter;

import n8.effecter.commands.createEffect;
import n8.effecter.handlers.loginHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Effecter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        new loginHandler(this);
        getCommand("createeffect").setExecutor(new createEffect());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
