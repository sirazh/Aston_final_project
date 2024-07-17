import java.util.ArrayList;
import java.util.Arrays;


public class AstonFinalProjectRunner {
    public static void main(String[] args) {
        boolean exit = false; // TODO: какое-то топорное решение для возможности выйти из цикла, мб можно как-то лучше
        UserInteraction input = new UserInteraction();
        ArrayList<Integer> arr = new ArrayList<>();
        boolean sortUsers  = false;


        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User.UserBuilder()
                        .setAge(30)
                        .setName("Masha")
                        .build(),
                new User.UserBuilder()
                        .setAge(4)
                        .setName("Pasha")
                        .build(),
                new User.UserBuilder()
                        .setAge(15)
                        .setName("Petya")
                        .build()
        ));


        while (!exit){
            int choice = input.getUserChoice("Выберите способ заполнения коллекции:\n" +
                    "1 -- рандомно, 2 -- вручную, 3 -- из файла, 4 -- сортировка объектов User");

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
                case 4:
                    sortUsers = true;
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
                    if (!sortUsers){
                        shellSort.sort(arr);
                        ArrayUtils.printArray(arr);
                    }
                    if (sortUsers) {
                        shellSort.sort(users);
                        ArrayUtils.printArray(users);
                    }
                    sortUsers = false;
                    break;
                case 2:
                    BaseSorting selectionSort = new SelectionSorting();
                    if (sortUsers == false) {
                        selectionSort.sort(arr);
                        ArrayUtils.printArray(arr);
                    }
                    if (sortUsers == true){
                        selectionSort.sort(users);
                        ArrayUtils.printArray(users);
                    }
                    sortUsers = false;
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
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("Incorrect. Try again");
//                sc.nextLine();
//            }
//        }
//        return result;
//    }

}
