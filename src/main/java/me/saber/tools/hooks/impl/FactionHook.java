package me.saber.tools.hooks.impl;

import me.saber.tools.SaberTools;
import me.saber.tools.exception.NotImplementedException;
import me.saber.tools.hooks.PluginHook;
import me.saber.tools.hooks.impl.factions.FactionMCHook;
import me.saber.tools.hooks.impl.factions.FactionUUIDHook;
import me.saber.tools.utils.Logger;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * SaberTools - Developed by Driftay.
 * All rights reserved 2020.
 * Creation Date: 5/21/2020
 */
public class FactionHook implements PluginHook<FactionHook> {
    public FactionHook setup() {
        if (SaberTools.instance.getServer().getPluginManager().getPlugin(getName()) == null) {
            Logger.print("Factions could not be found", Logger.PrefixType.WARNING);
            return null;
        }
        List<String> authors = SaberTools.instance.getServer().getPluginManager().getPlugin(getName()).getDescription().getAuthors();
        if (!authors.contains("drtshock") && !authors.contains("Benzimmer")) {
            Logger.print("Server Factions type has been set to (MassiveCore)", Logger.PrefixType.DEFAULT);
            return new FactionMCHook();
        }
        Logger.print("Server Factions type has been set to (SaberFactions/SavageFactions/FactionsUUID)", Logger.PrefixType.DEFAULT);
        return new FactionUUIDHook();
    }

    public boolean canBuild(Block block, Player player) {
        try {
            throw new NotImplementedException("Factions does not exist!");
        } catch (NotImplementedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getName() {
        return "Factions";
    }
}
