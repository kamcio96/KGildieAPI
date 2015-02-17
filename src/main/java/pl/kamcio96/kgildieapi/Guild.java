package pl.kamcio96.kgildieapi;

import com.google.common.base.Optional;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;

/**
 * Gildia
 * @author kamcio96
 */
public interface Guild {

    /**
     * Zwraca tag gildi
     * @return String tag gildi
     */
    public String getTag();

    /**
     * Zwraca opis gildi
     * @return String opis
     */
    public String getDescription();

    /**
     * Ustawia opis gildi
     * @param desc opis
     */
    public String setDescription(String desc) throws IllegalArgumentException;

    /**
     * Zwraca świat gildi
     * @return org.bukkit.World świat
     */
    public World getWorld();

    /**
     * Zwraca współrzędną x srodka gildi
     * @return int X
     */
    public int getCenterX();

    /**
     * Zwraca współrzędną z srodka gildi
     * @return int Z
     */
    public int getCenterZ();

    /**
     * Zwraca rozmiar gildi
     * @return int rozmiar
     */
    public int getSize();

    /**
     * Ustawia rozmiar gildi
     * @param size nowy rozmiar gildi
     * @throws IllegalArgumentException gdy size jest mniejszy od 0
     */
    public void setSize(int size) throws IllegalArgumentException;

    /**
     * Sprawdza czy dana lokacja jest na terenie gildi
     * @param loc
     * @return true/false
     */
    public boolean isInCuboid(Location loc);

    /**
     * Zwraca czas utworzenia gildi
     * @return long
     */
    public long getCreateTime();

    /**
     * Zwraca czas wygaśniecia gildi. 0 dla nie wygasającej gildi
     * @return long czas
     */
    public long getExpireTime();

    /**
     * Ustawia czas wygaśniecia gildi. 0 dla nie wygasającej gildi
     * @param time czas
     */
    public void setExpireTime(long time);

    /**
     * Zwraca czas ostatniego wybuchu na terenie gildi. 0 dla braku od uruchomienia pluginu
     * @return long czas
     */
    public long getLastExplode();

    /**
     * Ustawia czas ostatniego wybuchu na terenie gildi. 0 dla braku od uruchomienia pluginu
     * @param explode czas
     */
    public void setLastExplode(long explode);

    /**
     * Zwraca dom gildi, o ile istnieje
     * @return home
     */
    public Optional<Location> getHome();

    /**
     * Ustawia dom gildi.
     * @param loc lokalizacja
     * @throws IllegalArgumentException gdy loc nie jest na terenie gildi
     */
    public void setHome(Location loc) throws IllegalArgumentException;

    /**
     * Zwraca czy pvp w gildi jest wlaczone
     * @return pvp
     */
    public boolean isPvp();

    /**
     * Ustawia czy w gildi ma byc wlaczone pvp
     * @param pvp pvp
     */
    public void setPvp(boolean pvp);

    /**
     * Zwraca graczy online z gildi
     * @return List&lt;Player&gt; gracze online
     */
    public List<Player> getOnlinePlayers();

    /**
     * Zwraca kontroler graczy w gildi
     * @return GuildPlayers
     * @see pl.kamcio96.kgildieapi.GuildPlayers
     */
    public GuildPlayers getPlayers();

    /**
     * Zwraca schowek gildijny, o ile istnieje
     * @return Optional
     */
    public Optional<Inventory> getGuildChest();

}
