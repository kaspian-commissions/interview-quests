package com.github.kaspiandev.interview.reward;

public class RewardProxy {

    private RewardManager rewardManager;

    public RewardProxy(RewardManager rewardManager) {
        this.rewardManager = rewardManager;
    }

    public RewardManager getRewardManager() {
        return rewardManager;
    }

    public void setRewardManager(RewardManager rewardManager) {
        this.rewardManager = rewardManager;
    }

}
