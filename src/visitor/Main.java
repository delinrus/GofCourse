package visitor;

import visitor.components.Bacon;
import visitor.components.Cheese;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();

        Component bacon = new Bacon(160);
        Component cheese = new Cheese(200);
        List<Component> componentList = new ArrayList<>();
        componentList.add(bacon);
        componentList.add(cheese);

        Visitor pizzaVisitor = new AddComponentVisitor(pizza);
        componentList.forEach( component -> component.accept(pizzaVisitor));
        System.out.println(pizza);
    }
}
