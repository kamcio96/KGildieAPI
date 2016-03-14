package pl.kamcio96.kgildieapi.event.guild;

import lombok.*;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import pl.kamcio96.kgildieapi.Guild;

@Data
@AllArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class GuildCreatedEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private final Guild guild;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
