package pl.kamcio96.kgildieapi;

import java.util.UUID;

public interface GuildPlayer extends GuildHolder {

    default UUID getUniqueId() {
        return getPlayerData().getUniqueId();
    }

    PlayerData getPlayerData();

    void setMember();

    boolean isLeader();

    void setLeader();

    boolean isOwner();

    void setOwner();
}
