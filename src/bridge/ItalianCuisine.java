package bridge;

public class ItalianCuisine implements Cuisine {
    @Override
    public String getFirstDish() {
        return "Pasta";
    }

    @Override
    public String getSecondDish() {
        return "Pizza";
    }

    @Override
    public String getThirdDish() {
        return "Lasagne";
    }

    @Override
    public String getDessert() {
        return "Tiramisu";
    }
}
