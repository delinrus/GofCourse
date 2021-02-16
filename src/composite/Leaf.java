package composite;

public class Leaf implements Component {

    private int value;

    public Leaf(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void increment() {
        value++;
    }

    @Override
    public void decrement() {
        value--;
    }
}
