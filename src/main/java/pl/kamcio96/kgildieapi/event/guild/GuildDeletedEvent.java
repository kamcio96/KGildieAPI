package pl.kamcio96.kgildieapi.event.guild;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import pl.kamcio96.kgildieapi.DeleteReason;
import pl.kamcio96.kgildieapi.Guild;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class GuildDeletedEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private final Guild guild;
    private final DeleteReason reason;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
