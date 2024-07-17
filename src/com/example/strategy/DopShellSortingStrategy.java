package com.example.strategy;

import com.example.User;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class DopShellSortingStrategy<T extends Comparable<T>> implements SortableStrategy<T> {

    @Override
    public void sort(ArrayList<T> array) {

        //создаем массив с четными числами
        ArrayList<T> tempArray = new ArrayList<>();
        for (T t:array){
            if (isEven(t)){
                tempArray.add(t);
                //меняем на нуллы
                array.set(array.indexOf(t), null);
            }
        }

        int n = tempArray.size();
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                T temp = tempArray.get(i);
                // Пропускаем нечетные числа
                int j = i;
                while (j >= gap && isEven(tempArray.get(j - gap)) && tempArray.get(j - gap).compareTo(temp) > 0) {
                    tempArray.set(j, tempArray.get(j - gap));
                    j -= gap;
                }
                tempArray.set(j, temp);
            }
            gap /= 2;
        }


        for (T t:tempArray){
            for(int i = 0; i< array.size(); i++){
                if(array.get(i) == null){
                    array.set(i,t);
                    break;
                }
            }
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