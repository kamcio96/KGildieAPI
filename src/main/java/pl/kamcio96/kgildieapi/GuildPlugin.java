package pl.kamcio96.kgildieapi;

import com.google.common.collect.ImmutableList;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.kamcio96.kgildieapi.visible.Visible;
import pl.kamcio96.kgildieapi.visible.VisibleType;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Widok pluginu na gildie
 * Zaimplmentuj go aby móc używać API
 * Nie zapomnij użyć @see pl.kamcio96.kgildieapi.KGildieAPI#setPlugin(GuildPlugin) aby zainicjować plugin
 * @author kamcio96
 */
public interface GuildPlugin {

    /**
     * Usuwa podana gildie
     * @param guild gildia
     */
    void deleteGuild(Guild guild, DeleteReason reason);

    /**
     * Zwraca gildie na podstawie tagu, o ile jest
     * @param tag tag gildi
     * @return gildia
     */
    Optional<Guild> getGuildByName(String tag);

    /**
     * Zwraca gildie na podstawie lokalizacji, o ile jest
     * @param loc lokalizacja
     * @return gildia
     */
    Optional<Guild> getGuildByLocation(Location loc);

    /**
     * Zwraca gildie na podstawie info o graczu, o ile ma on gildie
     * @param player info o graczu
     * @return gildia
     */
    default Optional<GuildPlayer> getGuildByPlayer(PlayerData player) {
        return getGuildByPlayer(player.getUniqueId());
    }

    /**
     * Zwraca gildie na podstawie gracza, o ile ma on gildie
     * @param player gracz
     * @return gildia
     */
    default Optional<GuildPlayer> getGuildByPlayer(Player player) {
        return getGuildByPlayer(player.getUniqueId());
    }

    /**
     * Zwraca gildie na podstawie gracza, o ile ma on gildie
     * @param player gracz
     * @return gildia
     */
    Optional<GuildPlayer> getGuildByPlayer(UUID player);

    /**
     * Zwraca wszystkie istniejace gildie
     * @return gildie
     */
    Collection<Guild> getAllGuilds();

    /**
     * Zwraca info o graczu na podstawie jego obiektu
     * @param player obiekt gracza
     * @return info gracza
     */
    PlayerData getPlayerDataByPlayer(Player player);

    /**
     * Zwraca info o graczu na podstawie jego nicku, o ile jest
     * @param name nazwa gracz
     * @return info gracza
     */
    Optional<PlayerData> getPlayerDataByName(String name);

    /**
     * Zwraca info o graczu na podstawie jego UUID, o ile jest
     * @param uid UUID gracza
     * @return info gracza
     */
    Optional<PlayerData> getPlayerDataByUUID(UUID uid);

    /**
     * Zwraca nazwe pluginu
     * @return nazwa
     */
    String getPluginName();

    /**
     * Zwraca autora pluginu
     * @return autor
     */
    Optional<String> getPluginAuthor();

    /**
     * Zwraca wersje pluginu
     * @return wersja
     */
    Optional<String> getPluginVersion();

    ImmutableList<Guild> getTop20Guilds();

    ImmutableList<PlayerData> getTop20Players();

    /**
     * Ustawia obiekt ktory odpowiada za tworzenie tagow nad glowami graczy
     * @param visible visible
     * @param types types
     */
    void setVisible(Visible visible, VisibleType... types);

    Guild.Builder guildBuilder();

    boolean isInPVP(Player player);
}
