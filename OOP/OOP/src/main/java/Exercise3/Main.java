package Exercise3;

public class Main {
    public static void main(String[] args) {
        
        Agenda agenda = Agenda.getInstance();

        ContactFactory contactFactory;
        EventFactory eventFactory;

        contactFactory = new ContactType1Factory();
        Contact contactType1 = contactFactory.createContact("Sam", "Valley");
        agenda.addElement(contactType1);

        contactFactory = new ContactType2Factory();
        Contact contactType2 = contactFactory.createContact("Some", "One");
        agenda.addElement(contactType2);

        eventFactory = new EventType1Factory();
        Event eventType1 = eventFactory.createEvent("Work Meeting");
        agenda.addElement(eventType1);

        eventFactory = new EventType2Factory();
        Event eventType2 = eventFactory.createEvent("Wedding");
        agenda.addElement(eventType2);

        System.out.println(agenda);
    }
}

