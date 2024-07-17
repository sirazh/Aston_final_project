package com.example.strategy;

import com.example.User;

import java.util.ArrayList;

public class DopSelectionSortStrategy<T extends Comparable<T>> implements SortableStrategy<T>{
    @Override
    public void sort(ArrayList<T> array) {
        int n = array.size();

        // Сортируем только четные числа
        for (int i = 0; i < n - 1; i++) {
            if (!isEven(array.get(i))) {
                continue; // Пропускаем нечетные числа
            }

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (!isEven(array.get(j))) {
                    continue; // Пропускаем нечетные числа
                }
                if (array.get(j).compareTo(array.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // меняем местами эл-нт с эл-нтом, у которого индекс i
            if (minIndex != i) {
                T temp = array.get(minIndex);
                array.set(minIndex, array.get(i));
                array.set(i, temp);
            }
        }
    }

    // проверка четности
    private boolean isEven(T value) {
        if (value instanceof Integer) {
            return (Integer) value % 2 == 0;
        } else if (value instanceof User) {
            return ((User) value).getAge() % 2 == 0;
        } else {
            throw new IllegalArgumentException("Тип значения должен быть целым числом или объектом класса Юзер");
        }
    }
}
