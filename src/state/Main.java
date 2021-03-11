package state;

public class Main {
    public static void main(String[] args) throws Exception {
        Oven oven = new Oven(220);
        oven.bake();
        System.out.println(oven.isBaking());

        oven.setTemperature(260);
        oven.bake();
    }
}
