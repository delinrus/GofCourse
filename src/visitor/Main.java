package visitor;

import visitor.components.BaconVisitor;
import visitor.components.CheeseVisitor;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        Component bacon = new BaconVisitor(160);
        Component cheese = new CheeseVisitor(200);
        pizza.addComponent(bacon);
        pizza.addComponent(cheese);
        pizza.cook();
        System.out.println(pizza);
    }
}
