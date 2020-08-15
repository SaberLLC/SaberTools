package me.saber.tools.hooks.impl.factions;

/**
 * SaberTools - Developed by Driftay.
 * All rights reserved 2020.
 * Creation Date: 5/21/2020
 */

import com.massivecraft.factions.listeners.FactionsBlockListener;
import me.saber.tools.hooks.impl.FactionHook;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class FactionUUIDHook extends FactionHook {
    public boolean canBuild(Block block, Player player) {
        return FactionsBlockListener.playerCanBuildDestroyBlock(player, block.getLocation(), "break", true);
    }
}
