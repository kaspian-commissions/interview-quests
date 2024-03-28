package com.github.kaspiandev.interview.quest;

import com.github.kaspiandev.interview.Interview;
import com.github.kaspiandev.interview.group.QuestGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public abstract class Quest {

    private static final String QUERY = "INSERT INTO table VALUES (?, ?)";
    protected final Interview plugin;
    protected final QuestGroup questGroup;
    protected String questName;
    protected boolean isComplete;

    protected Quest(Interview plugin, QuestGroup questGroup, String questName) {
        this.plugin = plugin;
        this.questGroup = questGroup;
        this.questName = questName;
        this.isComplete = false;
    }

    public void complete() {
        // database logic
        reward();
        plugin.getRewardProxy().getRewardManager().reward();
        update("abc").thenAccept((isSuccess) -> {
            if (isSuccess) {
                // do something
            } else {
                // do something
            }
        });
    }

    CompletableFuture<Boolean> update(String query) {
        try {
            Connection connection = DriverManager.getConnection("someurl");

            connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new CompletableFuture<>();
    }

    protected abstract void reward();

    protected abstract void progress();

}
