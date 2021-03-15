package visitor.components;

import visitor.Component;
import visitor.Pizza;

public class Mushrooms extends Component {
    public Mushrooms(int value) {
        super(value);
    }

    @Override
    public void visit(Pizza pizza) {
        pizza.setMushrooms(getValue());
    }
}
