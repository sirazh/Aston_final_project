package strategy;

import java.util.ArrayList;

public class ShellSortingStrategy implements SortableStrategy{
    @Override
    public void sort(ArrayList<Integer> array) {
        int n = array.size();
        // Начальное значение для разрыва
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Выполняем сортировку вставками для элементов, которые находятся на расстоянии gap друг от друга
            for (int i = gap; i < n; i++) {
                int temp = array.get(i);
                int j;
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    array.set(j, array.get(j - gap));
                }
                array.set(j, temp);
            }
        }
    }
}
