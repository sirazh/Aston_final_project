import strategy.DopSelectionSortStrategy;

public class DopSelectionSorting extends BaseSorting{
    DopSelectionSorting(){
        super();
        super.setDopSortableStrategy(new DopSelectionSortStrategy());
    }
}
