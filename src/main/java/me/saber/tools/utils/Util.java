package me.saber.tools.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static void sendCommandMsg(Player p, String msg, String tooltip, String command) {
        TextComponent message = new TextComponent(color(msg));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + command));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(tooltip)).create()));
        p.spigot().sendMessage(message);
    }

    public static void sendHoverText(Player p, String msg, String tooltip) {
        TextComponent message = new TextComponent(color(msg));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(tooltip)).create()));
        p.spigot().sendMessage(message);
    }

    public static void sendUrlMessage(Player p, String msg, String tooltip, String url) {
        TextComponent message = new TextComponent(color(msg));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(tooltip)).create()));
        p.spigot().sendMessage(message);
    }

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> color(List<String> string) {
        List<String> colored = new ArrayList<>();
        for (String line : string)
            colored.add(color(line));
        return colored;
    }

    public static ItemStack createItem(Material material, int amount, short datavalue, String name, List<String> lore) {
        ItemStack item = new ItemStack(material, amount, datavalue);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color(name));
        meta.setLore(color(lore));
        item.setItemMeta(meta);
        return item;
    }
}
