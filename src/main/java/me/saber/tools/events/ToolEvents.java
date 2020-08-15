package me.saber.tools.events;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import itemnbtapi.NBTItem;
import me.saber.tools.SaberTools;
import me.saber.tools.hooks.HookManager;
import me.saber.tools.hooks.impl.FactionHook;
import me.saber.tools.utils.ItemCreation;
import me.saber.tools.utils.Types;
import me.saber.tools.utils.XMaterial;
import net.coreprotect.CoreProtect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class ToolEvents implements Listener {

    @EventHandler
    public void onShockwave(BlockBreakEvent e) {
        if (e.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_PICKAXE) || e
                .getPlayer().getItemInHand().getType().equals(XMaterial.DIAMOND_SHOVEL.parseMaterial()) || e
                .getPlayer().getItemInHand().getType() == Material.DIAMOND_AXE) {
            NBTItem nbti = new NBTItem(e.getPlayer().getItemInHand());
            if (nbti.hasKey("SaberTool") &&
                    nbti.getBoolean("SaberTool")) {
                int radius = nbti.getInteger("Radius");
                shockwaveBreak(e, radius);
            }
        }
    }

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getItemInHand();
        if (item == null || item.getType().equals(Material.AIR))
            return;
        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            Block block = e.getClickedBlock();
            if (block == null)
                return;
            if (block.getType() == null || block.getType().equals(Material.AIR))
                return;
            NBTItem nbti = new NBTItem(e.getPlayer().getItemInHand());
            if (!nbti.hasKey("SaberTool"))
                return;
            if (ItemCreation.pickaxe_blocks.contains(XMaterial.matchXMaterial(block.getType()).parseMaterial().name().toUpperCase())) {
                ItemStack pick = ItemCreation.getItem(Types.Pickaxe, 0);
                if (!item.isSimilar(pick)) {
                    int radius = ItemCreation.getRadius(item);
                    p.getInventory().setItemInHand(ItemCreation.getItem(Types.Pickaxe, radius));
                }
            }
            if (ItemCreation.axe_blocks.contains(XMaterial.matchXMaterial(block.getType()).parseMaterial().name().toUpperCase())) {
                ItemStack axe = ItemCreation.getItem(Types.Axe, 0);
                if (!item.isSimilar(axe)) {
                    int radius = ItemCreation.getRadius(item);
                    p.getInventory().setItemInHand(ItemCreation.getItem(Types.Axe, radius));
                }
            }
            if (ItemCreation.shovel_blocks.contains(XMaterial.matchXMaterial(block.getType()).parseMaterial().name().toUpperCase())) {
                ItemStack shovel = ItemCreation.getItem(Types.Shovel, 0);
                if (!item.isSimilar(shovel)) {
                    int radius = ItemCreation.getRadius(item);
                    p.getInventory().setItemInHand(ItemCreation.getItem(Types.Shovel, radius));
                }
            }
        }
    }

    private WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin))
            return null;
        return (WorldGuardPlugin) plugin;
    }

    public void shockwaveBreak(BlockBreakEvent e, int radius) {

            Player p = e.getPlayer();
            int goesInto = radius / 2;
            radius -= goesInto + 1;
            double x;
            for (x = e.getBlock().getLocation().getX() - radius; x <= e.getBlock().getLocation().getX() + radius; x++) {
                double y;
                for (y = e.getBlock().getLocation().getY() - radius; y <= e.getBlock().getLocation().getY() + radius; y++) {
                    double z;
                    for (z = e.getBlock().getLocation().getZ() - radius; z <= e.getBlock().getLocation().getZ() + radius; z++) {
                        Location loc = new Location(e.getBlock().getWorld(), x, y, z);
                        if (loc.getBlock().getType() != Material.BEDROCK && loc.getBlock().getType() != Material.AIR && loc.getBlock().getType() != XMaterial.SPAWNER.parseMaterial())
                            if (Objects.requireNonNull(getWorldGuard()).canBuild(e.getPlayer(), loc)) {
                                FactionHook facHook = (FactionHook) HookManager.getPluginMap().get("Factions");
                                if (!facHook.canBuild(e.getBlock(), p)) {
                                    e.setCancelled(true);
                                    return;
                                }

                                if (hasAvaliableSlot(p)) {
                                    p.getInventory().addItem(new ItemStack(loc.getBlock().getType()));
                                    loc.getBlock().setType(Material.AIR);
                                    if (Bukkit.getPluginManager().getPlugin("CoreProtect") != null &&
                                            SaberTools.getInstance().getFileManager().getConfig().fetchBoolean("SaberTools.Log-Core-Protect"))
                                        CoreProtect.getInstance().getAPI().logRemoval(p.getName(), loc, loc.getBlock().getType(), loc.getBlock().getData());
                                } else {
                                    loc.getBlock().setType(Material.AIR);
                                }
                            }
                    }
                }
            }
    }

    public boolean hasAvaliableSlot(Player player) {
        PlayerInventory playerInventory = player.getInventory();
        for (ItemStack item : playerInventory.getContents()) {
            if (item == null)
                return true;
        }
        return false;
    }
}

