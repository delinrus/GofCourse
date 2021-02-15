package bridge;

public class SelectiveCafe extends Cafe {

    public SelectiveCafe(Cuisine cuisine) {
        super(cuisine);
    }

    String serveOnlyDesert() {
        return "The " + cuisine.getDessert() + " have been served as a dessert";
    }
}
