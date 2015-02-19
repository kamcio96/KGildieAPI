package pl.kamcio96.kgildieapi;

import com.google.common.base.Optional;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

/**
 * Widok pluginu na gildie
 * Zaimplmentuj go aby móc używać API
 * Nie zapomnij użyć @see pl.kamcio96.kgildieapi.KGildieAPI#setPlugin(GuildPlugin) aby zainicjować plugin
 * @author kamcio96
 */
public interface GuildPlugin {

    /**
     * Zwraca gildie na podstawie tagu, o ile jest
     * @param tag tag gildi
     * @return gildia
     */
    public Optional<Guild> getGuildByName(String tag);

    /**
     * Zwraca gildie na podstawie lokalizacji, o ile jest
     * @param loc lokalizacja
     * @return gildia
     */
    public Optional<Guild> getGuildByLocation(Location loc);

    /**
     * Zwraca gildie na podstawie info o graczu, o ile ma on gildie
     * @param player info o graczu
     * @return gildia
     */
    public Optional<Guild> getGuildByPlayer(PlayerData player);

    /**
     * Zwraca gildie na podstawie gracza, o ile ma on gildie
     * @param player gracz
     * @return gildia
     */
    public Optional<Guild> getGuildByPlayer(Player player);

    /**
     * Zwraca wszystkie istniejace gildie
     * @return gildie
     */
    public Collection<Guild> getAllGuilds();

    /**
     * Zwraca info o graczu na podstawie jego obiektu
     * @param player obiekt gracza
     * @return info gracza
     */
    public PlayerData getPlayerDataByPlayer(Player player);

    /**
     * Zwraca info o graczu na podstawie jego nicku, o ile jest
     * @param name nazwa gracz
     * @return info gracza
     */
    public Optional<PlayerData> getPlayerDataByName(String name);

    /**
     * Zwraca info o graczu na podstawie jego UUID, o ile jest
     * @param uid UUID gracza
     * @return info gracza
     */
    public Optional<PlayerData> getPlayerDataByUUID(UUID uid);

    /**
     * Zwraca nazwe pluginu
     * @return nazwa
     */
    public String getPluginName();

    /**
     * Zwraca autora pluginu
     * @return autor
     */
    public Optional<String> getPluginAuthor();

    /**
     * Zwraca wersje pluginu
     * @return wersja
     */
    public Optional<String> getPluginVersion();

    /**
     * Ustawia obiekt ktory odpowiada za tworzenie tagow nad glowami graczy
     * @param tagAdapter
     */
    public void setTagAdapter(GuildTagAdapter tagAdapter);

}
