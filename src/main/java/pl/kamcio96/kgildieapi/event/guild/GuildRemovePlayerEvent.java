package pl.kamcio96.kgildieapi.event.guild;

import lombok.*;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import pl.kamcio96.kgildieapi.Guild;
import pl.kamcio96.kgildieapi.PlayerData;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class GuildRemovePlayerEvent extends Event implements Cancellable {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    private final Guild guild;
    private final PlayerData playerData;

    @Getter
    @Setter
    private boolean cancelled = false;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
