package visitor;

import org.junit.Before;
import org.junit.Test;
import visitor.components.Bacon;
import visitor.components.Cheese;
import visitor.components.Seafood;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {
    private List<Component> componentList;
    private Pizza pizza;

    @Before
    public void setUp() {
        componentList = new ArrayList<>();
        pizza = new Pizza();
    }

    private void testHelper(String expected) {
        Visitor pizzaVisitor = new AddComponentVisitor(pizza);
        componentList.forEach( component -> component.accept(pizzaVisitor));
        assertEquals(expected, pizza.toString());
    }

    @Test
    public void addNoComponents() {
        testHelper("Pizza{cheese=0, bacon=0, pineapples=0, mushrooms=0, seafood=0}");
    }

    @Test
    public void addOneComponent() {
        componentList.add(new Seafood(100));
        testHelper("Pizza{cheese=0, bacon=0, pineapples=0, mushrooms=0, seafood=100}");
    }

    @Test
    public void addTwoComponents() {
        componentList.add(new Bacon(160));
        componentList.add(new Cheese(200));
        testHelper("Pizza{cheese=200, bacon=160, pineapples=0, mushrooms=0, seafood=0}");
    }
}