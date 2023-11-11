package Exercise3;

public class EventType2Factory implements EventFactory {
    @Override
    public Event createEvent(String eventName) {
        return new EventType2(eventName, "Default Event Type 2");
    }
}