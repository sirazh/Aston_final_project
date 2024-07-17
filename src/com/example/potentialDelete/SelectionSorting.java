package com.example.potentialDelete;

import com.example.BaseSorting;
import com.example.strategy.SelectionSortStrategy;

public class SelectionSorting extends BaseSorting {

    public SelectionSorting(){
        super();
        super.setSortableStrategy(new SelectionSortStrategy());
    }
}
