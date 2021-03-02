package interpreter;

import command.AddPizzaComponentCommand;
import command.CommandFactory;
import command.Pizza;
import command.PizzaComponent;

public class NonTerminalExpression implements Expression {
    private final Expression expression;
    private final PizzaComponent component;
    private final Integer value;

    public NonTerminalExpression(Expression expression, PizzaComponent component, Integer value) {
        this.expression = expression;
        this.component = component;
        this.value = value;
    }

    @Override
    public Pizza interpret() {
        Pizza pizza = expression.interpret();
        AddPizzaComponentCommand command = CommandFactory.createCommand(pizza, component, value);
        if (command != null) {
            command.execute();
        }
        return pizza;
    }
}
