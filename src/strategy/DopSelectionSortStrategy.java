package strategy;

import java.util.ArrayList;
import java.util.Collections;

public class DopSelectionSortStrategy implements SortableStrategy{
    @Override
    public void sort(ArrayList<Integer> array) {
        ArrayList<Integer> copy = array;
         //создаем отдельный массив для четных
        ArrayList<Integer> sortedEven = new ArrayList<>();

        int min = Collections.min(array);

        //кладем в них четные числа
        for(int i =0; i<array.size(); i++){
             if(array.get(i)%2 == 0){
                 sortedEven.add(array.get(i));
                 array.set(i, min-1);
             }
        }


        //сортиурем выбором оба массива
        for(int i = 0; i < sortedEven.size(); i++){
            int minElementIndex = findMinElementIndex(sortedEven, i);
            int tmp = sortedEven.get(i);
            sortedEven.set(i, sortedEven.get(minElementIndex));
            sortedEven.set(minElementIndex,tmp);
        }


        //возвращаем обратно
        for (Integer integer : sortedEven) {
            for (int j = 0; j < array.size(); j++) {
                if (array.get(j) == min - 1) {
                    array.set(j, integer);
                    break;
                }
            }
        }
        System.out.println("сортировка четных чисел Selection Sorting");
        System.out.println(array);
    }

    //поиск индекса минимального элемента части массива, где [start] - индекс начала поиска
    public static int findMinElementIndex(ArrayList<Integer> array, int start){
        int minIndex = start;
        int minValue = array.get(start);
        for(int i = start + 1; i < array.size(); i++){
            if(array.get(i) < minValue){
                minValue = array.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

}
