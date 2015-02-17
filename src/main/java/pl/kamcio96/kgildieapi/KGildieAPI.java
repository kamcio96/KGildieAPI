package pl.kamcio96.kgildieapi;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Główna klasa API oraz podstawowe metody
 * @author kamcio96
 */
public class KGildieAPI {

    /*
     * TODO: javadocs
     * TODO: eventy
     * TODO: provider
     * TODO: sojusze
     * TODO: tab
     */

    private KGildieAPI() { }

    private static GuildPlugin plugin;

    public static void setPlugin(GuildPlugin plugin){
        Preconditions.checkArgument(KGildieAPI.plugin == null, "Cannot set plugin twice");
        String pluginString = plugin.getPluginName();
        Optional<String> version = plugin.getPluginVersion();
        Optional<String> author = plugin.getPluginAuthor();

        if(version.isPresent()){
            pluginString = pluginString + " v. " + version.get();
        }

        if(author.isPresent()){
            pluginString = pluginString + " by " + author.get();
        }

        Bukkit.getLogger().log(Level.INFO, "KGildieAPI initialized!. Plugin info: " + pluginString);
        KGildieAPI.plugin = plugin;
    }

    /**
     * @see GuildPlugin#getGuildByName(java.lang.String tag)
     */
    public static Optional<Guild> getGuildByName(String tag){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getGuildByName(tag);
    }

    /**
     * @see GuildPlugin#getGuildByLocation(org.bukkit.Location loc)
     */
    public static Optional<Guild> getGuildByLocation(Location loc){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getGuildByLocation(loc);
    }

    /**
     * @see GuildPlugin#getGuildByPlayer(PlayerData player)
     */
    public static Optional<Guild> getGuildByPlayer(PlayerData player){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getGuildByPlayer(player);
    }

    /**
     * @see GuildPlugin#getGuildByPlayer(org.bukkit.entity.Player player)
     */
    public static Optional<Guild> getGuildByPlayer(Player player){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getGuildByPlayer(player);
    }

    /**
     * @see GuildPlugin#getAllGuilds()
     */
    public static Collection<Guild> getAllGuilds(){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getAllGuilds();
    }

    /**
     * @see GuildPlugin#getPlayerDataByPlayer(org.bukkit.entity.Player player)
     */
    public static PlayerData getPlayerDataByPlayer(Player player){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getPlayerDataByPlayer(player);
    }

    /**
     * @see GuildPlugin#getPlayerDataByName(java.lang.String name)
     */
    public static Optional<PlayerData> getPlayerDataByName(String name){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getPlayerDataByName(name);
    }

    /**
     * @see GuildPlugin#getPlayerDataByUUID(java.util.UUID uid)
     */
    public static Optional<PlayerData> getPlayerDataByUUID(UUID uid){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getPlayerDataByUUID(uid);
    }

}
