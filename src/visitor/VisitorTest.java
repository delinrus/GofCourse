package visitor;

import org.junit.Before;
import org.junit.Test;
import visitor.components.BaconVisitor;
import visitor.components.CheeseVisitor;
import visitor.components.Seafood;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTest {
    private Pizza pizza;

    @Before
    public void setUp() {
        pizza = new Pizza();
    }

    private void testHelper(String expected) {
        pizza.cook();
        assertEquals(expected, pizza.toString());
    }

    @Test
    public void addNoComponents() {
        testHelper("Pizza{cheese=0, bacon=0, pineapples=0, mushrooms=0, seafood=0}");
    }

    @Test
    public void addOneComponent() {
        pizza.addComponent(new Seafood(100));
        testHelper("Pizza{cheese=0, bacon=0, pineapples=0, mushrooms=0, seafood=100}");
    }

    @Test
    public void addTwoComponents() {
        pizza.addComponent(new BaconVisitor(160));
        pizza.addComponent(new CheeseVisitor(200));
        testHelper("Pizza{cheese=200, bacon=160, pineapples=0, mushrooms=0, seafood=0}");
    }
}