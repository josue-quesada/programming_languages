package Exercise3;

public class EventType1Factory implements EventFactory {
    @Override
    public Event createEvent(String eventName) {
        return new EventType1(eventName, "Default Event Type 1");
    }
}
