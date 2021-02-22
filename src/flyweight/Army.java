package flyweight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Unit> unitList = new ArrayList<>();

    public void move(int x, int y) {
        if (unitList.isEmpty()) {
            return;
        }
        int avrX = (int) unitList.stream().mapToInt(Unit::getX).average().getAsDouble();
        int avrY = (int) unitList.stream().mapToInt(Unit::getY).average().getAsDouble();

        int dx = x - avrX;
        int dy = y - avrY;

        unitList.forEach(u -> u.move(u.getX() + dx, u.getY() + dy));
    }

    public void add(Unit unit) {
        unitList.add(unit);
    }

    public void remove(Unit unit) {
        unitList.remove(unit);
    }

    public void draw(Component c, Graphics g) {
        unitList.forEach(unit -> unit.draw(c, g));
    }

    public void poll() {
        unitList.forEach(Unit::poll);
    }
}
