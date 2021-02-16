package composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private int value;
    private final List<Component> children = new ArrayList<>();

    public Composite(int value) {
        this.value = value;
    }

    public void add(Component c) {
        children.add(c);
    }

    public void remove(Component c) {
        children.remove(c);
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void increment() {
        value++;
        children.forEach(Component::increment);
    }

    @Override
    public void decrement() {
        value--;
        children.forEach(Component::decrement);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
