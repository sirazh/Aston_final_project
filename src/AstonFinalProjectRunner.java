import java.util.ArrayList;
import java.util.Scanner;

public class AstonFinalProjectRunner {
    public static void main(String[] args) {
        boolean exit = false; // какое-то топорное решение для возможности выйти из цикла, мб можно как-то лучше
        UserInteraction input = new UserInteraction();
        ArrayList<Integer> arr = new ArrayList<>();

        while (!exit){
            int choice = input.getUserChoice("Выберите способ заполнения коллекции:\n" +
                    "1 -- рандомно, 2 -- вручную, 3 -- из файла");

            // выбираем как заполнить коллекцию
            switch (choice){
                case 1:
                    int length1 = input.getUserChoice("\nВведите длину коллекции: ");
                    ArrayUtils.fillArrByRandom(arr, length1);
                    ArrayUtils.printArray(arr);
                    break;
                case 2:
                    // ---- Заполнение коллекции вручную
                    int length2 = input.getUserChoice("\nВведите длину коллекции: ");
                    ArrayUtils.fillArrByInput(arr, length2);
                    ArrayUtils.printArray(arr);
                    break;
                case 3:
                    // ---- Заполнение коллекции из файла
                    ArrayUtils.fillArrByFile(arr);
                    ArrayUtils.printArray(arr);
                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }

            // выбираем как сортировать коллекцию
            choice = input.getUserChoice("\nВыберите способ сортировки:\n" +
                    "1 -- Shell Sort, 2 -- Selection Sort");

            switch (choice){
                case 1:
                    BaseSorting shellSort = new ShellSorting();
                    shellSort.sort(arr);
                    ArrayUtils.printArray(arr);
                    break;
                case 2:
                    BaseSorting selectionSort = new SelectionSorting();
<<<<<<< HEAD

                    // ---- впихнуть метод из SelectionSorting ----
=======
                    selectionSort.sort(arr);
                    ArrayUtils.printArray(arr);
>>>>>>> origin/SelectionSorting
                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }

            choice = input.getUserChoice("\n\nВыйти из цикла? 1 -- да, другой символ -- начать заново");
            if (choice == 1) exit = true;
        }
    }

}
