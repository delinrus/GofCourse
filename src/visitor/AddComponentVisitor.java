package visitor;

import visitor.components.*;

public class AddComponentVisitor implements Visitor {
    private final Pizza pizza;

    public AddComponentVisitor(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void visit(Bacon bacon) {
        pizza.setBacon(bacon.getValue());
    }

    @Override
    public void visit(Cheese cheese) {
        pizza.setCheese(cheese.getValue());
    }

    @Override
    public void visit(Mushrooms mushrooms) {
        pizza.setMushrooms(mushrooms.getValue());
    }

    @Override
    public void visit(Pineapples pineapples) {
        pizza.setPineapples(pineapples.getValue());
    }

    @Override
    public void visit(Seafood seafood) {
        pizza.setSeafood(seafood.getValue());
    }
}
