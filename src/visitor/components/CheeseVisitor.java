package visitor.components;

import visitor.Component;
import visitor.Pizza;

public class CheeseVisitor extends Component {
    public CheeseVisitor(int value) {
        super(value);
    }

    @Override
    public void visit(Pizza pizza) {
        pizza.setCheese(getValue());
    }
}
