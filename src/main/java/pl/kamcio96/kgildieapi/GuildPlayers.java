package pl.kamcio96.kgildieapi;

import java.util.List;
import java.util.UUID;

/**
 * Widok graczy w gildi
 * @author kamcio96
 */
public interface GuildPlayers {

    //TODO javadocs

    public List<UUID> getPlayers();

    public boolean hasPlayer(PlayerData player);

    public boolean addPlayer(PlayerData player);

    public boolean removePlayer(PlayerData player);

    public boolean isInvite(PlayerData player);

    public boolean addInvite(PlayerData player);

    public boolean removeInvite(PlayerData player);

    public PlayerData getLeader();

    public PlayerData getOwner();

    public void setOwner(PlayerData player);

    public void setLeader(PlayerData player);

    public boolean isOwner(PlayerData player);

    public boolean isLeader(PlayerData player);

}
