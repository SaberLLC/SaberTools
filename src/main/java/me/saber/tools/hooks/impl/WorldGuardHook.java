package me.saber.tools.hooks.impl;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import me.saber.tools.hooks.PluginHook;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * SaberTools - Developed by Driftay.
 * All rights reserved 2020.
 * Creation Date: 5/21/2020
 */
public class WorldGuardHook implements PluginHook<WorldGuardHook> {
    private static boolean instantiated = false;

    private WorldGuardPlugin worldGuardPlugin;

    public WorldGuardHook setup() {
        this.worldGuardPlugin = WorldGuardPlugin.inst();
        instantiated = true;
        return this;
    }

    public boolean canBuild(Player player, Block block) {
        if (!instantiated)
            return true;
        return this.worldGuardPlugin.canBuild(player, block);
    }

    public String getName() {
        return "WorldGuard";
    }
}
