import strategy.ShellSortingStrategy;

public class ShellSorting extends BaseSorting {

    public ShellSorting() {
        super();
        super.setSortableStrategy(new ShellSortingStrategy());
    }
}
