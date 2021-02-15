package bridge;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;

@RunWith(Parameterized.class)
public abstract class BasicCafeTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new AmericanCuisine(), "Cheeseburger", "Delmonico's steak", "Nachos", "Apple pie"},
                {new ItalianCuisine(), "Pasta", "Pizza", "Lasagne", "Tiramisu"},
                {new ChineseCuisine(), "Dumplings", "White rise", "Beijing duck", "Bing"}
        });
    }

    @Parameter()
    public Cuisine cuisine;

    @Parameter(1)
    public String firstDish;

    @Parameter(2)
    public String secondDish;

    @Parameter(3)
    public String thirdDish;

    @Parameter(4)
    public String dessert;
}
