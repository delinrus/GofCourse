package adapter;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClassAdapter(new МойКлас());
        System.out.println(myClass.initialize());
        System.out.println(myClass.action());
    }
}
