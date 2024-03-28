package com.github.kaspiandev.interview.group;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class QuestGroup {

    private final List<UUID> players;
    //private Quest quest;

    protected QuestGroup(Player player) {
        this.players = new ArrayList<>(Collections.singletonList(player.getUniqueId()));
    }

    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
    }

    public List<UUID> getPlayers() {
        return players;
    }

//    public Optional<Quest> getQuest() {
//        return Optional.ofNullable(quest);
//    }
//
//    public void setQuest(Quest quest) {
//        this.quest = quest;
//    }

}
