package strategy;

import java.util.ArrayList;
import java.util.Collections;

public class DopShellSortingStrategy implements DopSortableStrategy{
    @Override
    public void dopSort(ArrayList<Integer> array) {

        //создаем отдельный массив для четных
        ArrayList<Integer> sortedEven = new ArrayList<>();
        int min = Collections.min(array);

        //кладем в него четные числа
        for(int i =0; i<array.size(); i++){
            if(array.get(i)%2 == 0){
                sortedEven.add(array.get(i));
                array.set(i, min-1);
            }
        }

        //сортироем шеллом
        int n = sortedEven.size();

        // Начальное значение для разрыва
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Выполняем сортировку вставками для элементов, которые находятся на расстоянии gap друг от друга
            for (int i = gap; i < n; i++) {
                int temp = sortedEven.get(i);
                int j;
                for (j = i; j >= gap && sortedEven.get(j - gap) > temp; j -= gap) {
                    sortedEven.set(j, sortedEven.get(j - gap));
                }
                sortedEven.set(j, temp);
            }


        }
        //возвращаем в массив
        for (Integer integer : sortedEven) {
            for (int j = 0; j < array.size(); j++) {
                if (array.get(j) == min - 1) {
                    array.set(j, integer);
                    break;
                }
            }
        }
    }
}
