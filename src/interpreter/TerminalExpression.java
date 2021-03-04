package interpreter;

import command.AddPizzaComponentCommand;
import command.CommandFactory;
import command.Pizza;
import command.PizzaComponent;

public class TerminalExpression implements Expression {
    private final PizzaComponent component;
    private final Integer value;

    public TerminalExpression(PizzaComponent component, Integer value) {
        this.component = component;
        this.value = value;
    }

    @Override
    public void interpret(Pizza context) {
        AddPizzaComponentCommand command = CommandFactory.createCommand(context, component, value);
        if (command != null) {
            command.execute();
        }
    }
}
