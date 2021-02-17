package decorator;

public class PizzaDecorator implements Pizza {

    private final Pizza wrappee;

    public PizzaDecorator(Pizza wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription();
    }
}
