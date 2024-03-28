package com.github.kaspiandev.interview;

import com.github.kaspiandev.interview.command.QuestCommand;
import com.github.kaspiandev.interview.group.GroupManager;
import com.github.kaspiandev.interview.quest.QuestManager;
import com.github.kaspiandev.interview.reward.MainRewardManager;
import com.github.kaspiandev.interview.reward.RewardProxy;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Interview extends JavaPlugin {

    private GroupManager groupManager;
    private QuestManager questManager;
    private RewardProxy rewardProxy;

    @Override
    public void onEnable() {
        this.groupManager = new GroupManager();
        this.questManager = new QuestManager(this);

        PluginCommand command = getCommand("quest");
        if (command != null) {
            QuestCommand questCommand = new QuestCommand(this);
            command.setExecutor(questCommand);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public GroupManager getGroupManager() {
        return groupManager;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }

    public RewardProxy getRewardProxy() {
        if (rewardProxy == null) {
            this.rewardProxy = new RewardProxy(new MainRewardManager());
        }
        return rewardProxy;
    }

}
