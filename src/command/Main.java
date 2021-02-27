package command;

import java.util.HashMap;
import java.util.Map;

import static command.PizzaComponent.*;


public class Main {

    public static void main(String[] args) {
        Map<PizzaComponent, Integer> customMenu = new HashMap<>();

        customMenu.put(BACON, 100);
        customMenu.put(CHEESE, 200);

        Pizza pizza = new Pizza();
        Invoker invoker = new Invoker();

        for (Map.Entry<PizzaComponent, Integer> entry : customMenu.entrySet()) {
            AddPizzaComponentCommand command = CommandFactory.createCommand(pizza, entry.getKey(), entry.getValue());
            invoker.addCommand(command);
        }
        invoker.execute();
        System.out.println(pizza);
    }
}
