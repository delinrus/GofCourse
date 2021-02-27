package command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    List<AddPizzaComponentCommand> commandList = new ArrayList<>();

    public void execute() {
        commandList.forEach(AddPizzaComponentCommand::execute);
    }

    public void addCommand(AddPizzaComponentCommand command) {
        if (command != null) {
            commandList.add(command);
        }
    }
}
