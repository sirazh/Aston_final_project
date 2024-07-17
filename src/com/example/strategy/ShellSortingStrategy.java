package com.example.strategy;

import java.util.ArrayList;

public class ShellSortingStrategy<T extends Comparable<T>> implements SortableStrategy<T> {

    @Override
    public void sort(ArrayList<T> array) {
        int n = array.size();
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                T temp = array.get(i);
                int j = i;
                while (j >= gap && array.get(j - gap).compareTo(temp) > 0) {
                    array.set(j, array.get(j - gap));
                    j -= gap;
                }
                array.set(j, temp);
            }
            gap /= 2;
        }
    }
}
