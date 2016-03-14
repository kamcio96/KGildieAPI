package pl.kamcio96.kgildieapi.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class GuildTopUpdateEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
