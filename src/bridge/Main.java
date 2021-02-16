package bridge;

public class Main {

    public static void main(String[] args) {
        Cafe cafe = new ComplexCafe(new ItalianCuisine());
        System.out.println(cafe.serve());

        DessertCafe desertCafe = new DessertCafe(new AmericanCuisine());
        System.out.println(desertCafe.serve());
    }
}
