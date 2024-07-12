import strategy.SortableStrategy;

import java.util.ArrayList;

abstract class BaseSorting {
    private SortableStrategy sortableStrategy;
    private ArrayList<Integer> arrayList;

    public void sort(){
        sortableStrategy.sort();
    }

    public void setSortableStrategy(SortableStrategy sortableStrategy){
        this.sortableStrategy = sortableStrategy;
    }

    protected void validation(){
        // что-то с валидацией
    }
}
