package com.example;

import com.example.strategy.SortableStrategy;

import java.util.ArrayList;

public class BaseSorting<T extends Comparable<T>> {
    private SortableStrategy<T> sortableStrategy;

    public void sort(ArrayList<T> array) {
        sortableStrategy.sort(array);
    }

    public void setSortableStrategy(SortableStrategy<T> sortableStrategy) {
        this.sortableStrategy = sortableStrategy;
    }
}
