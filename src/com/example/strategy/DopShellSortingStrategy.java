package com.example.strategy;

import com.example.User;

import java.util.ArrayList;
import java.util.Collections;

public class DopShellSortingStrategy<T extends Comparable<T>> implements SortableStrategy<T> {

    @Override
    public void sort(ArrayList<T> array) {
        // Создаем список для хранения четных чисел и их позиций
        ArrayList<T> evenNumbers = new ArrayList<>();
        ArrayList<Integer> evenPositions = new ArrayList<>(); // TODO заменить фигню

        // Сохраняем четные числа и их позиции
        for (int i = 0; i < array.size(); i++) {
            if (isEven(array.get(i))) {
                evenNumbers.add(array.get(i));
                evenPositions.add(i);
            }
        }

        // Сортируем четные числа
        Collections.sort(evenNumbers);

        // Вставляем отсортированные четные числа обратно в исходный список на свои места
        for (int i = 0; i < evenPositions.size(); i++) {
            array.set(evenPositions.get(i), evenNumbers.get(i));
        }
    }

    // Метод для проверки, является ли число четным
    private boolean isEven(T value) {
        if (value instanceof Integer) {
            return (Integer) value % 2 == 0;
        } else if (value instanceof User) {
            return ((User) value).getAge() % 2 == 0;
        } else {
            throw new IllegalArgumentException("Тип значения должен быть целым числом или объектом класса User");
        }
    }
}
