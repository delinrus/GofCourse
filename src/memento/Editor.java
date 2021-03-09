package memento;

import javax.swing.*;

public class Editor extends JTextArea {

    public Memento makeSnapshot(String name) {
        return new Snapshot(name, getText());
    }

    private class Snapshot implements Memento {
        private final String text;
        private final String name;

        @Override
        public String toString() {
            return name;
        }

        public Snapshot(String name, String text) {
            this.name = name;
            this.text = text;
        }

        @Override
        public void restore() {
            Editor.this.setText(text);
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
