package com.github.kaspiandev.interview.quest;

import com.github.kaspiandev.interview.Interview;
import com.github.kaspiandev.interview.group.QuestGroup;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PotatoQuest extends Quest implements Listener {

    private int remainingPotatoes = 500;

    protected PotatoQuest(Interview plugin, QuestGroup questGroup) {
        super(plugin, questGroup, "potatoes");
    }

    @Override
    protected void reward() {

    }

    @Override
    protected void progress() {
        remainingPotatoes--;

        if (remainingPotatoes != 0) return;

        isComplete = true;
        complete();
    }

    @EventHandler
    public void onPotatoBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!questGroup.getPlayers().contains(player.getUniqueId())) return;

        Block block = event.getBlock();
        BlockData blockData = block.getBlockData();
        if (!(blockData instanceof Ageable)) return;

        if (block.getType() != Material.POTATOES) return;

        Ageable potatoData = (Ageable) blockData;
        if (potatoData.getAge() != potatoData.getMaximumAge()) return; // only fully grown potatoes

        progress();
    }

}
