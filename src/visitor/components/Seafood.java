package visitor.components;

import visitor.Component;
import visitor.Pizza;

public class Seafood extends Component {
    public Seafood(int value) {
        super(value);
    }

    @Override
    public void visit(Pizza pizza) {
        pizza.setSeafood(getValue());
    }
}
