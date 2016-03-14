package pl.kamcio96.kgildieapi;

import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.kamcio96.kgildieapi.visible.Visible;
import pl.kamcio96.kgildieapi.visible.VisibleType;

import java.util.*;
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
    private static List<Runnable> callbackList = new ArrayList<>();

    /**
     * Inicjalizacja pluginu
     * Powinno być wykonane po załadowaniu głównego pluginu
     * @param plugin instancja pluginu na gildie
     */
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

        for(Runnable callback : callbackList){
            callback.run();
        }
        callbackList = null;
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
    public static Optional<GuildPlayer> getGuildByPlayer(PlayerData player){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getGuildByPlayer(player);
    }

    /**
     * @see GuildPlugin#getGuildByPlayer(org.bukkit.entity.Player player)
     */
    public static Optional<GuildPlayer> getGuildByPlayer(Player player){
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.getGuildByPlayer(player);
    }

    /**
     * @see GuildPlugin#getGuildByPlayer(org.bukkit.entity.Player player)
     */
    public static Optional<GuildPlayer> getGuildByPlayer(UUID player){
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

    /**
     * @see GuildPlugin#setVisible(Visible, VisibleType...)
     */
    public static void setVisible(Visible visible, VisibleType... types) {
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        plugin.setVisible(visible, types);
    }

    /**
     * Callback do wykonania gdy plugin na Gildie sie zaladuje, gdy jest juz zaladowany to wykonuje sie od razu.
     * <p>
     *     Stworzone po to, aby pluginy wykorzystujace API nie musiały mieć 'depend' lub 'softdepend' w plugin.yml
     *     Wystarczy dodac to co ma sie wykonać po załadowaniu pluginu ;)
     * </p>
     * @param callback Callback
     * @return true gdy wykona sie odrazu, false gdy pozniej
     */
    public static boolean addEnableCallback(Runnable callback){
        if(plugin != null){
            callback.run();
            return true;
        } else {
            callbackList.add(callback);
            return false;
        }
    }

    static Guild.Builder guildBuilder() {
        Preconditions.checkNotNull(plugin, "Cannot use KGildieAPI before set the plugin");
        return plugin.guildBuilder();
    }

}
