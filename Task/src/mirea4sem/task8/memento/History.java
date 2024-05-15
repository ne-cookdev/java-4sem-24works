package mirea4sem.task8.memento;

import java.util.ArrayList;
import java.util.List;

// Caretaker
class History {
    private final List<Memento> states = new ArrayList<>();

    public void addMemento(Memento memento) {
        states.add(memento);
    }

    public Memento getMemento(int index) {
        return states.get(index);
    }
}
