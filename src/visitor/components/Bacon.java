package visitor.components;

import visitor.Component;
import visitor.Visitor;

public class Bacon extends Component {
    public Bacon(int value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
