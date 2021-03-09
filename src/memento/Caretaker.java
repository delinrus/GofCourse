package memento;

import java.util.Vector;

public class Caretaker {
    private final Vector<Memento> snapshots = new Vector<>();

    public Vector<Memento> getSnapshots() {
        return snapshots;
    }

    public void addSnapshot(Memento memento) {
        snapshots.add(memento);
    }
}
