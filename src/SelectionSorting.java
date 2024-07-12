import strategy.SelectionSortStrategy;

public class SelectionSorting extends BaseSorting {

    SelectionSorting(){
        super();
        super.setSortableStrategy(new SelectionSortStrategy());
    }
}
