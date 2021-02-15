package bridge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectiveCafeTest extends BasicCafeTest {

    @Test
    public void test() {
        String expected = String.format("The %s have been served as a dessert", dessert);
        SelectiveCafe cafe = new SelectiveCafe(cuisine);
        assertEquals(expected, cafe.serveOnlyDesert());
    }

}