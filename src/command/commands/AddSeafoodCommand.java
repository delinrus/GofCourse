package command.commands;

import command.Pizza;
import command.AddPizzaComponentCommand;

public class AddSeafoodCommand extends AddPizzaComponentCommand {

    public AddSeafoodCommand(Pizza pizza, Integer value) {
        super(pizza, value);
    }

    @Override
    public void execute() {
        pizza.setSeafood(value);
    }
}
