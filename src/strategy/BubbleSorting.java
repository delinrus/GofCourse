package strategy;

import java.util.List;

public class BubbleSorting implements SortingStrategy {

    public void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j - 1) > list.get(j)) {
                    int tmp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}