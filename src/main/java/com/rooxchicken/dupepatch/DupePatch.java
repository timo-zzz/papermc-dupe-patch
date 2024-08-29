package com.rooxchicken.dupepatch;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DupePatch extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getLogger().info("Patching the PaperMC Book and Quill Duplication glitch since 1987 [made by roo]");
    }

    @EventHandler
    public void preventDupe(PlayerEditBookEvent event)
    {
        if(event.getNewBookMeta().getTitle().length() > 15)
        {
            event.setCancelled(true);
            Bukkit.getLogger().log(Level.WARNING, "Player " + event.getPlayer().getName() + " is attempting to dupe!");
        }
    }
}
