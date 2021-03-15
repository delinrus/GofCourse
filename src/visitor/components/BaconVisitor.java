package visitor.components;

import visitor.Component;
import visitor.Pizza;

public class BaconVisitor extends Component {
    public BaconVisitor(int value) {
        super(value);
    }

    @Override
    public void visit(Pizza pizza) {
        pizza.setBacon(getValue());
    }
}
