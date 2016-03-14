package pl.kamcio96.kgildieapi;

import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

/**
 * PlayerData
 * Podstawowe informacje o graczu
 * @author kamcio96
 */
public interface PlayerData {

    /**
     * Zwraca UUID gracza
     * @return uuid
     */
    UUID getUniqueId();

    /**
     * Zwraca nazwe gracza
     * @return nazwa
     */
    String getName();

    /**
     * Zwraca liczbe zabic gracza
     * @return zabicia
     */
    int getKills();

    /**
     * Ustawia liczbe zabic gracza
     * @param kills zabicia
     */
    void setKills(int kills);

    /**
     * Zwraca liczbe smierci gracza
     * @return smierci
     */
    int getDeaths();

    /**
     * Ustawia liczbe smierci gracza
     * @param deaths smierci
     */
    void setDeaths(int deaths);

    /**
     * Zwraca liczbe punktów gracza
     * @return pkt
     */
    int getPoints();

    /**
     * Ustawia liczbe punktów gracza
     * @param points pkt
     */
    void setPoints(int points);

    /**
     * Zwraca obiekt gracza, o ile istnieje
     * @return
     */
    Optional<Player> getPlayer();

    /**
     * Zwraca gildie, o ile gracz ją ma
     * @return gildia
     */
    Optional<Guild> getGuild();

    /**
     * Zwraca liczbe sekund przez ktora gracz był na serwerze
     * <p>
     *     Może nie być wspierane przez wszystkie pluginy
     * </p>
     * @return czas
     */
    @Deprecated
    long getPlayedTime();
}
