package visitor.components;

import visitor.Component;
import visitor.Pizza;

public class Pineapples extends Component {
    public Pineapples(int value) {
        super(value);
    }


    @Override
    public void visit(Pizza pizza) {
        pizza.setPineapples(getValue());
    }
}
