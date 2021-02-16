package bridge;

public class ChineseCuisine implements Cuisine {
    @Override
    public String getFirstDish() {
        return "Dumplings";
    }

    @Override
    public String getSecondDish() {
        return "White rise";
    }

    @Override
    public String getThirdDish() {
        return "Beijing duck";
    }

    @Override
    public String getDessert() {
        return "Bing";
    }
}
