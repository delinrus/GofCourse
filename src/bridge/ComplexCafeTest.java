package bridge;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ComplexCafeTest extends BasicCafeTest {

    @Test
    public void test() {
        String expected = String.format("The complex dinner of %s, %s, %s, and %s have been served",
                firstDish, secondDish, thirdDish, dessert);
        Cafe cafe = new ComplexCafe(cuisine);
        assertEquals(expected, cafe.serve());
    }

}