package Exercise3;

public abstract class Event {
    private String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Event Name: " + eventName;
    }
}