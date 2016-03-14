package pl.kamcio96.kgildieapi;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Gildia
 * @author kamcio96
 */
public interface Guild {

    /**
     * Zwraca tag gildi
     * @return String tag gildi
     */
    String getTag();

    /**
     * Zwraca opis gildi
     * @return String opis
     */
    String getDescription();

    /**
     * Ustawia opis gildi
     * @param desc opis
     */
    void setDescription(String desc);

    /*==========================================*/

    /**
     * Zwraca czas utworzenia gildi
     * @return long
     */
    long getCreateTime();

    /**
     * Zwraca czas wygaśniecia gildi. 0 dla nie wygasającej gildi
     * @return long czas
     */
    long getExpireTime();

    /**
     * Ustawia czas wygaśniecia gildi. 0 dla nie wygasającej gildi
     * @param time czas
     */
    void setExpireTime(long time);

    /**
     * Zwraca czas ostatniego wybuchu na terenie gildi. 0 dla braku od uruchomienia pluginu
     * @return long czas
     */
    long getLastExplode();

    /**
     * Ustawia czas ostatniego wybuchu na terenie gildi. 0 dla braku od uruchomienia pluginu
     * @param explode czas
     */
    void setLastExplode(long explode);

    /*==========================================*/

    /**
     * Zwraca teren gildi
     * @return area
     */
    GuildArea getArea();

    /*==========================================*/

    /**
     * Zwraca dom gildi, o ile istnieje
     * @return home
     */
    Optional<Location> getHome();

    /**
     * Ustawia dom gildi.
     * @param loc lokalizacja
     * @throws IllegalArgumentException gdy loc nie jest na terenie gildi
     */
    void setHome(Location loc) throws IllegalArgumentException;

    /**
     * Zwraca czy pvp w gildi jest wlaczone
     * @return pvp
     */
    boolean isPvp();

    /**
     * Ustawia czy w gildi ma byc wlaczone pvp
     * @param pvp pvp
     */
    void setPvp(boolean pvp);

    /**
     * Zwraca schowek gildijny, o ile istnieje
     * @return Optional
     */
    Optional<Inventory> getGuildChest();

    /*================================================*/

    default boolean isMember(PlayerData player){
        return isMember(player.getUniqueId());
    }

    default boolean isMember(Player player){
        return isMember(player.getUniqueId());
    }

    boolean isMember(UUID player);

    Optional<GuildPlayer> addPlayer(PlayerData player);

    boolean removePlayer(GuildPlayer player);

    default Optional<GuildPlayer> getPlayer(Player player) {
        return getPlayer(player.getUniqueId());
    }

    default Optional<GuildPlayer> getPlayer(PlayerData player) {
        return getPlayer(player.getUniqueId());
    }

    Optional<GuildPlayer> getPlayer(UUID player);

    Set<GuildPlayer> getPlayers();

    void broadcast(String... messages);

    /**
     * Zwraca graczy online z gildi
     * @return Set&lt;GuildPlayer&gt; gracze online
     */
    Set<Player> getOnlinePlayers();

    int getMaxPlayers();

    /*================================================*/

    Set<Guild> getAlliances();

    boolean hasAlliance(Guild other);

    void addAlliance(Guild other);

    void removeAlliance(Guild other);

    /*================================================*/

    void setPreDelete(boolean bool);

    boolean getPreDelete();

    /*================================================*/

    void addInvite(UUID uid);

    boolean hasInvite(UUID uid);

    void removeInvite(UUID uid);

    int getGuildPoints();

    int getGuildKills();

    int getGuildDeaths();

    /*================================================*/

    boolean canTakeover();

    long getTakeoverTime();

    void setTakeoverTime(long takeoverTime);

    void setTakeover(int takeover);

    int getTakeover();

    /*================================================*/

    static Builder builder() {
        return KGildieAPI.guildBuilder();
    }

    interface Builder {

        Builder tag(String tag);

        Builder name(String name);

        Builder creator(Player player);

        Guild build();
    }
}
