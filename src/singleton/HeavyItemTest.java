package singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HeavyItemTest {

    @Test
    public void test() {
        HeavyItem heavyItem = null;

        // Get all limit of instances
        for (int i = 0; i < HeavyItem.ITEM_LIMIT; i++) {
            heavyItem = HeavyItem.getInstance();
            assertEquals(String.format("HeavyItem{instanceNumber=%d}", i), heavyItem.toString());
        }

        // Limit is exceeded, returns null
        assertNull(HeavyItem.getInstance());

        // Free one of the item go be able to take it again
        HeavyItem.free(heavyItem);
        assertEquals(String.format("HeavyItem{instanceNumber=%d}", HeavyItem.ITEM_LIMIT - 1),
                HeavyItem.getInstance().toString());
    }
}