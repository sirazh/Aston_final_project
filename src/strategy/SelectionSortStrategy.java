package strategy;

import java.util.ArrayList;

public class SelectionSortStrategy implements SortableStrategy{
    @Override
    public void sort(ArrayList<Integer> array) {
        System.out.println("Сортировка выбором");
    }
}
