package bridge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DessertCafeTest extends BasicCafeTest {

    @Test
    public void test() {
        String expected = String.format("The %s have been served as a dessert", dessert);
        DessertCafe cafe = new DessertCafe(cuisine);
        assertEquals(expected, cafe.serve());
    }

}