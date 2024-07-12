import java.util.Scanner;

public class AstonFinalProjectRunner {
    //  Задачи:
    // 1) Сделать варианты заполнения массива и выбора длины
    // Рандомить / вручную / из файла
    public static void main(String[] args) {
        int length;

        boolean exit = false; // нужно как-то обойти это магическое число
        Scanner input = new Scanner(System.in);

        System.out.println("Чтобы выйти из цикла нажмите восклицательный знак");

        while (!exit) {
            System.out.print("Укажите длину массива: ");
            int choice = input.nextInt();
            length = choice;

            int[] array = new int[length]; // возможны лишние создания массива

            System.out.println("Выберите способ заполнения данных: 1 -- рандом, 2 -- из файла, 3 -- вручную");
            choice = input.nextInt();

            switchCases(choice, array, length);

//            for (Integer val: array){
//                System.out.println(val); ---- результат randomData(int[] array) сохраняется ----
//            }


//              ---- вот сюда бы выбор алгоритма + метод с алгоритмом, ну и может быть currentTimeMillis вывести ----


            System.out.println("\n\nВыйти из цикла? 1 -- да, любой другой символ -- начать заново: ");
            choice = input.nextInt();
            if (choice == 1) exit = true;

        }
    }

    public static void switchCases(int choice, int[] array, int length) {
        switch (choice) {
            case 1:
                System.out.printf("Выбран рандомный способ заполнения данных. " +
                        "Заполненный массива, длиной %d элементов: \n", length);

                randomData(array);
                printArray(array);

                break;

            case 2:
                    /*
                        ----- метод чтения из файла и заполнения массива array -----
                     */
                break;

            case 3:
                    /*
                        ---- метод чтения вводимых данных и заполнения ими массива ----
                     */
                break;
        }
    }
    private static int[] randomData ( int[] arr){

        for (int i = 0; i < arr.length; i++) {
            // диапазон [-100; 100] для значений чисел
            arr[i] = (int) (Math.random() * 200 - 100);
        }

        return arr;
    }
    private static void printArray(int[] arr){
        for (Integer val: arr){
            System.out.print(val + " ");
        }
    }
}
