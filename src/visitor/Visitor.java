package visitor;

import visitor.components.*;

public interface Visitor {
    void visit(Bacon bacon);
    void visit(Cheese cheese);
    void visit(Mushrooms mushrooms);
    void visit(Pineapples pineapples);
    void visit(Seafood seafood);
}
