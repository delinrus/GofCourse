package command;

public class Pizza {
    private int cheese;
    private int bacon;
    private int pineapples;
    private int mushrooms;
    private int seafood;


    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public void setPineapples(int pineapples) {
        this.pineapples = pineapples;
    }

    public void setMushrooms(int mushrooms) {
        this.mushrooms = mushrooms;
    }

    public void setSeafood(int seafood) {
        this.seafood = seafood;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "cheese=" + cheese +
                ", bacon=" + bacon +
                ", pineapples=" + pineapples +
                ", mushrooms=" + mushrooms +
                ", seafood=" + seafood +
                '}';
    }
}