package decorator;

import java.util.List;

public class PizzaBuilder {

    public static Pizza build(List<PizzaComponent> componentList) {
        Pizza pizza = new BasicPizza();
        if (componentList == null) {
            return pizza;
        }
        for(PizzaComponent component : componentList) {
            pizza = new IngredientDecorator(pizza, component.toString());
        }
        return pizza;
    }
}
