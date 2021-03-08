package visitor;

public abstract class Component {
    private int value;

    public Component(int value) {
        this.value = value;
    }

    public abstract void accept(Visitor visitor);

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
