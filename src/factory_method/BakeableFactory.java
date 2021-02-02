package factory_method;

public class BakeableFactory {
    static Bakeable create(FoodType foodType) {
        if (foodType != null) {
            switch (foodType) {
                case PIZZA:
                    return new Pizza();
                case FISH:
                    return new Fish();
                case COOKIES:
                    return new Cookies();
                case CAKE:
                    return new Cake();
            }
        }
        return new NothingToBake();
    }
}
