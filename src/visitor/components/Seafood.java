package visitor.components;

import visitor.Component;
import visitor.Visitor;

public class Seafood extends Component {
    public Seafood(int value) {
        super(value);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
