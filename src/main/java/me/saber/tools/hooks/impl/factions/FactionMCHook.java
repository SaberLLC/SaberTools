package me.saber.tools.hooks.impl.factions;

import com.massivecraft.factions.engine.EnginePermBuild;
import com.massivecraft.massivecore.ps.PS;
import me.saber.tools.hooks.impl.FactionHook;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * SaberTools - Developed by Driftay.
 * All rights reserved 2020.
 * Creation Date: 5/21/2020
 */
public class FactionMCHook extends FactionHook {
    public boolean canBuild(Block block, Player player) {
        return EnginePermBuild.canPlayerBuildAt(player, PS.valueOf(block), true);
    }
}
