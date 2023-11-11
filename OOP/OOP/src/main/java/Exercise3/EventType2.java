package Exercise3;

public class EventType2 extends Event {
    private String eventType2;

    public EventType2(String eventName, String eventType2) {
        super(eventName);
        this.eventType2 = eventType2;
    }

    public String getEventType2() {
        return eventType2;
    }

    public void setEventType2(String eventType2) {
        this.eventType2 = eventType2;
    }

    @Override
    public String toString() {
        return super.toString() + ", Event Type 2: " + eventType2;
    }
}