package com.example.potentialDelete;

import com.example.BaseSorting;
import com.example.strategy.ShellSortingStrategy;

public class ShellSorting extends BaseSorting {

    public ShellSorting() {
        super();
        super.setSortableStrategy(new ShellSortingStrategy());
    }
}
