package command.commands;

import command.Pizza;
import command.AddPizzaComponentCommand;

public class AddPineapplesCommand extends AddPizzaComponentCommand {

    public AddPineapplesCommand(Pizza pizza, Integer value) {
        super(pizza, value);
    }

    @Override
    public void execute() {
        pizza.setPineapples(value);
    }
}
