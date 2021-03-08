package visitor.components;

import visitor.Component;
import visitor.Visitor;

public class Mushrooms extends Component {
    public Mushrooms(int value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
