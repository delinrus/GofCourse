package command.commands;

import command.Pizza;
import command.AddPizzaComponentCommand;

public class AddBaconCommand extends AddPizzaComponentCommand {

    public AddBaconCommand(Pizza pizza, Integer value) {
        super(pizza, value);
    }

    @Override
    public void execute() {
        pizza.setBacon(value);
    }
}
