package com.github.kaspiandev.interview.command;

import com.github.kaspiandev.interview.Interview;
import com.github.kaspiandev.interview.group.QuestGroup;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuestCommand implements CommandExecutor {

    private final Interview plugin;

    public QuestCommand(Interview plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (plugin.getGroupManager().getPlayerGroup(player).isPresent()) return false; // already in group

        if (args.length == 0) {
            QuestGroup group = plugin.getGroupManager().registerGroup(player);
            plugin.getQuestManager().assignQuest(group);

            return true;
        } else if (args.length == 2) {
            if (args[0].equals("join")) {
                String playerName = args[1];
                Player groupOwner = Bukkit.getPlayer(playerName);
                if (groupOwner == null) {
                    // invalid player
                    return false;
                }

                plugin.getGroupManager().getPlayerGroup(groupOwner).ifPresent((group) -> {
                    group.addPlayer(player);
                });
                return true;
            } else if (args[0].equals("disband")) {

            }
            return false;
        }


        return false;
    }

}
