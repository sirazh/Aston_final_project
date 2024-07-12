package strategy;

public class SelectionSortStrategy implements SortableStrategy{
    @Override
    public void sort() {
        System.out.println("Сортировка выбором");
    }
}
