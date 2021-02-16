package bridge;

public class ComplexCafe extends Cafe {

    public ComplexCafe(Cuisine cuisine) {
        super(cuisine);
    }

    @Override
    public String serve() {
        return "The complex dinner of " + cuisine.getFirstDish() + ", " + cuisine.getSecondDish() + ", " +
                cuisine.getThirdDish() + ", and " + cuisine.getDessert() + " have been served";
    }
}
