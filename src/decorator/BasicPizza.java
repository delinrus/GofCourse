package decorator;

public class BasicPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Pizza containing:";
    }
}
