package com.example.strategy;

import java.util.ArrayList;

public class SelectionSortStrategy<T extends Comparable<T>> implements SortableStrategy<T> {
    @Override
    public void sort(ArrayList<T> array) {
        int n = array.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array.get(j).compareTo(array.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = array.get(minIndex);
            array.set(minIndex, array.get(i));
            array.set(i, temp);
        }
    }

    //поиск индекса минимального элемента части массива, где [start] - индекс начала поиска
//    private int findMinElementIndex(ArrayList<Integer> array, int start){
//        int minIndex = start;
//        int minValue = array.get(start);
//        for(int i = start + 1; i < array.size(); i++){
//            if(array.get(i) < minValue){
//                minValue = array.get(i);
//                minIndex = i;
//            }
//        }
//        return minIndex;
//    }

}
