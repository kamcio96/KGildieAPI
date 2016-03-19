package pl.kamcio96.kgildieapi.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import pl.kamcio96.kgildieapi.PlayerData;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class PlayerUpdateEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private final Player player;
    private final PlayerData playerData;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
