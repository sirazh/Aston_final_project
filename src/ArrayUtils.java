import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayUtils {
    // возможно понадобится отдельный приватный метод для заполнения коллекции,
    // чтобы не копипастить код заполнения во все методы


    public static ArrayList<Integer> fillArrByRandom (ArrayList<Integer> arr, int length){
//   arr.size() вернёт 0, т.к. коллекция пустая, поэтому передаём длину, которую задал юзер
        for (int i = 0; i < length; i++) {
            // диапазон [-100; 100] для значений чисел
            arr.add((int) (Math.random() * 200 - 100));
        }

        return arr;
    }

    public static ArrayList<Integer> fillArrByInput (ArrayList<Integer> arr){
        UserInteraction userInteraction = new UserInteraction();

        // -------- логика для вводимых вручную значений (+ заполнение коллекции)


        return arr;
    }

    public static ArrayList<Integer> fillArrByFile (String fileName){

        // -------- логика для данных из файла (+ заполнение коллекции)
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите имя файла:");
//        String fileName = scanner.nextLine();

        ArrayList<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректная строка: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + fileName);
        }

//        System.out.println("Считанный  из файла " + fileName + " массив чисел: " + numbers);
        printArray(numbers);

        return  numbers;
    }

    public static void printArray(ArrayList<Integer> arr){
        System.out.println("\nЭлементы коллекции:");
        for (Integer val: arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }


    // после реализации функции, нужно будет подумать, как и где его впихнуть в бизнес-логику
    private boolean validateData(){
        boolean valid = false;

        // ----- логика для валидации

        return valid;
    }


}
