package flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static flyweight.UnitTypeName.HORSEMAN;
import static flyweight.UnitTypeName.INFANTRYMAN;

public class UnitType {

    private static final Map<UnitTypeName, UnitType> unitTypes = new HashMap<>();
    private UnitTypeName unitTypeName;
    private final Icon texture;
    private final int speed;

    static {
        unitTypes.put(INFANTRYMAN, new UnitType(INFANTRYMAN, new ImageIcon("src/flyweight/infantryman.png"), 3));
        unitTypes.put(HORSEMAN, new UnitType(HORSEMAN, new ImageIcon("src/flyweight/horseman.png"), 4));
    }

    private UnitType(UnitTypeName unitTypeName, Icon texture, int speed) {
        this.unitTypeName = unitTypeName;
        this.texture = texture;
        this.speed = speed;
    }

    public static UnitType getInstance(UnitTypeName unitTypeName) {
        return unitTypes.get(unitTypeName);
    }

    public void draw(Component c, Graphics g, int x, int y) {
        texture.paintIcon(c, g, x, y);
    }

    public int getSpeed() {
        return speed;
    }

    public UnitTypeName getUnitTypeName() {
        return unitTypeName;
    }
}
