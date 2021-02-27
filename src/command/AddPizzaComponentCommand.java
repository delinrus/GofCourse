package command;

public abstract class AddPizzaComponentCommand implements Command {

    protected Pizza pizza;
    protected Integer value;


    public AddPizzaComponentCommand(Pizza pizza, Integer value) {
        this.pizza = pizza;
        this.value = value;
    }

    public abstract void execute();
}
