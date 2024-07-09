package com.nextdevv.giftblocks;

import com.nextdevv.giftblocks.configs.ConfigLoader;
import com.nextdevv.giftblocks.configs.Messages;
import com.nextdevv.giftblocks.configs.Settings;
import com.nextdevv.giftblocks.utils.VersionChecker;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URISyntaxException;

@Getter
public final class GiftBlocks extends JavaPlugin {
    VersionChecker versionChecker = new VersionChecker("NextDevv/GiftBlocks", this);
    ConfigLoader configLoader = new ConfigLoader(getDataFolder());
    Settings settings;
    Messages messages;

    @Override
    public void onEnable() {
        getLogger().info("=== GiftBlocks ===");
        getLogger().info("By NextDevv");
        getLogger().info("");

        getLogger().info("Loading configs...");
        settings = configLoader.loadSettings();
        messages = configLoader.loadMessages();

        getLogger().info("Checking for updates...");
        try {
            versionChecker.checkVersion(getDescription().getVersion());
        } catch (URISyntaxException e) {
            getLogger().warning("Failed to check for updates.");
        }

        getLogger().info("=== GiftBlocks ===");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
