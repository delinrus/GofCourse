package flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static flyweight.UnitTypeName.HORSEMAN;
import static flyweight.UnitTypeName.INFANTRYMAN;

public class Game extends JPanel {
    Army army = new Army();

    {
        army.add(new Unit(20, 100, INFANTRYMAN));
        army.add(new Unit(50, 100, INFANTRYMAN));
        army.add(new Unit(100, 100, HORSEMAN));

        MouseAdapter moveCommand = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON3) {
                    return;
                }
                army.move(e.getX(), e.getY());
                repaint();
            }
        };
        addMouseListener(moveCommand);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Strategy game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.army.poll();
            game.repaint();
            Thread.sleep(10);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        army.draw(this, g);
    }
}