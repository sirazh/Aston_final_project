package strategy;

import java.util.ArrayList;

public class SelectionSortStrategy implements SortableStrategy{
    @Override
    public void sort(ArrayList<Integer> array) {
        for(int i = 0; i < array.size(); i++){
            int minElementIndex = findMinElementIndex(array, i);
            int tmp = array.get(i);

            //меняем минимальный элемент на i-тый
            array.set(i, array.get(minElementIndex));
            array.set(minElementIndex,tmp);
        }
    }

    //поиск индекса минимального элемента части массива, где [start] - индекс начала поиска
    private int findMinElementIndex(ArrayList<Integer> array, int start){
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
