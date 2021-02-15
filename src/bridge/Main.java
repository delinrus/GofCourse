package bridge;

public class Main {

    public static void main(String[] args) {
        Cafe cafe = new Cafe(new ItalianCuisine());
        System.out.println(cafe.serveComplexDinner());

        SelectiveCafe selectiveCafe = new SelectiveCafe(new AmericanCuisine());
        System.out.println(selectiveCafe.serveOnlyDesert());
    }
}
