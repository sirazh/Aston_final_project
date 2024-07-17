package strategy;

import java.util.ArrayList;

public interface SortableStrategy<T extends Comparable<T>> {
    void sort(ArrayList<T> array);
}
