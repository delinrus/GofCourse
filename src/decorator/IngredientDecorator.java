package decorator;

public class IngredientDecorator extends PizzaDecorator {

    private final String ingredient;

    public IngredientDecorator(Pizza wrappee, String ingredient) {
        super(wrappee);
        this.ingredient = ingredient;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + ingredient + ";";
    }
}
