package Exercise3;


public class EventType1 extends Event {
    private String eventType1;

    public EventType1(String eventName, String eventType1) {
        super(eventName);
        this.eventType1 = eventType1;
    }

    public String getEventType1() {
        return eventType1;
    }

    public void setEventType1(String eventType1) {
        this.eventType1 = eventType1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Event Type 1: " + eventType1;
    }
}