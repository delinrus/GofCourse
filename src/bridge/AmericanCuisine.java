package bridge;

public class AmericanCuisine implements Cuisine {
    @Override
    public String getFirstDish() {
        return "Cheeseburger";
    }

    @Override
    public String getSecondDish() {
        return "Delmonico's steak";
    }

    @Override
    public String getThirdDish() {
        return "Nachos";
    }

    @Override
    public String getDessert() {
        return "Apple pie";
    }
}
