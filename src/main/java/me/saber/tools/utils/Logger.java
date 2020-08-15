package me.saber.tools.utils;

import me.saber.tools.SaberTools;
import org.bukkit.ChatColor;

public class Logger {
    public static void print(String message, PrefixType type) {
        SaberTools.instance.getServer().getConsoleSender().sendMessage(type.getPrefix() + message);
    }

    public enum PrefixType {
        WARNING(ChatColor.RED + "WARNING: "),
        NONE(""),
        DEFAULT(ChatColor.GOLD + "[SaberTools] "),
        FAILED(ChatColor.RED + "FAILED: ");

        private String prefix;

        PrefixType(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return this.prefix;
        }
    }
}
