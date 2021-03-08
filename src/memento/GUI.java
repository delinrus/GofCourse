package memento;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private final JFrame frame = new JFrame("Editor");
    private final Editor editor = new Editor();
    private final Caretaker caretaker = new Caretaker();

    public void init() {
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        editor.setLineWrap(true);
        content.add(editor);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton save = new JButton("save");
        save.addActionListener(e -> {
            SaveDialog saveDialog = new SaveDialog();
            saveDialog.setVisible(true);
        });
        save.setPreferredSize(new Dimension(85, 25));

        JButton load = new JButton("load");
        load.addActionListener(e -> {
            LoadDialog loadDialog = new LoadDialog();
            loadDialog.setVisible(true);
        });
        load.setPreferredSize(new Dimension(85, 25));
        buttons.add(save);
        buttons.add(load);
        content.add(buttons);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class SaveDialog extends JDialog {
        public SaveDialog() {
            super(GUI.this.frame, "Save Dialog", true);
            JTextField newRecord = new JTextField();
            add(newRecord, BorderLayout.NORTH);
            JButton save = new JButton("save");
            JDialog self = this;
            save.addActionListener(e -> {
                newRecord.getText();
                caretaker.addSnapshot(editor.makeSnapshot(newRecord.getText()));
                self.dispose();
            });
            add(save, BorderLayout.SOUTH);
            setBounds(500, 500, 250, 150);
        }
    }

    class LoadDialog extends JDialog {
        public LoadDialog() {
            super(frame, "Load Dialog", true);
            JList<Memento> list = new JList<>(caretaker.getSnapshots());
            add(list);
            JButton confirm = new JButton("load");
            JDialog self = this;
            confirm.addActionListener(e -> {
                list.getSelectedValue().restore();
                self.dispose();
            });
            add(confirm, BorderLayout.SOUTH);
            setBounds(500, 500, 250, 150);
        }
    }
}
