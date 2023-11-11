package Exercise3;

import java.util.ArrayList;


public class Agenda {
    private static final Agenda instance = new Agenda();
    private ArrayList<Object> elements = new ArrayList<>();

    private Agenda() {
    }

    public static Agenda getInstance() {
        return instance;
    }

    public void addElement(Object element) {
        elements.add(element);
    }

    public void removeElement(Object element) {
        elements.remove(element);
    }

    @Override
    public String toString() {
        StringBuilder agendaStr = new StringBuilder();
        for (Object element : elements) {
            agendaStr.append(element.toString()).append("\n");
        }
        return agendaStr.toString();
    }
}

