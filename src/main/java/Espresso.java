import java.util.Scanner;

public class Espresso {

    private static void banner() {
        System.out.println("\n" + Display.LOGO);
    }

    private static void greeting() {
        Display.print("Hello! I'm ESPRESSO", "What can I do for you today?");
    }

    private static void bye() {
        Display.print("Bye. Hope to see you again soon!");
    }

    public static void action(String userInput) {
        Display.print(userInput);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        banner();
        greeting();
        String userInput = in.nextLine();
        while (!userInput.equals("bye")) {
            action(userInput);
            userInput = in.nextLine();
        }
        bye();
    }
}
