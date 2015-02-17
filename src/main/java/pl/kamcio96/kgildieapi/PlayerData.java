package pl.kamcio96.kgildieapi;

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
     * Zwraca liczbe smierci gracza
     * @return smierci
     */
    public int getDeaths();

    /**
     * Zwraca liczbe punktow gracza
     * @return pkt
     */
    public int getPoints();

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
