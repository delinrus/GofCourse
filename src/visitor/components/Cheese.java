package visitor.components;

import visitor.Component;
import visitor.Visitor;

public class Cheese extends Component {
    public Cheese(int value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
