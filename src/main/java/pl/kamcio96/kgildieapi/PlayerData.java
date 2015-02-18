package pl.kamcio96.kgildieapi;

import com.google.common.base.Optional;

import java.util.UUID;

/**
 * PlayerData
 * Podstawowe informacje o graczu
 * @author kamcio96
 */
public interface PlayerData {

    //TODO set methods

    /**
     * Zwraca UUID gracza
     * @return uuid
     */
    public UUID getUniqueId();

    /**
     * Zwraca nazwe gracza
     * @return nazwa
     */
    public String getName();

    /**
     * Zwraca liczbe zabic gracza
     * @return zabicia
     */
    public int getKills();

    /**
     * Ustawia liczbe zabic gracza
     * @param kills zabicia
     */
    public void setKills(int kills);

    /**
     * Zwraca liczbe smierci gracza
     * @return smierci
     */
    public int getDeaths();

    /**
     * Ustawia liczbe smierci gracza
     * @param deaths smierci
     */
    public void setDeaths(int deaths);

    /**
     * Zwraca liczbe punktów gracza
     * @return pkt
     */
    public int getPoints();

    /**
     * Ustawia liczbe punktów gracza
     * @param points pkt
     */
    public void setPoints(int points);

    /**
     * Zwraca gildie, o ile gracz ją ma
     * @return gildia
     */
    public Optional<Guild> getGuild();

    /**
     * Zwraca liczbe sekund przez ktora gracz był na serwerze
     * <p>
     *     Może nie być wspierane przez wszystkie pluginy
     * </p>
     * @return czas
     */
    @Deprecated
    public long getPlayedTime();
}
