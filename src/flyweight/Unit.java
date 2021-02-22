package flyweight;

import java.awt.*;

public class Unit {

    private int x;
    private int y;
    private int destX;
    private int destY;
    private final UnitType unitType;

    public Unit(int x, int y, UnitTypeName unitTypeName) {
        this.x = x;
        this.y = y;
        this.destX = x;
        this.destY = y;
        unitType = UnitType.getInstance(unitTypeName);
    }

    public void move(int x, int y) {
        this.destX = x;
        this.destY = y;
    }

    public void draw(Component c, Graphics g) {
        unitType.draw(c, g, x, y);
    }

    public void poll() {
        int speed = unitType.getSpeed();

        if (Math.abs(x - destX) > speed) {
            if (x < destX) {
                x += speed;
            } else {
                x -= speed;
            }
        }

        if (Math.abs(y - destY) > speed) {
            if (y < destY) {
                y += speed;
            } else {
                y -= speed;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
