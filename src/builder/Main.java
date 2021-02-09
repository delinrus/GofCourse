package builder;

import java.util.HashMap;
import java.util.Map;

import static builder.PizzaComponent.BACON;
import static builder.PizzaComponent.CHEESE;

public class Main {

    public static void main(String[] args) {
        Map<PizzaComponent, Integer> customMenu = new HashMap<>();

        customMenu.put(BACON, 100);
        customMenu.put(CHEESE, 200);

        Pizza.Builder builder = Pizza.newBuilder();
        customMenu.forEach(builder::addComponent);
        Pizza pizza = builder.build();
        System.out.println(pizza);
    }
}
