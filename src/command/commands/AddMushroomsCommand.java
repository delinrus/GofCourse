package command.commands;

import command.Pizza;
import command.AddPizzaComponentCommand;

public class AddMushroomsCommand extends AddPizzaComponentCommand {

    public AddMushroomsCommand(Pizza pizza, Integer value) {
        super(pizza, value);
    }

    @Override
    public void execute() {
        pizza.setMushrooms(value);
    }
}
