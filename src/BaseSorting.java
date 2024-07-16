import strategy.DopSortableStrategy;
import strategy.SortableStrategy;

import java.util.ArrayList;

abstract class BaseSorting {
    private SortableStrategy sortableStrategy;
    private DopSortableStrategy dopSortableStrategy;
    private ArrayList<Integer> arrayList;

    public void sort(ArrayList<Integer> array){
        sortableStrategy.sort(array);
    }
    public void dopSort(ArrayList<Integer> array){
        dopSortableStrategy.dopSort(array);
    }

    public void setSortableStrategy(SortableStrategy sortableStrategy){
        this.sortableStrategy = sortableStrategy;
    }

    public void setDopSortableStrategy(DopSortableStrategy dopSortableStrategy){
        this.dopSortableStrategy = dopSortableStrategy;
    }

    protected void validation(){
        // что-то с валидацией
    }
}
