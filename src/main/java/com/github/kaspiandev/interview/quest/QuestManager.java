package com.github.kaspiandev.interview.quest;

import com.github.kaspiandev.interview.Interview;
import com.github.kaspiandev.interview.group.QuestGroup;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

public class QuestManager {

    private final Interview plugin;
    private final Map<QuestGroup, Quest> groupQuest;

    public QuestManager(Interview plugin) {
        this.plugin = plugin;
        this.groupQuest = new HashMap<>();
    }

    public void assignQuest(QuestGroup group) {
        PotatoQuest potatoQuest = new PotatoQuest(plugin, group);
        Bukkit.getServer().getPluginManager().registerEvents(potatoQuest, plugin);
        groupQuest.put(group, potatoQuest);
    }

}
