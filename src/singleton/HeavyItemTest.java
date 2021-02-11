package singleton;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HeavyItemTest {

    private HeavyItem heavyItem = null;

    @TestFactory
    public Collection<DynamicTest> dynamicTests() {
        ArrayList<DynamicTest> tests = new ArrayList<>();

        tests.add(DynamicTest.dynamicTest("Get all limit of instances",
                () -> {
                    for (int i = 0; i < HeavyItem.ITEM_LIMIT; i++) {
                        heavyItem = HeavyItem.getInstance();
                        assertEquals(String.format("HeavyItem{instanceNumber=%d}", i), heavyItem.toString());
                    }
                }));

        tests.add(DynamicTest.dynamicTest("Limit is exceeded, returns null",
                () -> assertNull(HeavyItem.getInstance())));

        tests.add(DynamicTest.dynamicTest("Free one of the item go be able to take it again",
                () -> {
                    HeavyItem.free(heavyItem);
                    assertEquals(String.format("HeavyItem{instanceNumber=%d}", HeavyItem.ITEM_LIMIT - 1),
                            HeavyItem.getInstance().toString());
                }));
        return tests;
    }
}