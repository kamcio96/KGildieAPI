package pl.kamcio96.kgildieapi.event;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerKillByPlayerEvent extends PlayerEvent {

    @Getter
    private static HandlerList handlerList = new HandlerList();

    @Getter
    private Player killer;

    public PlayerKillByPlayerEvent(Player who, Player killer) {
        super(who);
        this.killer = killer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}
