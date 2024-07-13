import java.util.ArrayList;
import java.util.Scanner;

public class AstonFinalProjectRunner {
    public static void main(String[] args) {
        boolean exit = false; // какое-то топорное решение для возможности выйти из цикла, мб можно как-то лучше
        UserInteraction input = new UserInteraction();
        ArrayList<Integer> arr = new ArrayList<>();

        while (!exit){
            int choice = Integer.parseInt(input.getUserChoice("Выберите способ заполнения коллекции:\n" +
                    "1 -- рандомно, 2 -- вручную, 3 -- из файла"));

            // выбираем как заполнить коллекцию
            switch (choice){
                case 1:
                    int length1 = Integer.parseInt(input.getUserChoice("\nВведите длину коллекции: "));
                    ArrayUtils.fillArrByRandom(arr, length1);
                    ArrayUtils.printArray(arr);
                    break;
                case 2:

                    // ---- красиво впихнуть метод из ArrayUtils
                    String fileName = input.getUserChoice("\nВведите полное имя файла (включая путь): ");
                    ArrayUtils.fillArrByFile(fileName);


                    break;
                case 3:

                    // ---- красиво впихнуть метод из ArrayUtils


                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }

            choice = Integer.parseInt(input.getUserChoice("\nВыберите способ сортировки:\n" +
                    "1 -- Shell Sort, 2 -- Selection Sort"));

            // выбираем как сортировать коллекцию
            switch (choice){
                case 1:
                    BaseSorting shellSort = new ShellSorting();
                    shellSort.sort(arr);
                    ArrayUtils.printArray(arr);
                    break;
                case 2:
                    BaseSorting selectionSort = new SelectionSorting();

                    // ---- впихнуть метод из SelectionSorting ----

                    ArrayUtils.printArray(arr);
                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }

            choice = Integer.parseInt(input.getUserChoice("\n\nВыйти из цикла? 1 -- да, другой символ -- начать заново"));
            if (choice == 1) exit = true;
        }
    }

}
