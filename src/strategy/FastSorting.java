package strategy;

import java.util.List;

public class FastSorting implements SortingStrategy {

    @Override
    public void sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<Integer> source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source.get((leftMarker + rightMarker) / 2);
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source.get(leftMarker) < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source.get(rightMarker) > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source.get(leftMarker);
                    source.set(leftMarker, source.get(rightMarker));
                    source.set(rightMarker, tmp);
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}
