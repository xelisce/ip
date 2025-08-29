import java.util.Scanner;

public class ActionManager {

    public static void mainLoop() {
        Scanner in = new Scanner(System.in);
        String userInput; // how do i get rid of this line
        while (true) {
            userInput = in.nextLine();
            if (userInput.equals("bye")) {
                return;
            }
            doAction(userInput);
        }
    }

    public static void doAction(String userInput) {
        Parser.parseInput(userInput);
    }
}
