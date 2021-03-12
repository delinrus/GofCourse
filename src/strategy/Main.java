package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> initialList = Arrays.asList(6, 7, 2, 5, 9, 9, 0);
        System.out.println("Initial data:");
        System.out.println(initialList);

        List<Integer> list1 = new ArrayList<>(initialList);
        Sorter sorter = new Sorter(new FastSorting());
        sorter.sort(list1);
        System.out.println("Fast Soring:");
        System.out.println(list1);

        List<Integer> list2 = new ArrayList<>(initialList);
        sorter.setStrategy(new BubbleSorting());
        sorter.sort(list2);
        System.out.println("Bubble sorting:");
        System.out.println(list2);
    }
}
