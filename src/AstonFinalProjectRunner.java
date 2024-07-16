import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AstonFinalProjectRunner {
    public static void main(String[] args) {
        boolean exit = false; // TODO: какое-то топорное решение для возможности выйти из цикла, мб можно как-то лучше
        UserInteraction input = new UserInteraction();
        ArrayList<Integer> arr = new ArrayList<>();

        String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);


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
                    selectionSort.sort(arr);
                    ArrayUtils.printArray(arr);

                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }

            choice = input.getUserChoice("\n\nВыйти из цикла? 1 -- да, другой символ -- начать заново");
            if (choice == 1) exit = true;
        }

        // TODO: возможно есть менее топорное решение
        input.closeScanner();
    }
//    int age = Integer.parseInt(validatedData(sc, "[0-9]+"));
//    String name = validatedData(sc, "[a-zA-Z]+");
//    static String validatedData(Scanner sc, String pattern) {
//        String result = null;
//        while (sc.hasNextLine()) {
//            try {
//                result = sc.next(pattern);
//                System.out.println("Correct," + result);
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("Incorrect. Try again");
//                sc.nextLine();
//            }
//        }
//        return result;
//    }

}
