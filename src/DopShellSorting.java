import strategy.DopShellSortingStrategy;
import strategy.ShellSortingStrategy;

public class DopShellSorting extends BaseSorting {
    public DopShellSorting() {
        super();
        super.setDopSortableStrategy(new DopShellSortingStrategy());
    }
}
