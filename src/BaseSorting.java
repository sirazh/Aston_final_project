import strategy.SortableStrategy;

import java.util.ArrayList;

class BaseSorting {
    private SortableStrategy sortableStrategy;

    // Constructor
    public BaseSorting() {
    }

    public void sort(ArrayList<Integer> array){
        sortableStrategy.sort(array);
    }

    public void setSortableStrategy(SortableStrategy sortableStrategy){
        this.sortableStrategy = sortableStrategy;
    }

    }
