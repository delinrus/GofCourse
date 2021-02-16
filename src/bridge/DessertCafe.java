package bridge;

public class DessertCafe extends Cafe {

    public DessertCafe(Cuisine cuisine) {
        super(cuisine);
    }

    @Override
    public String serve() {
        return "The " + cuisine.getDessert() + " have been served as a dessert";
    }
}
