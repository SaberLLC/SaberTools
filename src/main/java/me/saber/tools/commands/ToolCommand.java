package me.saber.tools.commands;

import me.saber.tools.SaberTools;
import me.saber.tools.utils.ItemCreation;
import me.saber.tools.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ToolCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("sabertool")) {
            if (sender instanceof ConsoleCommandSender || sender.isOp() || sender.hasPermission("sabertool.admin")) {
                if (args.length == 0) {
                    sender.sendMessage(Util.color(SaberTools.getInstance().getFileManager().getMessages().fetchString("command-usage")));
                    return true;
                }
                // sabertool give <player> <radius>
                if (args.length == 3) {
                    String arg1 = args[0];
                    String arg2 = args[1];
                    String arg3 = args[2];
                    if (arg1.equalsIgnoreCase("give")) {
                        Player target = Bukkit.getPlayerExact(arg2);
                        if (Integer.parseInt(arg3) % 2 == 0) {
                            sender.sendMessage(Util.color("&c&l[!] &7The radius need to be an odd number!"));
                            return true;
                        }
                        if (target != null && target.isOnline()) {
                            //give item
                            try {
                                int radius = Integer.parseInt(arg3);
                                ItemCreation.giveItem(target, radius);
                                target.sendMessage(Util.color(SaberTools.getInstance().getFileManager().getMessages().fetchString("tool-recieved")));

                            } catch (NumberFormatException e) {
                                //send invalid radius argument to sender
                                sender.sendMessage(Util.color(SaberTools.getInstance().getFileManager().getMessages().fetchString("invalid-number")));
                            }
                        } else {
                            //player not online, invalid to sender
                            sender.sendMessage(Util.color(SaberTools.getInstance().getFileManager().getMessages().fetchString("invalid-player").replace("{player}", arg2)));
                        }
                    }
                }
            } else {
                sender.sendMessage(Util.color(SaberTools.getInstance().getFileManager().getMessages().fetchString("no-perms")));
            }
        }
        return false;
    }
}
