package com.example.potentialDelete;

import com.example.BaseSorting;
import com.example.strategy.DopShellSortingStrategy;

public class DopShellSorting extends BaseSorting {
    public DopShellSorting() {
        super();
        super.setSortableStrategy(new DopShellSortingStrategy());
    }
}
