package pl.kamcio96.kgildieapi;

import org.bukkit.Location;
import org.bukkit.World;

public interface GuildArea extends GuildHolder {

    /**
     * Zwraca świat gildi
     * @return org.bukkit.World świat
     */
    World getWorld();

    /**
     * Zwraca współrzędną x srodka gildi
     * @return int X
     */
    int getCenterX();

    /**
     * Zwraca współrzędną z srodka gildi
     * @return int Z
     */
    int getCenterZ();

    /**
     * Zwraca rozmiar gildi
     * @return int rozmiar
     */
    int getSize();

    /**
     * Ustawia rozmiar gildi
     * @param size nowy rozmiar gildi
     * @throws IllegalArgumentException gdy size jest mniejszy od 0
     */
    void setSize(int size) throws IllegalArgumentException;

    /**
     * Sprawdza czy dana lokacja jest na terenie gildi
     * @param loc lokalizacja
     * @return true/false
     */
    default boolean isInCuboid(Location loc) {
        return isInCuboid((int) loc.getX(), (int) loc.getZ());
    }

    /**
     * Sprawdza czy dana lokacja jest na terenie gildi
     * @param x x
     * @param z z
     * @return true/false
     */
    boolean isInCuboid(int x, int z);


}
