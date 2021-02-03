package factory_method;

import java.util.Map;
import java.util.function.Supplier;

import static factory_method.FoodType.*;

public class BakeableFactory {

    private static final Map<FoodType, Supplier<Bakeable>> factoryMap = Map.of(
            PIZZA, Pizza::new,
            FISH, Fish::new,
            COOKIES, Cookies::new,
            CAKE, Cake::new
    );

    public static Bakeable create(FoodType foodType) {
        if (foodType == null) {
            return new NothingToBake();
        }
        Supplier<Bakeable> factory = factoryMap.get(foodType);
        if (factory == null) {
            return new NothingToBake();
        }
        return factory.get();
    }
}
