package factory_method;

public class Main {
    public static void main(String[] args) {
        Oven oven = new Oven();
        oven.bake(FoodType.PIZZA);
        oven.bake(FoodType.FISH);
        oven.bake(null);
    }
}
