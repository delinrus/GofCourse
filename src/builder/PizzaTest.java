package builder;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static builder.PizzaComponent.*;
import static org.junit.Assert.assertEquals;

public class PizzaTest {

    private Map<PizzaComponent, Integer> customMenu;

    @Before
    public void setUp() {
        customMenu = new HashMap<>();
    }

    private void testHelper(String expected) {
        Pizza.Builder builder = Pizza.newBuilder();
        customMenu.forEach(builder::addComponent);
        Pizza pizza = builder.build();
        assertEquals(expected, pizza.toString());
    }

    @Test
    public void addFewComponents() {
        customMenu.put(BACON, 100);
        customMenu.put(CHEESE, 200);
        testHelper("Pizza{cheese=200, bacon=100, pineapples=0, mushrooms=0, seafood=0}");
    }

    @Test
    public void addNone() {
        testHelper("Pizza{cheese=0, bacon=0, pineapples=0, mushrooms=0, seafood=0}");
    }

    @Test
    public void addNull() {
        customMenu.put(null, 100);
        testHelper("Pizza{cheese=0, bacon=0, pineapples=0, mushrooms=0, seafood=0}");
    }

    @Test
    public void addAllComponents() {
        customMenu.put(CHEESE, 100);
        customMenu.put(BACON, 150);
        customMenu.put(PINEAPPLES, 300);
        customMenu.put(MUSHROOMS, 120);
        customMenu.put(SEAFOOD, 180);
        testHelper("Pizza{cheese=100, bacon=150, pineapples=300, mushrooms=120, seafood=180}");
    }

    @Test
    public void sequentialBuild() {
        Pizza pizzaWithBacon = Pizza.newBuilder()
                .withBacon(200)
                .withCheese(100)
                .build();

        assertEquals("Pizza{cheese=100, bacon=200, pineapples=0, mushrooms=0, seafood=0}",
                pizzaWithBacon.toString());

    }
}