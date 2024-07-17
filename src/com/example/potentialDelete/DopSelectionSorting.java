package com.example.potentialDelete;

import com.example.BaseSorting;
import com.example.strategy.DopSelectionSortStrategy;

public class DopSelectionSorting extends BaseSorting {
    public DopSelectionSorting(){
        super();
        super.setSortableStrategy(new DopSelectionSortStrategy());
    }
}
