import strategy.SortableStrategy;

import java.util.ArrayList;

abstract class BaseSorting<T extends Comparable<T>> {
    private SortableStrategy<T> sortableStrategy;


    public void sort(ArrayList<T> array){
        sortableStrategy.sort(array);
    }

    public void setSortableStrategy(SortableStrategy<T> sortableStrategy){
        this.sortableStrategy = sortableStrategy;
    }

    protected void validation(){
        // что-то с валидацией
    }
}
