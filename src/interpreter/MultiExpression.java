package interpreter;

import command.Pizza;

import java.util.ArrayList;
import java.util.List;

public class MultiExpression implements Expression {

    List<Expression> expressions = new ArrayList<>();

    @Override
    public void interpret(Pizza context) {
        expressions.forEach(e -> e.interpret(context));
    }

    void add(Expression expression) {
        expressions.add(expression);
    }
}
