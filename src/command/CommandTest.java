package command;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static command.PizzaComponent.*;
import static org.junit.Assert.assertEquals;

public class CommandTest {

    private Map<PizzaComponent, Integer> customMenu = new HashMap<>();

    @Before
    public void setUp() {
        customMenu = new HashMap<>();
    }

    private void testHelper(String expected) {
        Pizza pizza = new Pizza();
        Invoker invoker = new Invoker();

        for (Map.Entry<PizzaComponent, Integer> entry : customMenu.entrySet()) {
            AddPizzaComponentCommand command = CommandFactory.createCommand(pizza, entry.getKey(), entry.getValue());
            invoker.addCommand(command);
        }
        invoker.execute();
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
}