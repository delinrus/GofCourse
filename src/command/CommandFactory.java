package command;

import command.commands.*;

import java.util.HashMap;
import java.util.Map;

import static command.PizzaComponent.*;


public class CommandFactory {

    private static final Map<PizzaComponent, CommandConstructor> commandMap = new HashMap<>();

    static {
        commandMap.put(CHEESE, AddCheeseCommand::new);
        commandMap.put(BACON, AddBaconCommand::new);
        commandMap.put(PINEAPPLES, AddPineapplesCommand::new);
        commandMap.put(MUSHROOMS, AddMushroomsCommand::new);
        commandMap.put(SEAFOOD, AddSeafoodCommand::new);
    }

    public static AddPizzaComponentCommand createCommand(Pizza pizza, PizzaComponent pizzaComponent, Integer value) {
        CommandConstructor commandConstructor = commandMap.get(pizzaComponent);
        if (commandConstructor == null) {
            return null;
        }
        return commandConstructor.invoke(pizza, value);
    }

    private interface CommandConstructor {
        AddPizzaComponentCommand invoke(Pizza pizza, Integer value);
    }

}
