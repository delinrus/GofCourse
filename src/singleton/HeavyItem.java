package singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HeavyItem {
    public static final int ITEM_LIMIT = 10;

    private static int instanceCounter = 0;

    // If boolean value in the map is true then the item is free to be used again
    private static final ConcurrentHashMap<HeavyItem, Boolean> items = new ConcurrentHashMap<>();

    private final int instanceNumber;

    private HeavyItem(int instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public static synchronized HeavyItem getInstance() {
        // If map contains free item - return it
        for (Map.Entry<HeavyItem, Boolean> entry : items.entrySet()) {
            if (entry.getValue()) {
                items.put(entry.getKey(), false);
                return entry.getKey();
            }
        }

        // If not - create new one
        if (items.size() < ITEM_LIMIT) {
            HeavyItem newItem = new HeavyItem(instanceCounter++);
            items.put(newItem, false);
            return newItem;
        }
        return null;
    }

    public static synchronized void free(HeavyItem item) {
        if (item != null) {
            items.put(item, true);
        }
    }

    @Override
    public String toString() {
        return "HeavyItem{" +
                "instanceNumber=" + instanceNumber +
                '}';
    }
}
