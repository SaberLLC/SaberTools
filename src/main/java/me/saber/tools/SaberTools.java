package me.saber.tools;

import me.saber.tools.commands.ToolCommand;
import me.saber.tools.events.ToolEvents;
import me.saber.tools.hooks.HookManager;
import me.saber.tools.hooks.PluginHook;
import me.saber.tools.hooks.impl.FactionHook;
import me.saber.tools.hooks.impl.WorldGuardHook;
import me.saber.tools.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class SaberTools extends JavaPlugin {
    public static SaberTools instance;

    private FileManager fileManager;

    public static SaberTools getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        this.fileManager = new FileManager();
        List<PluginHook<?>> hooks = new ArrayList<>();
        hooks.add(new FactionHook());
        if (Bukkit.getPluginManager().getPlugin("WorldGuard") != null)
            hooks.add(new WorldGuardHook());
        new HookManager(hooks);
        this.fileManager.setup();
        Bukkit.getPluginManager().registerEvents(new ToolEvents(), this);
        getCommand("sabertools").setExecutor(new ToolCommand());
    }

    public void onDisable() {
        instance = null;
    }

    public FileManager getFileManager() {
        return this.fileManager;
    }
}