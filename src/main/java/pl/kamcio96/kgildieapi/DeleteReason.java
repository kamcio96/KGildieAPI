package pl.kamcio96.kgildieapi;

public interface DeleteReason {

    DeleteReason DELETED = null;
    DeleteReason TIME_EXPIRE = null;
    DeleteReason BANNED = null;
    DeleteReason MAX_TAKEOVER = null;

    int getRaw();
}
