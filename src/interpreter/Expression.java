package interpreter;

import command.Pizza;

public interface Expression {
    void interpret(Pizza context);
}
