package pl.kamcio96.kgildieapi.visible;

import pl.kamcio96.kgildieapi.GuildPlayer;
import pl.kamcio96.kgildieapi.PlayerData;

import java.util.Optional;

public interface VisibleContext {
    PlayerData getPlayerData();

    PlayerData getNamedPlayerData();

    GuildPlayer getGuildPlayer();

    GuildPlayer getNamedGuildPlayer();

    void setPrefix(String prefix);

    void setSuffix(String suffix);

    /**
     * Zwraca prefix ktory ma być ustawiony
     * @return prefix
     */
    Optional<String> getPrefix();

    /**
     * Zwraca suffix ktory ma być ustawiony
     * @return prefix
     */
    Optional<String> getSuffix();
}
