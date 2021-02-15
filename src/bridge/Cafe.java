package bridge;

public class Cafe {
    protected Cuisine cuisine;

    public Cafe(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public String serveComplexDinner() {
        return "The complex dinner of " + cuisine.getFirstDish() + ", " + cuisine.getSecondDish() + ", " +
                cuisine.getThirdDish() + ", and " + cuisine.getDessert() + " have been served";
    }
}
