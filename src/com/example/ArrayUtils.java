package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayUtils {
    // возможно понадобится отдельный приватный метод для заполнения коллекции,
    // чтобы не копипастить код заполнения во все методы


    public static ArrayList<Integer> fillArrByRandom(ArrayList<Integer> arr, int length) {
//   arr.size() вернёт 0, т.к. коллекция пустая, поэтому передаём длину, которую задал юзер
        for (int i = 0; i < length; i++) {
            // диапазон [-100; 100] для значений чисел
            arr.add((int) (Math.random() * 200 - 100));
        }

        return arr;
    }

    // --------------------------------- РУЧНОй ВВОД ------------------------------------
    public static ArrayList<Integer> fillArrByInput(ArrayList<Integer> arr, int length) {
        System.out.println("Вводите каждый элемент с новой строки: ");

        // try-with-resources закрывает поток ввода везде, поэтому мы закроем его сами в конце мейна
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int counter = 0;
            while (counter < length) {
                try {
                    System.out.print("Введите число " + (counter + 1) + ": ");
                    arr.add(Integer.parseInt(br.readLine())); // добавляем элементы в коллекцию
                    counter++;
                } catch (NumberFormatException e) {
                    System.out.println("Введено некорректное число. Пожалуйста, попробуйте еще раз.");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
        return arr;
    }

    // ------------------------ ЗАПОЛНЕНИЕ КОЛЛЕКЦИИ ИЗ ФАЙЛА ------------------------------------
    public static ArrayList<Integer> fillArrByFile(ArrayList<Integer> arr) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        File file;

        while (true) {
            System.out.println("Введите имя файла:");
            fileName = scanner.nextLine();
            file = new File(fileName);

            if (!file.exists() || !file.isFile()) {
                System.out.println("Файл не найден: " + fileName);
            } else {
                break;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    arr.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректная строка в файле, пропуск: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + fileName);
        }

        return arr;
    }

    public static <T> void printArray(ArrayList<T> arr) {
        System.out.println("\nЭлементы коллекции:");
        for (T val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    // после реализации функции, нужно будет подумать, как и где его впихнуть в бизнес-логику
    private boolean validateData() {
        boolean valid = false;

        // ----- логика для валидации

        return valid;
    }


}
