package interpreter;

import command.Pizza;

public class TerminalExpression implements Expression {

    @Override
    public Pizza interpret() {
        return new Pizza();
    }
}
