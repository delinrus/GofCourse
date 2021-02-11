package adapter;

public class MyClassAdapter implements MyClass {
    private final МойКлас myClass;

    public MyClassAdapter(МойКлас myClass) {
        this.myClass = myClass;
    }

    @Override
    public String initialize() {
        return myClass.инициализировать();
    }

    @Override
    public String action() {
        return myClass.действие();
    }
}
