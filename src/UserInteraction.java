import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner;

    public UserInteraction(){
        scanner = new Scanner(System.in);
    }

    public int getUserChoice(String message){
        System.out.println(message);
        return scanner.nextInt();
    }

}