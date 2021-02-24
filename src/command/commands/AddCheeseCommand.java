package command.commands;

import command.Pizza;
import command.AddPizzaComponentCommand;

public class AddCheeseCommand extends AddPizzaComponentCommand {

    public AddCheeseCommand(Pizza pizza, Integer value) {
        super(pizza, value);
    }

    @Override
    public void execute() {
        pizza.setCheese(value);
    }
}
