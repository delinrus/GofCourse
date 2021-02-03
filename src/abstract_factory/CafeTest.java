package abstract_factory;

import abstract_factory.factories.AmericaFactory;
import abstract_factory.factories.JapaneseFactory;
import abstract_factory.factories.UkrainianFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CafeTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new JapaneseFactory(), "Sunomono", "Ramen", "Sushi", "GreenTee"},
                {new AmericaFactory(), "EggsSalad", "TomatoSoup", "LargeBurger", "Cola"},
                {new UkrainianFactory(), "Vinegret", "Shchi", "KievСutlet", "Kissel"}
        });
    }

    @Parameter()
    public DinnerFactory dinnerFactory;

    @Parameter(1)
    public String salad;

    @Parameter(2)
    public String soup;

    @Parameter(3)
    public String mainDish;

    @Parameter(4)
    public String drink;

    @Test
    public void test() {
        String expected = String.format("Served a dinner with %s as a salad, %s as a soup, " +
                "%s as a main dish, %s as a drink.", salad, soup, mainDish, drink);
        Cafe cafe = new Cafe(dinnerFactory);
        assertEquals(expected, cafe.cookDinner());
    }
}