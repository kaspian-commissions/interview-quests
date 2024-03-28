package com.github.kaspiandev.interview.group;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupManager {

    private final List<QuestGroup> groups;

    public GroupManager() {
        this.groups = new ArrayList<>();
    }

    public QuestGroup registerGroup(Player player) {
        QuestGroup group = new QuestGroup(player);
        groups.add(group);
        return group;
    }

    public Optional<QuestGroup> getPlayerGroup(Player player) {
        return groups.stream()
                     .filter((group) -> group.getPlayers().contains(player.getUniqueId()))
                     .findAny();
    }

}
