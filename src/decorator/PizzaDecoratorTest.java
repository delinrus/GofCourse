package decorator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static decorator.PizzaComponent.MUSHROOMS;
import static decorator.PizzaComponent.SEAFOOD;
import static org.junit.Assert.assertEquals;

public class PizzaDecoratorTest {

    @Test
    public void noComponents() {
        Pizza pizza = PizzaBuilder.build(null);
        assertEquals("Pizza containing:", pizza.getDescription());
    }

    @Test
    public void singleComponent() {
        List<PizzaComponent> componentList = Collections.singletonList(MUSHROOMS);
        Pizza pizza = PizzaBuilder.build(componentList);
        assertEquals("Pizza containing: MUSHROOMS;", pizza.getDescription());
    }

    @Test
    public void fewComponents() {
        List<PizzaComponent> componentList = Arrays.asList(MUSHROOMS, SEAFOOD);
        Pizza pizza = PizzaBuilder.build(componentList);
        assertEquals("Pizza containing: MUSHROOMS; SEAFOOD;", pizza.getDescription());
    }
}