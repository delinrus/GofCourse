package bridge;

public abstract class Cafe {
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

    public abstract String serve();
}
