package com.example.strategy;

import com.example.User;

import java.util.ArrayList;


public class DopShellSortingStrategy<T extends Comparable<T>> implements SortableStrategy<T> {

    @Override
    public void sort(ArrayList<T> array) {
        int n = array.size();
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                T temp = array.get(i);

                // Пропускаем нечетные числа
                if (!isEven(temp)) {
                    continue;
                }

                int j = i;
                while (j >= gap && isEven(array.get(j - gap)) && array.get(j - gap).compareTo(temp) > 0) {
                    array.set(j, array.get(j - gap));
                    j -= gap;
                }
                array.set(j, temp);
            }
            gap /= 2;
        }
    }

    // Метод для проверки, является ли число четным
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