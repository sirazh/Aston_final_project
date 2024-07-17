import com.example.*;
import com.example.strategy.DopSelectionSortStrategy;
import com.example.strategy.DopShellSortingStrategy;
import com.example.strategy.SelectionSortStrategy;
import com.example.strategy.ShellSortingStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class AstonFinalProjectRunner {
    public static void main(String[] args) {

        boolean exit = false; // TODO: какое-то топорное решение для возможности выйти из цикла, мб можно как-то лучше
        boolean sortUsers = false;

        UserInteraction input = new UserInteraction();

        ArrayList<Integer> intArr = new ArrayList<>();
        BaseSorting<Integer> intBaseSorting = new BaseSorting<>();
        BaseSorting<User> userBaseSorting = new BaseSorting<>();
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
                        .build(),
                new User.UserBuilder()
                        .setAge(7)
                        .setName("Petya")
                        .build(),
                new User.UserBuilder()
                        .setAge(168)
                        .setName("Petya")
                        .build()
        ));


        while (!exit) {
            int choice = input.getUserChoice("Выберите способ заполнения коллекции:\n" +
                    "1 -- рандомно, 2 -- вручную, 3 -- из файла, 4 -- сортировка объектов com.example.User");

            // выбираем как заполнить коллекцию
            switch (choice) {
                case 1:
                    int length1 = input.getUserChoice("\nВведите длину коллекции: ");
                    ArrayUtils.fillArrByRandom(intArr, length1);
                    break;
                case 2:
                    // ---- Заполнение коллекции вручную
                    int length2 = input.getUserChoice("\nВведите длину коллекции: ");
                    ArrayUtils.fillArrByInput(intArr, length2);
                    break;
                case 3:
                    // ---- Заполнение коллекции из файла
                    ArrayUtils.fillArrByFile(intArr);
                    break;
                case 4:
                    sortUsers = true;
                    ArrayUtils.printArray(users);
                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }
            ArrayUtils.printArray(intArr);

            // выбираем как сортировать коллекцию
            choice = input.getUserChoice("\nВыберите способ сортировки:\n" +
                    "1 -- Shell Sort, 2 -- Selection Sort, 3 -- Additional Shell Sort, 4 -- Additional Selection Sort");

            switch (choice) {
                case 1:
                    if (!sortUsers) {
                        intBaseSorting.setSortableStrategy(new ShellSortingStrategy<>());
                        intBaseSorting.sort(intArr);
                        ArrayUtils.printArray(intArr);
                    }
                    if (sortUsers) {
                        userBaseSorting.setSortableStrategy(new ShellSortingStrategy<>());
                        userBaseSorting.sort(users);
                        ArrayUtils.printArray(users);
                    }
                    sortUsers = false;
                    break;
                case 2:
                    if (!sortUsers) {
                        intBaseSorting.setSortableStrategy(new SelectionSortStrategy<>());
                        intBaseSorting.sort(intArr);
                        ArrayUtils.printArray(intArr);
                    }
                    if (sortUsers) {
                        userBaseSorting.setSortableStrategy(new SelectionSortStrategy<>());
                        userBaseSorting.sort(users);
                        ArrayUtils.printArray(users);
                    }
                    sortUsers = false;
                    break;

                case 3:
                    if (!sortUsers) {
                        intBaseSorting.setSortableStrategy(new DopShellSortingStrategy<>());
                        intBaseSorting.sort(intArr);
                        ArrayUtils.printArray(intArr);
                    }
                    if (sortUsers) {
                        userBaseSorting.setSortableStrategy(new SelectionSortStrategy<>());
                        userBaseSorting.sort(users);
                        ArrayUtils.printArray(users);
                    }
                    sortUsers = false;
                    break;

                case 4:
                    if (!sortUsers) {
                        intBaseSorting.setSortableStrategy(new DopSelectionSortStrategy<>());
                        intBaseSorting.sort(intArr);
                        ArrayUtils.printArray(intArr);
                    }
                    if (sortUsers) {
                        userBaseSorting.sort(users);
                        ArrayUtils.printArray(users);
                    }
                    sortUsers = false;
                    break;
                default:
                    System.out.println("Нет такого варианта");
                    return;
            }

            intArr.clear();
            choice = input.getUserChoice("\n\nВыйти из цикла? 1 -- да, другой символ -- начать заново");
            if (choice == 1) exit = true;
        }

        // TODO: возможно есть менее топорное решение
        input.closeScanner();
    }

}
