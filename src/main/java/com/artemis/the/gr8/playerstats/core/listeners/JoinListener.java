package com.artemis.the.gr8.playerstats.core.listeners;

import com.artemis.the.gr8.playerstats.core.utils.OfflinePlayerHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.ApiStatus;

/**
 * Listens for newly joined Players and adds them to
 * the included-players list if they haven't joined
 * this server before
 */
@ApiStatus.Internal
public class JoinListener implements Listener {

    private final OfflinePlayerHandler offlinePlayerHandler;

    public JoinListener() {
        offlinePlayerHandler = OfflinePlayerHandler.getInstance();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent joinEvent) {
        Player player = joinEvent.getPlayer();
        if (!player.hasPlayedBefore() && !offlinePlayerHandler.isExcludedPlayer(player.getUniqueId())) {
            offlinePlayerHandler.addNewIncludedPlayer(player);
        }
    }
}