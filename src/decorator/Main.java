package decorator;

import java.util.Arrays;
import java.util.List;

import static decorator.PizzaComponent.MUSHROOMS;
import static decorator.PizzaComponent.SEAFOOD;

public class Main {

    public static void main(String[] args) {
        List<PizzaComponent> componentList = Arrays.asList(MUSHROOMS, SEAFOOD);
        Pizza pizza = PizzaBuilder.build(componentList);
        System.out.println(pizza.getDescription());
    }
}
