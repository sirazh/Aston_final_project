import java.util.ArrayList;

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

    public static ArrayList<Integer> fillArrByFile (ArrayList<Integer> arr){

        // -------- логика для данных из файла (+ заполнение коллекции)

        return arr;
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
