package com.artemis.the.gr8.playerstats.core.utils;

import java.util.HashMap;
import java.util.Map;

public class CommandCounter {

    private static volatile CommandCounter instance;
    private int helpCommand;
    private int excludeCommand;
    private int shareCommand;
    private int playerStatCommand;
    private int serverStatCommand;
    private int topStatCommand;

    private CommandCounter() {
        resetCounts();
    }

    public static CommandCounter getInstance() {
        CommandCounter localVar = instance;
        if (localVar != null) {
            return localVar;
        }

        synchronized (CommandCounter.class) {
            if (instance == null) {
                instance = new CommandCounter();
            }
            return instance;
        }
    }

    public synchronized void upHelpCommandCount() {
        helpCommand++;
    }

    public synchronized void upExcludeCommandCount() {
        excludeCommand++;
    }

    public synchronized void upShareCommandCount() {
        shareCommand++;
    }

    public synchronized void upPlayerStatCommandCount() {
        playerStatCommand++;
    }

    public synchronized void upServerStatCommandCount() {
        serverStatCommand++;
    }

    public synchronized void upTopStatCommandCount() {
        topStatCommand++;
    }

    public Map<String, Integer> getCommandCounts() {
        Map<String, Integer> commandCounts = new HashMap<>();
        commandCounts.put("Help", helpCommand);
        commandCounts.put("Exclude", excludeCommand);
        commandCounts.put("Share", shareCommand);
        commandCounts.put("Player Stat", playerStatCommand);
        commandCounts.put("Server Stat", serverStatCommand);
        commandCounts.put("Top Stat", topStatCommand);
        resetCounts();
        return commandCounts;
    }

    private void resetCounts() {
        helpCommand = 0;
        excludeCommand = 0;
        shareCommand = 0;
        playerStatCommand = 0;
        serverStatCommand = 0;
        topStatCommand = 0;
    }
}