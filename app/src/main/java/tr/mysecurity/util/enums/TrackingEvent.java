package tr.mysecurity.util.enums;

/**
 * Created by user on 13.04.2016.
 */
public enum TrackingEvent {
    USER_LOGIN("Userr", "Login"),
    USER_LOGOUT("Userr", "Logout"),
    PING_SENT("Ping", "Sent");

    private String mCategory;
    private String mAction;

    TrackingEvent(String category, String action) {
        mCategory = category;
        mAction = action;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getAction() {
        return mAction;
    }
}
