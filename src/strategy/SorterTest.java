package strategy;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorterTest {
    List<Integer> initialList = Arrays.asList(6, 7, 2, 5, 9, 9, 0);

    @Test
    public void sortingIsCorrectUsingFastSorting() {
        List<Integer> list1 = new ArrayList<>(initialList);
        Sorter sorter = new Sorter(new FastSorting());
        sorter.sort(list1);
        assertEquals(Arrays.asList(0, 2, 5, 6, 7, 9, 9), list1);
    }

    @Test
    public void sortingIsCorrectUsingBubbleSorting() {
        List<Integer> list1 = new ArrayList<>(initialList);
        Sorter sorter = new Sorter(new BubbleSorting());
        sorter.sort(list1);
        assertEquals(Arrays.asList(0, 2, 5, 6, 7, 9, 9), list1);
    }

    @Test
    public void changingSoringStrategyOnTheFly() {
        List<Integer> list1 = new ArrayList<>(initialList);
        Sorter sorter = new Sorter(new FastSorting());

        FakeSorter fakeSorter = new FakeSorter();
        sorter.setStrategy(fakeSorter);
        assertFalse(fakeSorter.isSortCalled);
        sorter.sort(list1);
        assertTrue(fakeSorter.isSortCalled);
    }

    @Test
    public void comparingSortingTime() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        Sorter sorter = new Sorter(new FastSorting());
        long fastSortingTime = calculateSortingTime( () -> sorter.sort(new ArrayList<>(list)));
        System.out.println("Fast sorting time " + fastSortingTime);

        sorter.setStrategy(new BubbleSorting());
        long bubbleSortingTime = calculateSortingTime( () -> sorter.sort(new ArrayList<>(list)));
        System.out.println("Bubble sorting time " + bubbleSortingTime);

        assertTrue(bubbleSortingTime > fastSortingTime);
    }

    private long calculateSortingTime(Runnable runnable) {
        long initialTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - initialTime;
    }

    private static class FakeSorter implements SortingStrategy {
        private boolean isSortCalled = false;

        @Override
        public void sort(List<Integer> list) {
            isSortCalled = true;
        }

        public boolean isSortCalled() {
            return isSortCalled;
        }
    }
}