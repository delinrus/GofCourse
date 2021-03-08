package visitor.components;

import visitor.Component;
import visitor.Visitor;

public class Pineapples extends Component {
    public Pineapples(int value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
